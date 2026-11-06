const firstExamSections = {
  1: 'Introducción a POO',
  2: 'Entorno de Trabajo',
  3: 'Clases y Objetos',
  4: 'Datos y Expresiones',
  5: 'Relaciones entre Clases',
  6: 'Aliases y Clases Útiles',
  7: 'Arrays',
  8: 'Arreglos Dinámicos',
  9: 'Excepciones',
  10: 'Preguntas integradoras',
}

const secondExamSections = {
  1: 'Arrays',
  2: 'ArrayLists',
  3: 'Principios de diseño de POO',
  4: 'Herencia',
  5: 'Polimorfismo',
  6: 'Interfaces',
}

export function parseQuestions(markdown, exam = 1) {
  const questions = []
  let section = 0
  let current = null

  function finish() {
    if (!current) return
    current.answer = current.lines.join('\n').trim()
      .replace(/```(?:java|bash)?/g, '').replace(/```/g, '').trim()
    delete current.lines
    questions.push(current)
  }

  for (const line of markdown.split(/\r?\n/)) {
    const heading = line.match(/^## (\d+)\./)
    if (heading) {
      section = Number(heading[1])
      continue
    }
    const question = line.match(/^\*\*(\d+)\.\s*(.*?)\*\*\s*$/)
    if (question) {
      finish()
      current = {
        id: Number(question[1]),
        level: exam === 1 ? (section <= 4 ? 1 : section <= 7 ? 2 : 3) : Math.ceil(section / 2),
        section: (exam === 1 ? firstExamSections : secondExamSections)[section] || 'Repaso',
        prompt: question[2].trim(),
        lines: [],
      }
    } else if (current) {
      current.lines.push(line)
    }
  }
  finish()
  return questions
}
