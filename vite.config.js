import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

export default defineConfig({
  // Relative asset paths work at both a user site and a repository site.
  base: './',
  plugins: [vue()],
})
