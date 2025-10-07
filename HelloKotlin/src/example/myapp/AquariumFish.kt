package example.myapp

//abstract class AquariumFish() {
//    abstract val color: String
//}

interface FishAction {
    fun eat()
}

interface FishColor {
    val color: String
}

object GoldColor: FishColor {
    override val color = "gold"
}

class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}

//class Shark: AquariumFish(), FishAction {
class Shark: FishColor, FishAction {
    override val color = "grey"
    override fun eat() {
        println("hunt and eat fish")
    }
}
//class Plecostomus: AquariumFish(), FishAction {
class Plecostomus(fishColor: FishColor = GoldColor): FishColor by fishColor, FishAction by PrintingFishAction("eat algae") {
//    override val color = "gold"
//    override fun eat() {
//        println("eat algae")
//    }
}