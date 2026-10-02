# Flujo del Mensaje: De SendMessageActivity a ViewMessageActivity

> **[IA]** Documentación generada por IA que explica paso a paso cómo el mensaje escrito en la primera pantalla viaja hasta la segunda.

---

## Resumen

La aplicación **SendMessage** consta de dos pantallas:

| Pantalla | Actividad | Layout |
|---|---|---|
| **Pantalla 1** — Escritura | `SendMessageActivity` | `activity_send_message.xml` |
| **Pantalla 2** — Visualización | `ViewMessageActivity` | `activity_view_message.xml` |

El usuario escribe un texto en la primera pantalla, pulsa el botón **"Enviar"** y el mensaje aparece en la segunda pantalla.

---

## Paso a Paso

### Paso 1 — El usuario escribe el mensaje

```
┌─────────────────────────────────────┐
│  SendActivity                       │
│                                     │
│  ┌───────────────────────────────┐  │
│  │ Escribe aquí el mensaje...    │  │  ← EditText (etMensaje)
│  │                               │  │
│  └───────────────────────────────┘  │
│                                     │
│  ┌─────────┐                        │
│  │ Enviar  │                        │  ← Button (btEnviarMensaje)
│  └─────────┘                        │
└─────────────────────────────────────┘
```

- El componente `EditText` con id `etMensaje` captura el texto que el usuario introduce.
- El componente `Button` con id `btEnviarMensaje` espera a que el usuario lo pulse.

---

### Paso 2 — El usuario pulsa "Enviar"

Al pulsar el botón, se ejecuta el listener `setOnClickListener` definido en `SendMessageActivity.onCreate()`:

```kotlin
btEnviar.setOnClickListener {
    // ... código que se ejecuta al hacer clic
}
```

---

### Paso 3 — Se crea el Intent (el "sobre")

```kotlin
val intent = Intent(this, ViewMessageActivity::class.java)
```

- **`Intent`** es el mecanismo de Android para comunicar componentes.
- Se crea un **Intent explícito** porque se indica directamente la clase destino: `ViewMessageActivity::class.java`.
- El primer parámetro (`this`) es el contexto actual (la actividad que envía).

---

### Paso 4 — Se crea el Bundle (la "bolsita")

```kotlin
val bundle = Bundle()
```

- **`Bundle`** es un contenedor clave-valor que permite transportar datos entre actividades.
- Es como una "bolsita" donde metemos la información que queremos enviar.

---

### Paso 5 — Se introduce el mensaje en el Bundle

```kotlin
bundle.putString("KEY_MESSAGE", etMensaje.text.toString())
```

- **`etMensaje.text.toString()`** obtiene el texto del `EditText` y lo convierte a `String`.
- **`"KEY_MESSAGE"`** es la clave identificadora que luego se usará para recuperar el valor.
- El par clave-valor se guarda dentro del `Bundle`.

---

### Paso 6 — El Bundle se adjunta al Intent

```kotlin
intent.putExtras(bundle)
```

- El `Bundle` con el mensaje se adjunta al `Intent`.
- Ahora el "sobre" contiene la "bolsita" con el mensaje.

---

### Paso 7 — Se inicia la actividad destino

```kotlin
startActivity(intent)
```

- **`startActivity()`** le pide al sistema Android que abra la actividad especificada en el `Intent`.
- El sistema crea una nueva instancia de `ViewMessageActivity` y la muestra en pantalla.
- El `Intent` (con su `Bundle`) viaja junto con la petición.

---

### Paso 8 — ViewMessageActivity recibe el mensaje

`ViewMessageActivity` extrae el mensaje del `Intent` entrante y lo muestra en el `TextView`:

```kotlin
// Recuperar el mensaje del Intent entrante y mostrarlo en el TextView
val tvFinalMessage = findViewById<TextView>(R.id.tvFinalMessage)
val bundle = intent.extras
val mensaje = bundle?.getString("KEY_MESSAGE")
tvFinalMessage.text = mensaje
```

- **`intent.extras`** obtiene el `Bundle` adjunto al `Intent` que lanzó esta actividad.
- **`bundle?.getString("KEY_MESSAGE")`** recupera el mensaje usando la misma clave con la que se guardó.
- **`tvFinalMessage.text = mensaje`** muestra el texto en el `TextView` con id `tvFinalMessage`.

---

## Diagrama de Flujo Completo

```
┌──────────────────────────────────────────────────────────────────┐
│                    SendMessageActivity                           │
│                                                                  │
│   Usuario escribe → etMensaje (EditText)                         │
│                                                                  │
│   Usuario pulsa → btEnviarMensaje (Button)                       │
│         │                                                        │
│         ▼                                                        │
│   ┌─────────────────────────────────────────┐                    │
│   │  1. Crear Intent(this, ViewMessage...)  │                    │
│   │  2. Crear Bundle()                      │                    │
│   │  3. bundle.putString("KEY_MESSAGE", txt) │                    │
│   │  4. intent.putExtras(bundle)            │                    │
│   │  5. startActivity(intent)               │                    │
│   └──────────────────┬──────────────────────┘                    │
└──────────────────────┼───────────────────────────────────────────┘
                       │
                       │  Intent + Bundle
                       ▼
┌──────────────────────────────────────────────────────────────────┐
│                    ViewMessageActivity                            │
│                                                                  │
│   onCreate() {                                                   │
│       val bundle = intent.extras                                 │
│       val mensaje = bundle?.getString("KEY_MESSAGE")             │
│       tvFinalMessage.text = mensaje                              │
│   }                                                              │
│                                                                  │
│   ┌─────────────────────────────────────┐                        │
│   │  tvFinalMessage (TextView)          │                        │
│   │  "El mensaje que escribió el user"  │                        │
│   └─────────────────────────────────────┘                        │
└──────────────────────────────────────────────────────────────────┘
```

---

## Conceptos Clave

| Concepto | Descripción |
|---|---|
| **Intent** | Mensaje asíncrono para solicitar una acción a otro componente de Android. |
| **Bundle** | Contenedor clave-valor para transportar datos dentro de un Intent. |
| **Clave ("KEY_MESSAGE")** | String identificador para almacenar y recuperar un valor del Bundle. |
| **startActivity()** | Método que inicia una nueva actividad. |
| **putExtras()** | Adjunta un Bundle a un Intent. |
| **getString()** | Recupera un String del Bundle usando su clave. |

---

## Archivos Involucrados

| Archivo | Rol |
|---|---|
| `SendMessageActivity.kt` | Crea el Intent, empaqueta el mensaje y lanza la segunda actividad. |
| `ViewMessageActivity.kt` | Recibe el Intent, extrae el mensaje y lo muestra en el TextView. |
| `activity_send_message.xml` | Layout con el EditText y el Button. |
| `activity_view_message.xml` | Layout con el TextView donde se mostrará el mensaje. |
| `AndroidManifest.xml` | Declara ambas actividades. |

---

*Documentación generada por [IA] — SendMessage Project*
