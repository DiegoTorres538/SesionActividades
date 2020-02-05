package com.diegotorres.sesionactividades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var correoPantalla:String
    lateinit var pass:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val aux = intent?.extras
        correoPantalla = aux?.getString("Correo").toString()
        pass = aux?.getString("Contraseña").toString()
        val texto = "El usuario registrado tiene como Correo:\n $correoPantalla"

        pantalla.text = texto
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item:MenuItem): Boolean {
        return when (item.itemId) {
            R.id.close -> {
                goToLoginActivity()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun goToLoginActivity(){
        val intent = Intent(this, LoginActivity::class.java)
        intent.putExtra("Correo",correoPantalla).toString()
        intent.putExtra("Contraseña",pass).toString()
        startActivity(intent)
        finish()
    }
}
