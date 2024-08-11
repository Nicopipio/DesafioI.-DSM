package com.example.ejercicio1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

lateinit var nota1 : EditText
lateinit var nota2 : EditText
lateinit var nota3 : EditText
lateinit var nota4 : EditText
lateinit var nota5 : EditText
lateinit var nombre : EditText
lateinit var calcular : Button
lateinit var resultado: TextView
lateinit var aprobo: TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        nombre = findViewById(R.id.txtnombre)
        nota1 = findViewById(R.id.Nota1)
            nota2 = findViewById(R.id.Nota2)
            nota3 = findViewById(R.id.Nota3)
            nota4 = findViewById(R.id.Nota4)
            nota5 = findViewById(R.id.Nota5)
            calcular = findViewById(R.id.calcular)
        resultado = findViewById(R.id.txtResultado)
        aprobo = findViewById(R.id.txtapr)




        calcular.setOnClickListener{

            var nombreEst: String = nombre.text.toString()

            if (!isNotaValida(nota1.text.toString()) || !isNotaValida(nota2.text.toString()) ||
                !isNotaValida(nota3.text.toString()) || !isNotaValida(nota4.text.toString()) ||
                !isNotaValida(nota5.text.toString())) {

                Toast.makeText(this, "Por favor, ingrese notas válidas entre 0 y 10", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            var notas = nota1.text.toString().toFloat() * 0.15 +
                    nota2.text.toString().toFloat() * 0.15 + nota3.text.toString().toFloat() * 0.20 +
                    nota4.text.toString().toFloat() * 0.25  + nota5.text.toString().toFloat() * 0.25

               resultado.text = "El promedio del estudiante ${nombreEst} es : ${notas}"

             if (notas >= 6){ aprobo.text = "Aprobado"}
            else{
                 aprobo.text = "Reprobado"}
        }
        }

    private fun isNotaValida(nota: String): Boolean {
        return try {
            val valor = nota.toFloat()
            valor in 0.0..10.0
        } catch (e: NumberFormatException) {
            false
        }
    }
}
