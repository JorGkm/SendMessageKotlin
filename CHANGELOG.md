# Changelog

> **[IA]** Historial de cambios del proyecto SendMessage.

---

## [1.0.0] — 2026-09-29

### Añadido

- ✅ Lógica de recepción del mensaje en `ViewMessageActivity` (extracción del `Bundle` y muestra en `tvFinalMessage`).
- ✅ Estilos personalizados en `activity_view_message.xml`: fondo morado (`@color/purple_200`), fuente `@font/playwrite_bewal_guides_regular`, texto en negrita y centrado.
- ✅ Layout de `ViewMessageActivity` con `ConstraintLayout` y restricciones correctas.
- ✅ Comentarios KDoc en todas las clases y métodos principales, marcados con `[IA]`.
- ✅ Documentación del flujo del mensaje en `FLUJO_DEL_MENSAJE.md`.
- ✅ `README.MD` con descripción, instalación, estructura y dependencias.
- ✅ `CHANGELOG.MD` con historial de cambios.
- ✅ `MANUAL_USUARIO.md` con instrucciones en lenguaje sencillo.

### Modificado

- `ViewMessageActivity.kt` — Añadida la lógica para recibir el mensaje del `Intent` y mostrarlo en el `TextView`.
- `activity_view_message.xml` — Añadidos estilos personalizados (colores, fuentes, padding) y restricciones de `ConstraintLayout`.

### Corregido

- *(Ninguno en esta versión)*

---

## [0.1.0] — 2026-09-28

### Añadido

- ✅ Actividad principal `SendMessageActivity` con campo de texto (`EditText`) y botón de envío (`Button`).
- ✅ Actividad de visualización `ViewMessageActivity` con layout `ConstraintLayout` y soporte edge-to-edge.
- ✅ Clase `SendMessageApplication` personalizada registrada en el `AndroidManifest.xml`.
- ✅ Comunicación entre actividades mediante `Intent` explícito y `Bundle` con clave `"KEY_MESSAGE"`.
- ✅ Layout `activity_send_message.xml` con `LinearLayout` vertical, `TextView` de título, `EditText` y `Button`.
- ✅ Layout `activity_view_message.xml` con `ConstraintLayout`, `ImageView` decorativo y `TextView` para el mensaje.
- ✅ Recursos de strings, colores, dimensiones y temas.
- ✅ Test unitario de ejemplo (`ExampleUnitTest`).
- ✅ Test instrumentado de ejemplo (`ExampleInstrumentedTest`).

### Modificado

- *(Ninguno en esta versión)*

### Corregido

- *(Ninguno en esta versión)*

---

## Notas de Versión

### v0.1.0 — Configuración inicial y pantallas

Primera versión del proyecto. Se crearon las dos actividades (`SendMessageActivity` y `ViewMessageActivity`), se configuró el `AndroidManifest.xml`, se definieron los layouts y se implementó el envío del mensaje mediante `Intent` y `Bundle`. La segunda actividad aún no mostraba el mensaje recibido.

### v1.0.0 — Paso de datos completado y documentación generada

Se completó la lógica de recepción del mensaje en `ViewMessageActivity`, se aplicaron estilos personalizados en el layout para mantener la coherencia visual con la actividad de origen, y se generó toda la documentación del proyecto (README, CHANGELOG, manual de usuario y comentarios KDoc).

---

*Documentación generada por [IA] — SendMessage Project*
