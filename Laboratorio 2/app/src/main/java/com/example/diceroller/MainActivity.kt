package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

/** Esta actividad permite al usuario que al precionar el botón gire el dado y muestre el resultado.*/
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Es la función para apretar el botón y que suene al apretarlo.
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        // Cuando la app inicia gira un dado.
        rollDice()
    }

    /**Gira el dado y manda el resultado en la pantalla.*/
    private fun rollDice() {
        // Es la función donde crea el dado de 6 caras y lo gira.
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Busca la imagen.
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Determina la imagen en base al resultado del dado que salio al girarlo.
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Muestra la imagen del resultado obtenido.
        diceImage.setImageResource(drawableResource)

        // Muestra la descripción obtenida.
        diceImage.contentDescription = diceRoll.toString()
    }
}

/** Clase para crear el dado*/
class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}