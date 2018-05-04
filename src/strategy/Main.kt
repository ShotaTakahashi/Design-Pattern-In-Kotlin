package strategy

import kotlin.system.exitProcess

fun main(args: Array<String>) {
    if (args.size != 2) {
        println("Usage:")
        println("Example")
        exitProcess(0)
    }
    val seed1: Int = Integer.parseInt(args[0])
    val seed2: Int = Integer.parseInt(args[1])
    val player1: Player = Player("Taro", WinningStrategy(seed1))
    val player2: Player = Player("Hana", ProbStrategy(seed2))
    for (i in 1..10000) {
        val nextHand1: Hand = player1.nextHand()
        val nextHand2: Hand = player2.nextHand()
        when {
            nextHand1.isStrongerThan(nextHand2) -> {
                println("Winner:" + player1)
                player1.win()
                player2.lose()
            }
            nextHand2.isStrongerThan(nextHand1) -> {
                println("Winner:" + player2)
                player1.lose()
                player2.win()
            }
            else -> {
                println("Even...")
                player1.even()
                player2.even()
            }
        }
    }
    println("Total result:")
    println(player1.toString())
    println(player2.toString())
}