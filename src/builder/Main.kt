package builder

import kotlin.system.exitProcess

fun main(args: Array<String>) {
    if (args.size != 1) {
        usage()
        exitProcess(0)
    }
    if (args[0].equals("plain")) {
        val textBuilder: TextBuilder = TextBuilder()
        val director: Director = Director(textBuilder)
        director.constract()
        val result: String = textBuilder.getResult()
        println(result)
    } else if (args[0].equals("html")) {
        val htmlBuilder: HTMLBuilder = HTMLBuilder()
        val director: Director = Director(htmlBuilder)
        director.constract()
        val filename: String = htmlBuilder.getString()
        println("make " + filename)
    } else {
        usage()
        exitProcess(0)
    }
}

private fun usage() {
    println("Usage: java Main plain")
    println("Usage: java Main html")
}