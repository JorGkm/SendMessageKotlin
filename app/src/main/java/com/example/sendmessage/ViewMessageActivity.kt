package com.example.sendmessage

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sendmessage.model.Message


/**
 * [IA] Actividad que muestra el mensaje recibido desde [ViewMessageActivity].
 *
 * Esta pantalla es el destino del [Intent] enviado por la actividad de envío.
 * Extrae el mensaje del [Bundle] adjunto al [Intent] y lo muestra en un [TextView].
 *
 * ## Flujo de recepción:
 * 1. Se obtiene el [Intent] que lanzó esta actividad mediante [getIntent].
 * 2. Se extrae el [Bundle] con [getExtras].
 * 3. Se recupera el mensaje usando la clave `"KEY_MESSAGE"` con [getString].
 * 4. Se muestra el texto en el `TextView` con id `tvFinalMessage`.
 *
 * ## Estilos:
 * Aplica el mismo estilo visual que [ViewMessageActivity]:
 * - Fondo morado (`@color/purple_200`) en el área del mensaje.
 * - Fuente personalizada `@font/playwrite_bewal_guides_regular`.
 * - Texto en negrita y centrado.
 *
 * @see ViewMessageActivity
 */
class ViewMessageActivity : AppCompatActivity() {

    companion object{
        const val TAG : String = "LogViewMessageActivity"
    }
    
    /**
     * [IA] Método llamado cuando se crea la actividad.
     *
     * Configura el layout, activa el modo edge-to-edge, aplica padding
     * según las insets del sistema y recupera el mensaje del [Intent] entrante.
     *
     * @param savedInstanceState Estado previamente guardado de la actividad, o `null` si no existe.
     */
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // [IA] Activa el modo edge-to-edge para que el contenido se extienda bajo las barras del sistema
        enableEdgeToEdge()
        setContentView(R.layout.activity_view_message)
        // [IA] Aplica un listener para ajustar el padding del layout principal según las insets del sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        /* [IA] Recuperar el mensaje del Intent entrante y mostrarlo en el TextView
        val tvFinalMessage = findViewById<TextView>(R.id.tvFinalMessage)
        val bundle = intent.extras
        val mensaje = bundle?.getString("KEY_MESSAGE")
        tvFinalMessage.text = mensaje
        */
        val tvFinalMessage = findViewById<TextView>(R.id.tvFinalMessage)
        val bundle = this.intent.extras
        val mensaje = bundle?.getParcelable("KEY_MESSAGE", Message::class.java)
        val emisor = mensaje?.sender
        val receptor = mensaje?.receiver
        val contenido = mensaje?.content
        tvFinalMessage.text = contenido
        val tvCita = findViewById<TextView>(R.id.tvCita)
        tvCita.text = "De ${emisor?.name} para ${receptor?.name}"

    }
    //region Ciclo de vida de una Actividad
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "ViewMessageActivity => onStart()")

    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "ViewMessageActivity => onStop()")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "ViewMessageActivity => onDestroy()")

    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "ViewMessageActivity => onResume()")

    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "ViewMessageActivity => onPause()")

    }
//endregion
}