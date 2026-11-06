import { createApp } from 'vue'
import App from './App.vue'
import markdown from '../repaso.md?raw'
import secondMarkdown from '../repaso-parcial-2.md?raw'
import { parseQuestions } from './questions.js'
import './style.css'

createApp(App, {
  banks: {
    1: parseQuestions(markdown, 1),
    2: parseQuestions(secondMarkdown, 2),
  },
}).mount('#app')
