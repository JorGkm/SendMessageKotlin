# AGENTS.md

Instrucciones para agentes de OpenCode que trabajen en este repositorio.

## Build y Ejecución

```bash
# Compilar APK debug
./gradlew assembleDebug

# Tests unitarios
./gradlew test

# Tests instrumentados (requiere emulador/dispositivo)
./gradlew connectedAndroidTest

# Instalar en emulador
adb install -r app/build/outputs/apk/debug/app-debug.apk
```

## Entorno

- **SDK location**: `/home/jorg/Android/Sdk` (definido en `local.properties`)
- **Emulator AVD**: `Pixel_5` (único disponible)
- **JDK**: 11+ (source/target compatibility)
- **compileSdk**: 37, **targetSdk**: 36, **minSdk**: 24

## Arquitectura

```
SendMessageActivity ──Intent + Bundle──► ViewMessageActivity
     │                                        │
     ▼                                        ▼
  EditText                              TextView (tvFinalMessage)
  FloatingActionButton                   TextView (tvCita)
```

- **Flujo de datos**: `SendMessageActivity` crea un `Message` (Parcelable) y lo envía vía `Intent` con clave `"KEY_MESSAGE"`
- **Modelo de datos**: `Message` y `Person` son `@Parcelize` data classes en `app/src/main/java/com/example/sendmessage/model/`
- **⚠️ Clave importante**: El bundle usa `putParcelable("KEY_MESSAGE", message)` — NO es un String, es un objeto `Message` Parcelable
- **⚠️ Requisito API**: `ViewMessageActivity.onCreate()` tiene `@RequiresApi(Build.VERSION_CODES.TIRAMISU)` — solo funciona en API 33+

## Convenciones del Proyecto

- **ViewBinding**: habilitado en `build.gradle.kts` pero **NO se usa** — el código utiliza `findViewById` y `lateinit var` para las vistas
- **FAB**: El botón de enviar es un `FloatingActionButton` de Material Design, no un `Button` estándar
- **Logs**: Usar tags `LogSendMessageActivity` y `LogViewMessageActivity` para filtrar en Logcat
- **Dokka**: Configurado para generar documentación en `documentation/`

## Imágenes y Documentación

- **Screenshots**: Se almacenan en `documentation/images/screenshots/`
- **⚠️ Rutas en README**: Deben usar la ruta completa desde la raíz del repo (ej. `documentation/images/screenshots/screenshot_sendmessage.png`) — GitHub es sensible a mayúsculas/minúsculas
- **Documentación adicional**: `FLUJO_DEL_MENSAJE.md`, `MANUAL_USUARIO.md`, `CHANGELOG.md`

## Estructura de Directorios

```
app/src/main/java/com/example/sendmessage/
├── SendMessageActivity.kt    ← Activity origen (EditText + FAB)
├── ViewMessageActivity.kt    ← Activity destino (muestra mensaje)
├── SendMessageApplication.kt ← Application class
└── model/
    ├── Message.kt            ← @Parcelize data class
    └── Person.kt             ← @Parcelize data class
```

## Validación de README

```bash
python3 .opencode/skills/personalice-docs-generator/scripts/validate_readme.py README.md
```
