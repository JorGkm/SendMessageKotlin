package com.example.sendmessage

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * [IA] Test instrumentado de ejemplo que se ejecuta en un dispositivo Android.
 *
 * Sirve como punto de partida para añadir tests instrumentados que interactúan
 * con el contexto de la app y sus componentes.
 *
 * Ver [documentación de testing](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    /**
     * [IA] Test de ejemplo que verifica que el contexto de la app tenga el package name correcto.
     */
    @Test
    fun useAppContext() {
        // [IA] Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.sendmessage", appContext.packageName)
    }
}