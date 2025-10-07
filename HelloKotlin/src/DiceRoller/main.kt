package DiceRoller

fun main() {
//    val diceRange = 1..6
//    val randomNumber = diceRange.random()
//    println("Random number: $randomNumber")

    val myFirstDice = Dice(6)
//    println("Your ${myFirstDice.numSides} sided dice rolled ${myFirstDice.roll()}!")
    val rollResult = myFirstDice.roll()

//    val mySecondDice = Dice(20)
//    println("Your ${mySecondDice.numSides} sided dice rolled ${mySecondDice.roll()}!")
    val luckyNumber = 4

//    if (rollResult == luckyNumber) {
//        println("You win!")
//    } else if (rollResult == 1) {
//        println("So sorry! You rolled a 1. Try again!")
//    } else if (rollResult == 2) {
//        println("Sadly, you rolled a 2. Try again!")
//    } else if (rollResult == 3) {
//        println("Unfortunately, you rolled a 3. Try again!")
//    } else if (rollResult == 5) {
//        println("Don't cry! You rolled a 5. Try again!")
//    } else {
//        println("Apologies! You rolled a 6. Try again!")
//    }
    when (rollResult) {
        luckyNumber -> println("You win!")
        else -> println("Too bad, you rolled a $rollResult. Try again!")
    }
}

class Dice (val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}