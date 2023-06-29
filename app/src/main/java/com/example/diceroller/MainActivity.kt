package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
//import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Se buscan los elementos de la vista en el lauout especficado

        val rollButton: Button = findViewById(R.id.button) // Se busca al elemento button por su Id
        rollButton.setOnClickListener { rollDice() } // Se ejecuta la función cuando de toca el button (que se busca por su Id)

        rollDice() // Ejecuta un lanzamiento de dado cuando la app inicia para que el usuario pueda imaginar lo que sucederá al presionar el botón
    }
    /*rollButton.setOnClickListener {
            //val toast = Toast.makeText(this, "Dice rolled!", Toast.LENGTH_SHORT).show()
            val resulText: TextView =findViewById(R.id.textView)
            resulText.text = "6"
        }*/

    // Se lanza un dado y se muestra el resultado en TextView
    private fun rollDice() {
        val dice = Dice(6) // Se crea un dado con X número de lados
        val diceRoll = dice.roll() // Se invoca el método roll() para lanzar el dado
        val diceImage: ImageView = findViewById(R.id.imageView) // Se busca ImageView con findViewById dependiendo del resultado de diceRoll -> dice -> Dice -> roll()

        val drawableResource = when (diceRoll) { // El resultado de when se almacena en la variable drawableResource
            1 -> R.drawable.dice_1 // Asinga el elemento drawable especificado según sea el caso/resultado
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6 // Se asinga el caso 6 a else para que no marque error
        }
        diceImage.setImageResource(drawableResource) //
        diceImage.contentDescription = diceRoll.toString()
    }
      /*  when (diceRoll) {
            1 -> diceImage.setImageResource(R.drawable.dice_1) // Asinga el elemento drawable especificado según sea el caso/resultado
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        }*/

    private class Dice(val numSides: Int) {

        fun roll(): Int { // Método para lanzar el dado
            return (1..numSides).random() // Devuelve el número resultante dentro del rango de número de lados
        }
    }
}