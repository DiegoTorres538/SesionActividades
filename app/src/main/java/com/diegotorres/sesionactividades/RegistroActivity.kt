package com.diegotorres.sesionactividades

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_registro.*

class RegistroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        botonregistro.setOnClickListener {
            datosRegistro()
        }
    }

    private fun datosRegistro() {

        val correo = textnombre.text.toString()
        val pass = textpass.text.toString()
        val reppass = textrespass.text.toString()

        when {
            pass != reppass -> {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            }
            pass.length < 6 -> {
                Toast.makeText(this, "La contraseña debe tener minimo 6 caracteres", Toast.LENGTH_SHORT)
                    .show()
            }
            else -> {
                val intentRegistro = Intent()
                intentRegistro.putExtra("Correo", correo)
                intentRegistro.putExtra("Contraseña", pass)
                setResult(Activity.RESULT_OK, intentRegistro)
                finish()
            }
        }
    }

    override fun onBackPressed() {
        setResult(Activity.RESULT_CANCELED)
        finish()
        super.onBackPressed()
    }
}
