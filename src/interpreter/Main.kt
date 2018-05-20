package interpreter

import java.io.BufferedReader
import java.io.FileReader

fun main(args: Array<String>) {
    try {
        val reader = BufferedReader(FileReader("program.txt"))
        for (text in reader.lines()) {
            println("text = \"$text\"")
            val node = ProgramNode()
            node.parse(Context(text))
            println("node = $node")
        }
        reader.close()
    } catch (e: Exception) {
        e.printStackTrace()
    }
}