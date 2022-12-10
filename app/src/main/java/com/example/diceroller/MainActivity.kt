package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        //what should happen when the button is tapped.
        rollButton.setOnClickListener { rollDice() }
    }

    //do dice roll
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        //Find ImageView
        val diceImg: ImageView = findViewById(R.id.imageView)
        //set Img in ImageView => diceImg.setImageResource(R.drawable.dice_?)
        val drawableRes = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImg.setImageResource(drawableRes)
        // Update the content description
        diceImg.contentDescription = diceRoll.toString()

        //Dice #2
        val dice2 = Dice(6)
        val diceRoll2 = dice2.roll()
        val drawableRes2 = when (diceRoll2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        val diceImg2: ImageView = findViewById(R.id.imageView2)
        diceImg2.setImageResource(drawableRes2)
        // Update the content description
        diceImg2.contentDescription = diceRoll2.toString()
    }
}

//Random num from roll
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}