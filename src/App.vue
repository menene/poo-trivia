<script setup>
import { computed, onMounted, onUnmounted, ref, watch } from 'vue'
import firstGodOptions from './godOptions.json'
import secondGodOptions from './godOptionsPart2.json'
import { createStudyGroups, recordStudyAnswer, moveStudyIndex } from './studyGroups.js'

const props = defineProps({ banks: { type: Object, required: true } })
const storageKey = 'trivia-poo-game-v3'
const groupsByPart = {
  1: createStudyGroups(props.banks[1]),
  2: createStudyGroups(props.banks[2]),
}
const emptyGame = () => ({ mode: null, groupId: null, index: 0, score: 0, answers: {}, answered: false,
  selected: null, timedOut: false, deadline: null })
const validGame = (data, part) => data && ['study', 'god'].includes(data.mode) &&
  (data.mode === 'god' || (groupsByPart[part].some(group => group.id === data.groupId) &&
    data.answers && typeof data.answers === 'object')) &&
  Number.isInteger(data.index) && data.index >= 0 &&
  Number.isInteger(data.score) && data.score >= 0
function readStored(key) {
  try {
    return JSON.parse(sessionStorage.getItem(key))
  } catch { return null }
}
const saved = readStored(storageKey) || readStored('trivia-poo-game-v2')
const previousGame = readStored('trivia-poo-game-v1')
const activePart = ref([1, 2].includes(saved?.activePart) ? saved.activePart : 1)
const sessions = ref({
  1: validGame(saved?.sessions?.[1], 1) ? saved.sessions[1] : validGame(previousGame, 1) ? previousGame : emptyGame(),
  2: validGame(saved?.sessions?.[2], 2) ? saved.sessions[2] : emptyGame(),
})
const game = computed({
  get: () => sessions.value[activePart.value],
  set: value => { sessions.value[activePart.value] = value },
})
const now = ref(Date.now())
let timerId

const questions = computed(() => props.banks[activePart.value])
const studyGroups = computed(() => groupsByPart[activePart.value])
const studySections = computed(() => {
  const sections = new Map()
  for (const group of studyGroups.value) {
    if (!sections.has(group.topic)) sections.set(group.topic, [])
    sections.get(group.topic).push(group)
  }
  return [...sections].map(([topic, groups]) => ({ topic, groups }))
})
const group = computed(() => studyGroups.value.find(item => item.id === game.value.groupId))
const godOptions = computed(() => activePart.value === 1 ? firstGodOptions : secondGodOptions)
const godQuestions = computed(() => questions.value.filter(q => Object.hasOwn(godOptions.value, q.id)))
const currentSet = computed(() => game.value.mode === 'god'
  ? godQuestions.value
  : group.value?.questions || [])
