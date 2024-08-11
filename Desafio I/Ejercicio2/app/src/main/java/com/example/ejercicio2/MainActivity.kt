package com.example.ejercicio2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.EditText
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nombre = findViewById<EditText>(R.id.nombre)
        val sal = findViewById<EditText>(R.id.sal)
        val calcu = findViewById<Button>(R.id.calcu)
        val resul = findViewById<TextView>(R.id.resul)
        val aja = findViewById<TextView>(R.id.aja)

        calcu.setOnClickListener {
            val nom = nombre.text.toString()
            val salBase = sal.text.toString().toDoubleOrNull() ?: 0.0

            if (nom.isEmpty() || salBase <= 0) {
                resul.text = "Complete los campos, por favor."
                aja.text = "ಠ_ಠ"
                aja.visibility = TextView.VISIBLE
                return@setOnClickListener
            }

            val renta = renTotal(salBase)
            val afp = salBase * 0.0725
            val isss = salBase * 0.03
            val neto = salBase - renta - afp - isss

            val total = """
                Nombre: $nom
                Salario Base: ${String.format("%.2f", salBase)}
                Descuentos:
                Renta: ${String.format("%.2f", renta)}
                AFP: ${String.format("%.2f", afp)}
                ISSS: ${String.format("%.2f", isss)}
                Salario Neto: ${String.format("%.2f", neto)}
            """.trimIndent()

            resul.text = total
            aja.text = ""
            aja.visibility = TextView.GONE
        }
    }

    private fun renTotal(ario: Double): Double {
        return if (ario <= 472.00) {
            0.0
        } else if (ario <= 895.24) {
            (ario - 472.00) * 0.10 + 17.67
        } else if (ario <= 2038.10) {
            (ario - 895.24) * 0.20 + 60.00
        } else {
            (ario - 2038.10) * 0.30 + 288.57
        }
    }
}
