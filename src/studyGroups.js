export function createStudyGroups(questions, size = 25) {
  const topics = new Map()
  for (const question of questions) {
    if (!topics.has(question.section)) topics.set(question.section, [])
    topics.get(question.section).push(question)
  }

  return [...topics].flatMap(([topic, topicQuestions], topicIndex) => {
    const groups = []
    const roundCount = Math.ceil(topicQuestions.length / size)
    const baseLength = Math.floor(topicQuestions.length / roundCount)
    const longerRounds = topicQuestions.length % roundCount
    let start = 0
    for (let roundIndex = 0; roundIndex < roundCount; roundIndex++) {
      const length = baseLength + Number(roundIndex < longerRounds)
      groups.push({
        id: `${topicIndex}:${roundIndex}`,
        topic,
        round: roundIndex + 1,
        start: start + 1,
        end: start + length,
        topicTotal: topicQuestions.length,
        questions: topicQuestions.slice(start, start + length),
      })
      start += length
    }
    return groups
  })
}

export function recordStudyAnswer(game, questionId, knew) {
  const previous = game.answers[questionId]
  return {
    ...game,
    answers: { ...game.answers, [questionId]: knew },
    score: game.score + Number(knew) - Number(previous === true),
  }
}

export function moveStudyIndex(index, offset, total) {
  return Math.max(0, Math.min(total, index + offset))
}
