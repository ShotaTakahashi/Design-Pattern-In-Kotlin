package flyweight

import kotlin.system.exitProcess

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("Usage: Kotlin Main digits")
        exitProcess(0)
    }

    val bigString = BigString(args[0])
    bigString.print()
}