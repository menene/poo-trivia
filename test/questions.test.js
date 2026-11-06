import test from 'node:test'
import assert from 'node:assert/strict'
import { readFileSync } from 'node:fs'
import { parseQuestions } from '../src/questions.js'
import godOptions from '../src/godOptions.json' with { type: 'json' }
import secondGodOptions from '../src/godOptionsPart2.json' with { type: 'json' }

const questions = parseQuestions(readFileSync(new URL('../repaso.md', import.meta.url), 'utf8'))
const secondQuestions = parseQuestions(readFileSync(new URL('../repaso-parcial-2.md', import.meta.url), 'utf8'), 2)

test('all original questions and level boundaries are preserved', () => {
  assert.equal(questions.length, 235)
  assert.deepEqual([1, 2, 3].map(level => questions.filter(q => q.level === level).length), [98, 84, 53])
  assert.deepEqual(questions.map(q => q.id), Array.from({ length: 235 }, (_, i) => i + 1))
  assert.ok(questions.every(q => q.prompt && q.answer && q.section))
})

test('God Mode has 20 valid questions with four options', () => {
  assert.deepEqual(Object.keys(godOptions).map(Number), Array.from({ length: 20 }, (_, i) => i + 183))
  for (const [id, spec] of Object.entries(godOptions)) {
    assert.ok(questions.some(q => q.id === Number(id)))
    assert.equal(spec.options.length, 4)
    assert.ok(spec.correctOption >= 0 && spec.correctOption < 4)
  }
})

test('second exam covers all six topics with 50 questions each', () => {
  assert.equal(secondQuestions.length, 300)
  assert.deepEqual(secondQuestions.map(q => q.id), Array.from({ length: 300 }, (_, i) => i + 1))
  assert.equal(new Set(secondQuestions.map(q => q.section)).size, 6)
  assert.ok([...new Set(secondQuestions.map(q => q.section))].every(section =>
    secondQuestions.filter(q => q.section === section).length === 50))
  assert.ok(secondQuestions.filter(q => q.prompt.includes('`')).length >= 200)
  assert.ok(secondQuestions.filter(q => /error|corrige|qué ocurre/i.test(q.prompt)).length >= 30)
  assert.ok(secondQuestions.filter(q => /qué imprime|qué devuelve|qué retorna/i.test(q.prompt)).length >= 40)
  assert.ok(secondQuestions.every(q => q.prompt && q.answer))
})

test('second exam includes explicit UML, concept, code review, and code explanation practice', () => {
  const required = {
    UML: 20,
    Concepto: 10,
    'Revisión de código': 14,
    'Explicación de código': 16,
  }
  for (const [kind, count] of Object.entries(required)) {
    assert.equal(secondQuestions.filter(q => q.prompt.startsWith(`${kind} · `)).length, count)
  }
  for (const section of new Set(secondQuestions.map(q => q.section))) {
    const inSection = secondQuestions.filter(q => q.section === section)
    assert.ok(inSection.some(q => q.prompt.startsWith('Concepto · ')))
    assert.ok(inSection.some(q => q.prompt.startsWith('Revisión de código · ')))
    assert.ok(inSection.some(q => q.prompt.startsWith('Explicación de código · ')))
  }
})

test('second exam timed mode draws from every topic', () => {
  const entries = Object.entries(secondGodOptions)
  assert.equal(entries.length, 20)
  assert.equal(new Set(entries.map(([id]) => secondQuestions.find(q => q.id === Number(id))?.section)).size, 6)
  for (const [id, spec] of entries) {
    assert.ok(secondQuestions.some(q => q.id === Number(id)))
    assert.equal(spec.options.length, 4)
    assert.ok(spec.correctOption >= 0 && spec.correctOption < 4)
    assert.ok(spec.options.every(Boolean))
  }
})