const total = computed(() => currentSet.value.length)
const finished = computed(() => game.value.mode && game.value.index >= total.value)
const question = computed(() => finished.value ? null : currentSet.value[game.value.index])
const category = computed(() => question.value?.prompt.match(/^(UML|Concepto|Revisión de código|Explicación de código) · /)?.[1] || null)
const displayPrompt = computed(() => category.value ? question.value.prompt.slice(category.value.length + 3) : question.value?.prompt || '')
const promptSegments = computed(() => displayPrompt.value.split(/(`[^`]+`)/g)
  .filter(Boolean).map(part => ({ code: part.startsWith('`'), text: part.startsWith('`') ? part.slice(1, -1) : part })) || [])
const spec = computed(() => question.value ? godOptions.value[question.value.id] : null)
const percent = computed(() => total.value ? Math.floor(game.value.score * 100 / total.value) : 0)
const markedCount = computed(() => Object.keys(game.value.answers || {}).length)
const seconds = computed(() => game.value.deadline ? Math.max(0, Math.ceil((game.value.deadline - now.value) / 1000)) : 10)
const progress = computed(() => total.value ? game.value.index * 100 / total.value : 0)

function startStudy(selectedGroup) {
  game.value = { ...emptyGame(), mode: 'study', groupId: selectedGroup.id }
  window.scrollTo(0, 0)
}
function startGod() {
  game.value = { ...emptyGame(), mode: 'god', deadline: Date.now() + 10000 }
  now.value = Date.now()
  window.scrollTo(0, 0)
}
function home() {
  game.value = emptyGame()
  window.scrollTo(0, 0)
}
function selectPart(part) {
  activePart.value = part
  tick()
  window.scrollTo(0, 0)
}
function studyAnswer(knew) {
  if (!question.value || game.value.mode !== 'study') return
  game.value = { ...recordStudyAnswer(game.value, question.value.id, knew), index: game.value.index + 1 }
  window.scrollTo(0, 0)
}
function moveStudy(offset) {
  if (game.value.mode !== 'study') return
  game.value = { ...game.value, index: moveStudyIndex(game.value.index, offset, total.value) }
  window.scrollTo(0, 0)
}
function godAnswer(timedOut = false) {
  if (!question.value || game.value.mode !== 'god' || game.value.answered) return
  const expired = timedOut || Date.now() >= game.value.deadline
  const correct = !expired && game.value.selected === spec.value.correctOption
  if (!expired && game.value.selected === null) return
  game.value = { ...game.value, answered: true, timedOut: expired,
    selected: expired ? null : game.value.selected, score: game.value.score + Number(correct) }
}
function nextGod() {
  if (!game.value.answered) return
  const index = game.value.index + 1
  game.value = { ...game.value, index, answered: false, selected: null, timedOut: false,
    deadline: index < total.value ? Date.now() + 10000 : null }
  now.value = Date.now()
  window.scrollTo(0, 0)
}
function tick() {
  now.value = Date.now()
  if (game.value.mode === 'god' && !finished.value && !game.value.answered &&
    now.value >= game.value.deadline) godAnswer(true)
}
watch([sessions, activePart], () => sessionStorage.setItem(storageKey,
  JSON.stringify({ activePart: activePart.value, sessions: sessions.value })), { deep: true })
onMounted(() => {
  tick()
  timerId = window.setInterval(tick, 100)
})
onUnmounted(() => window.clearInterval(timerId))
</script>

<template>
  <nav class="exam-tabs" aria-label="Parcial">
    <button v-for="part in [1, 2]" :key="part" type="button" :class="{ active: activePart === part }"
      :aria-current="activePart === part ? 'page' : undefined" @click="selectPart(part)">Parcial {{ part }}</button>
  </nav>
  <main v-if="!game.mode" class="shell home">
    <div class="eyebrow">CC2008 · PARCIAL {{ activePart }}</div>
    <h1>{{ activePart === 1 ? 'La gran trivia' : 'La trivia continúa' }}<br><span>de POO</span></h1>
    <p class="lead">{{ activePart === 1 ? 'Repasa la guía original por tema en rondas cortas. Revela la respuesta cuando quieras y avanza a tu ritmo.' : 'Practica arrays, ArrayLists, diseño de POO, herencia, polimorfismo e interfaces. Elige un tema y una ronda de 25 preguntas.' }}</p>
    <div class="stats"><div><strong>{{ questions.length }}</strong><small>preguntas</small></div><div><strong>{{ studySections.length }}</strong><small>temas</small></div><div><strong>{{ studyGroups.length }}</strong><small>rondas</small></div></div>
    <div class="topic-list">
      <section v-for="section in studySections" :key="section.topic" class="topic-section">
        <h2>{{ section.topic }}</h2>
        <div class="topic-rounds">
          <button v-for="round in section.groups" :key="round.id" class="level-card" type="button" @click="startStudy(round)">
            <span class="level-number">{{ String(round.round).padStart(2, '0') }}</span>
            <span class="level-copy"><b>Ronda {{ round.round }}</b><small>Preguntas {{ round.start }}–{{ round.end }} de {{ round.topicTotal }}</small></span>
            <em>{{ round.questions.length }} preguntas</em><span class="arrow">→</span>
          </button>
        </div>
      </section>
      <button class="level-card god-card" type="button" @click="startGod"><span class="level-number">⚡</span><span class="level-copy"><b>God Mode</b><small>{{ godQuestions.length }} preguntas {{ activePart === 1 ? 'expertas' : 'de todos los temas' }} · 10 segundos por pregunta</small></span><em>10s</em><span class="arrow">→</span></button>
    </div>
    <p class="hint">{{ activePart === 1 ? 'Sin registro · Las respuestas vienen de tu guía original' : 'Sin registro · Preguntas de práctica para el segundo parcial' }}</p>
  </main>

  <main v-else-if="finished" class="shell results" :class="{ 'god-results': game.mode === 'god' }">
    <div class="eyebrow">PARCIAL {{ activePart }} · {{ game.mode === 'god' ? 'GOD MODE' : `${group.topic} · RONDA ${group.round}` }} · PARTIDA TERMINADA</div>
    <h1 v-if="game.mode === 'god'">¿Qué tan<br><span>rápido piensas?</span></h1>
    <h1 v-else>Tu resultado<br><span>está aquí.</span></h1>
    <div class="score-card"><strong>{{ game.score }} / {{ total }}</strong><span>{{ game.mode === 'god' ? 'respuestas correctas bajo presión' : 'conceptos dominados' }}</span><div v-if="game.mode === 'study'" class="marked-count">{{ markedCount }} de {{ total }} preguntas evaluadas</div><div class="big-percent">{{ percent }}%</div></div>
    <p v-if="game.mode === 'god'" class="lead">{{ percent >= 80 ? (activePart === 1 ? 'Nivel experto superado. Tu modelo mental de Java está afilado.' : '¡Excelente! Dominas los conceptos del segundo parcial bajo presión.') : 'El modo experto es para detectar huecos. Vuelve a los niveles y fortalece esos conceptos.' }}</p>
    <p v-else class="lead">{{ markedCount < total ? 'Puedes volver a las preguntas sin evaluar o elegir otra ronda.' : percent >= 80 ? '¡Excelente! Tienes una base muy sólida para el parcial.' : 'Buen trabajo. Revisa las explicaciones y vuelve a intentarlo para consolidar los conceptos.' }}</p>
    <div class="actions"><button v-if="game.mode === 'god'" class="primary" type="button" @click="startGod">Intentar de nuevo <span>↗</span></button><button v-else class="primary" type="button" @click="moveStudy(-1)">Revisar preguntas <span>←</span></button><button class="secondary" type="button" @click="home">{{ game.mode === 'god' ? 'Volver al menú' : 'Elegir otro tema' }}</button></div>
  </main>

  <main v-else-if="question" class="shell game" :class="{ 'god-mode': game.mode === 'god' }">
    <header class="topbar"><a class="brand" href="#" @click.prevent="home">TRIVIA <b>POO</b></a><a class="menu-link" href="#" @click.prevent="home">← Temas</a><span class="score">{{ game.mode === 'god' ? 'GOD MODE ·' : 'PUNTAJE ·' }} <strong>{{ game.score }}</strong> {{ game.mode === 'god' ? 'PTS' : '' }}</span></header>
    <div class="progress" role="progressbar" :aria-valuenow="game.index" :aria-valuemax="total" aria-label="Progreso"><span :style="{ width: `${progress}%` }"></span></div>
    <div v-if="game.mode === 'god'" class="god-meta"><div class="question-meta"><span>{{ activePart === 1 ? 'LEVEL 3 · EXPERTO' : 'PARCIAL 2 · MODO RÁPIDO' }}</span><b>{{ game.index + 1 }} / {{ total }}</b></div><div class="timer" :class="{ stopped: game.answered }"><span>TIEMPO</span><strong>{{ game.answered ? '—' : seconds }}</strong></div></div>
    <div v-else class="question-meta"><span>{{ question.section }} · RONDA {{ group.round }}</span><b>{{ game.index + 1 }} / {{ total }}</b></div>
    <section class="card" :class="{ 'god-card-content': game.mode === 'god', answered: game.answered }">
      <div v-if="category" class="question-kind">{{ category }}</div>
      <h1 :class="{ 'has-code': displayPrompt.includes('`') }"><template v-for="(segment, index) in promptSegments" :key="index"><code v-if="segment.code">{{ segment.text }}</code><span v-else class="prompt-text">{{ segment.text }}</span></template></h1>
      <template v-if="game.mode === 'god'">
        <form @submit.prevent="godAnswer()"><div class="answers god-answers">
          <label v-for="(option, index) in spec.options" :key="index" class="answer" :class="{ 'correct-answer': game.answered && index === spec.correctOption, 'wrong-answer': game.answered && index === game.selected && index !== spec.correctOption }">
            <input v-model="game.selected" type="radio" :value="index" name="answer" :disabled="game.answered" required><span class="letter">{{ 'ABCD'[index] }}</span><span>{{ option }}</span><span v-if="game.answered && index === spec.correctOption" class="mark">✓</span><span v-if="game.answered && index === game.selected && index !== spec.correctOption" class="mark wrong-mark">×</span>
          </label></div><div v-if="!game.answered" class="god-submit"><button class="primary submit" type="submit">Responder <span>→</span></button></div></form>
        <div v-if="game.answered" class="god-result"><p :class="game.timedOut || game.selected !== spec.correctOption ? 'timeout-message' : 'success-message'">{{ game.timedOut ? 'Se acabó el tiempo. La respuesta correcta está marcada.' : game.selected === spec.correctOption ? '¡Correcto! Buen reflejo.' : 'Respuesta incorrecta. Revisa el concepto.' }}</p><button class="primary" type="button" @click="nextGod">{{ game.index + 1 === total ? 'Ver resultados →' : 'Siguiente pregunta →' }}</button></div>
      </template>
      <template v-else><details :key="question.id" class="reveal"><summary>Revelar respuesta</summary><div class="answer-text">{{ question.answer }}</div></details><div class="self-check"><p>¿Cómo te fue?</p><div class="check-actions"><button class="primary" type="button" @click="studyAnswer(true)">Lo sabía <span>✓</span></button><button class="review-button" type="button" @click="studyAnswer(false)">Necesito repasar <span>↗</span></button></div><p v-if="game.answers[question.id] !== undefined" class="answer-status">Ya marcaste: {{ game.answers[question.id] ? 'Lo sabía' : 'Necesito repasar' }}</p></div><div class="question-navigation"><button class="secondary" type="button" :disabled="game.index === 0" @click="moveStudy(-1)">← Anterior</button><button class="secondary" type="button" @click="moveStudy(1)">{{ game.index + 1 === total ? 'Ver resultados →' : 'Siguiente →' }}</button></div></template>
    </section>
    <p v-if="game.mode === 'study'" class="tip">No hay respuestas malas: cada ronda te ayuda a detectar qué tema revisar.</p>
  </main>
</template>
