package Lists

fun main() {
    val numbers: List<Int> = listOf(1, 2, 3, 4, 5, 6)
    println("List: $numbers")
    println("Size: ${numbers.size}")

    println("First element: ${numbers[0]}")
    println("Second element: ${numbers[1]}")
    println("Last index: ${numbers.size - 1}")
    println("Last element: ${numbers[numbers.size - 1]}")
    println("First: ${numbers.first()}")
    println("Last: ${numbers.last()}")

    println("Contains 4? ${numbers.contains(4)}")
    println("Contains 7? ${numbers.contains(7)}")


    val colors = listOf("green", "orange", "blue")
//    colors.add("purple")
//    colors[0] = "yellow"
    println("Reversed list: ${colors.reversed()}")
    println("List: $colors")
    println("Sorted list: ${colors.sorted()}")


    val oddNumbers = listOf(5, 3, 7, 1)
    println("List: $oddNumbers")
    println("Sorted list: ${oddNumbers.sorted()}")



//    val entrees = mutableListOf()
    val entrees = mutableListOf<String>()
    println("Entrees: $entrees")

    println("Add noodles: ${entrees.add("noodles")}")
    println("Entrees: $entrees")
    println("Add spaghetti: ${entrees.add("spaghetti")}")
    println("Entrees: $entrees")

    val moreItems = listOf("ravioli", "lasagna", "fettuccine")
    println("Add list: ${entrees.addAll(moreItems)}")
    println("Entrees: $entrees")

//    entrees.add(10)

    println("Remove spaghetti: ${entrees.remove("spaghetti")}")
    println("Entrees: $entrees")

    println("Remove item that doesn't exist: ${entrees.remove("rice")}")
    println("Entrees: $entrees")

    println("Remove first element: ${entrees.removeAt(0)}")
    println("Entrees: $entrees")

    entrees.clear()
    println("Entrees: $entrees")

    println("Empty? ${entrees.isEmpty()}")




    val guestsPerFamily = listOf(2, 4, 1, 3)
    var totalGuests = 0
    var index = 0
    while (index < guestsPerFamily.size) {
        totalGuests += guestsPerFamily[index]
        index++
    }
    println("Total guest count: $totalGuests")



    val names = listOf("Jessica", "Henry", "Alicia", "Jose")
    for (name in names) {
        println("$name - Number of characters: ${name.length}")
    }
}