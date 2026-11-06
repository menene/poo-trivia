# Trivia POO

La trivia del curso CC2008 migrada de Spring Boot a Vue y Vite para publicarla en GitHub Pages. Tiene dos pestañas:

- **Parcial 1:** las 235 preguntas originales de `repaso.md`, organizadas por tema en rondas de hasta 25 preguntas, y God Mode con 20 preguntas.
- **Parcial 2:** 300 preguntas sobre arrays, ArrayLists, principios de diseño de POO, herencia, polimorfismo e interfaces, organizadas en dos rondas de 25 por tema. Incluye conceptos, UML, revisión de código con errores y explicación de código; God Mode tiene 20 preguntas de todos esos temas.

En las rondas de estudio puedes ir a la pregunta anterior o siguiente sin responder. Al marcar `Lo sabía` o `Necesito repasar`, la partida avanza; si regresas y cambias la marca, el puntaje se corrige sin contarla dos veces. God Mode da 10 segundos por pregunta. Cada pestaña conserva su propia partida y puntaje durante la sesión del navegador.

## Desarrollo

Requiere Node.js 22 o superior.

```bash
npm ci
npm run dev
```

Abre la dirección local que muestre Vite. Para verificar y generar los archivos estáticos:

```bash
npm test
npm run build
npm run preview
```

La carpeta `dist/` contiene el sitio publicable. No requiere Python ni un servidor de aplicaciones.

## Publicar en GitHub Pages

1. Sube este proyecto a un repositorio de GitHub en la rama `main`.
2. En **Settings → Pages → Build and deployment**, selecciona **GitHub Actions** como fuente.
3. El flujo `.github/workflows/deploy.yml` ejecuta las pruebas, compila y publica `dist/` en cada push a `main`. También puedes iniciarlo desde **Actions**.

Vite usa rutas relativas para que el sitio funcione tanto en `usuario.github.io` como en `usuario.github.io/repositorio/`.

## Preguntas

Edita `repaso.md` para el primer parcial y `repaso-parcial-2.md` para el segundo. Conserva los encabezados de sección (`## 1. ...`) y cada pregunta numerada (`**1. Pregunta**`). Las opciones y respuestas correctas de God Mode están en `src/godOptions.json` y `src/godOptionsPart2.json` respectivamente. Si cambias el sentido de una pregunta usada en God Mode, actualiza también sus opciones.
