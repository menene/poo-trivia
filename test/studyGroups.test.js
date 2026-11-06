import test from 'node:test'
import assert from 'node:assert/strict'
import { readFileSync } from 'node:fs'
import { parseQuestions } from '../src/questions.js'
import { createStudyGroups, recordStudyAnswer, moveStudyIndex } from '../src/studyGroups.js'

const first = parseQuestions(readFileSync(new URL('../repaso.md', import.meta.url), 'utf8'))
const second = parseQuestions(readFileSync(new URL('../repaso-parcial-2.md', import.meta.url), 'utf8'), 2)

test('topic rounds contain every question exactly once and never exceed 25', () => {
  for (const bank of [first, second]) {
    const groups = createStudyGroups(bank)
    assert.deepEqual(groups.flatMap(group => group.questions.map(q => q.id)), bank.map(q => q.id))
    assert.ok(groups.every(group => group.questions.length > 0 && group.questions.length <= 25))
    assert.ok(groups.every(group => group.questions.every(q => q.section === group.topic)))
    for (const topic of new Set(groups.map(group => group.topic))) {
      const sizes = groups.filter(group => group.topic === topic).map(group => group.questions.length)
      assert.ok(Math.max(...sizes) - Math.min(...sizes) <= 1)
    }
  }
  assert.equal(createStudyGroups(second).length, 12)
  assert.ok(createStudyGroups(second).every(group => group.questions.length === 25))
})

test('moving between questions allows skips and clamps at both ends', () => {
  assert.equal(moveStudyIndex(0, -1, 25), 0)
  assert.equal(moveStudyIndex(0, 1, 25), 1)
  assert.equal(moveStudyIndex(24, 1, 25), 25)
  assert.equal(moveStudyIndex(25, -1, 25), 24)
})

test('revisiting an answer changes the score only when the mark changes', () => {
  const initial = { score: 0, answers: {} }
  const firstMark = recordStudyAnswer(initial, 42, true)
  assert.equal(firstMark.score, 1)
  assert.equal(recordStudyAnswer(firstMark, 42, true).score, 1)
  const changed = recordStudyAnswer(firstMark, 42, false)
  assert.equal(changed.score, 0)
  assert.equal(recordStudyAnswer(changed, 43, true).score, 1)
})
