package memento

import memento.game.Gamer

fun main(args: Array<String>) {
    val gamer = Gamer(100)
    var memento = gamer.createMemento()
    for (i in 0 until 100) {
        println("==== $i")
        println("Now:$gamer")
        gamer.bet()
        println("money is ${gamer.getMoney()}")
        if (gamer.getMoney() > memento.money) {
            println("save")
            memento = gamer.createMemento()
        } else if (gamer.getMoney() < memento.money / 2) {
            println("back")
            gamer.restoreMemento(memento)
        }
        try {
            Thread.sleep(1000)
        } catch (e: InterruptedException) {}
        println("")
    }
}