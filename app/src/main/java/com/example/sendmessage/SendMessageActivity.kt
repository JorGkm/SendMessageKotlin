package com.example.sendmessage

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.sendmessage.model.Message
import com.example.sendmessage.model.Person
import com.google.android.material.floatingactionbutton.FloatingActionButton

//Comentario hecho por Lourdes en formato HTML

/**
 * Es es la primera actividad de la aplicación que realiza las operaciones:
 * <ol>
 *     <li>Crear un componente <code>EditTExt</code> y Button en XML</li>
 * </ol>
 *
 * @author Jorge Merchán García
 * @version 1.0.0
 * @see android.widget.Button
 * @see android.widget.EditText
 * @see android.os.Bundle
 * @see Intent
 */

/**
 * [IA] Actividad principal de la aplicación SendMessage.
 *
 * Esta pantalla permite al usuario escribir un mensaje en un campo de texto ([EditText])
 * y, al pulsar el botón de enviar, transfiere dicho mensaje a [ViewMessageActivity]
 * mediante un [Intent] explícito con un [Bundle] adjunto.
 *
 * ## Flujo principal:
 * 1. El usuario introduce el texto en el `EditText` con id `etMensaje`.
 * 2. Al pulsar el `Button` con id `btEnviarMensaje`, se crea un [Intent] hacia [ViewMessageActivity].
 * 3. El texto se empaqueta en un [Bundle] bajo la clave `"KEY_MESSAGE"`.
 * 4. Se inicia la nueva actividad con [startActivity].
 *
 * @see ViewMessageActivity
 * @see android.content.Intent
 */
class SendMessageActivity : AppCompatActivity() {

    companion object{
        const val TAG : String = "LogSendMessageActivity"

    }
lateinit var etMessageText : EditText
lateinit var btSend: FloatingActionButton
    /**
     * [IA] Método llamado cuando se crea la actividad.
     *
     * Infla el layout `activity_send_message`, obtiene referencias a los componentes
     * de la interfaz y configura el listener del botón de envío.
     *
     * @param savedInstanceState Estado previamente guardado de la actividad, o `null` si no existe.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(
            R.layout.activity_send_message
        )
        // [IA] Se obtienen los objetos de la view que se ha inflado
        //val etMensaje = findViewById<EditText>(R.id.etMensaje)
        //val btEnviar = findViewById<Button>(R.id.btEnviarMensaje)
        etMessageText = findViewById(R.id.etMensaje)
        btSend = findViewById(R.id.btEnviarMensaje)
        // [IA] Listener que se ejecuta al pulsar el botón "Enviar"
        /*
        btEnviar.setOnClickListener {
            Opción pero ni viable debe de ser corto
            // [IA] Creamos el "sobre" (Intent) con el contexto de la app y el destinatario (ViewMessageActivity)
            val intent = Intent(this, ViewMessageActivity:: class.java)
            // [IA] Creamos la "bolsita" (Bundle) donde meteremos el contenido
            val bundle = Bundle()
            // [IA] Añadimos una cadena con una clave para identificarla y el contenido del cuadro de texto,
            // [IA] convertido a tipo String
            bundle.putString("KEY_MESSAGE", etMensaje.text.toString())
            // [IA] Ahora guardamos nuestra "bolsita de cosas" dentro del "sobre"
            // [IA] para enviarlo al destinatario
            intent.putExtras(bundle)
            // [IA] Iniciamos la actividad destino con el Intent preparado
            startActivity(intent)


        }*/
        //Se escriben mensajes de depuración en la consola LogCat
        Log.d(TAG, "SendMessageActivity => onCreate()")
        btSend.setOnClickListener { sendMessage() }
    }

    /**
     * Función que crea un mensaje con la información de la persona que envía y
     * de la personas que recoge el mensaje
     */
    private fun sendMessage(){
        //1º Creamos el intent
        val intent = Intent(this, ViewMessageActivity:: class.java)
        //2º Creamos el bundle
        val bundle = Bundle()
        //3º Creamos las personas
        val p1 = Person("77191451R", "Jorge", "Merchán García")
        val p2 = Person("77191452W", "Jose Luis", "Merchán García")
        //4º Creamos el mensaje
        val message = Message(1,etMessageText.text.toString(), p1, p2)
        //5º Añadimos al Bundle el mensaje
        bundle.putParcelable("KEY_MESSAGE", message)
        //6º Añadimos el bundle al intent
        intent.putExtras(bundle)
        //7º Iniciamos la ViewActivity con el intent
        startActivity(intent)
    }
//region Ciclo de vida de una Actividad
    override fun onStart() {
        super.onStart()
    Log.d(TAG, "SendMessageActivity => onStart()")

    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "SendMessageActivity => onStop()")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "SendMessageActivity => onDestroy()")

    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "SendMessageActivity => onResume()")

    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "SendMessageActivity => onPause()")

    }
//endregion
}