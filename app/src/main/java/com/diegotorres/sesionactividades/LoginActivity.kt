package com.diegotorres.sesionactividades

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(){
    lateinit var correo:String
    lateinit var pass:String

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val datosMain = intent?.extras
        correo = datosMain?.getString("Correo").toString()
        pass = datosMain?.getString("Contraseña").toString()

        val registroclick = findViewById<TextView>(R.id.register_login)

        registroclick.setOnClickListener {
            goToRegistro()
        }

        login.setOnClickListener {
            goToMain()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1234 && resultCode == Activity.RESULT_OK){
            val datas =data?.extras
            correo = datas?.getString("Correo").toString()
            pass = datas?.getString("Contraseña").toString()
        }
    }

    private fun goToRegistro(){
        val intent = Intent(this, RegistroActivity::class.java)
        startActivityForResult(intent,1234)
    }

    private fun goToMain(){
        val correoAux = email_login.text.toString()
        val passAux = pass_login.text.toString()
        when {
            correo != correoAux || pass != passAux -> {
                Toast.makeText(this,"Correo o Contraseña invalido",Toast.LENGTH_SHORT).show()
            }
            else -> {
                val datoMain = Intent(this,MainActivity::class.java)
                datoMain.putExtra("Correo",correo)
                datoMain.putExtra("Contraseña",pass)
                startActivity(datoMain)
                finish()
            }
        }
    }
}