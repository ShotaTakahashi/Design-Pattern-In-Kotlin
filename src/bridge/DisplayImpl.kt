package bridge

import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException

abstract class DisplayImpl {
    abstract fun rawOpen()
    abstract fun rawPrint()
    abstract fun rawClose()
}

class StringDisplayImpl(private val string: String,
                        private val width: Int = string.toByteArray().size): DisplayImpl() {
    override fun rawOpen() {
        printLine()
    }

    override fun rawPrint() {
        println("|" + string + "|")
    }

    override fun rawClose() {
        printLine()
    }

    fun printLine() {
        print("+")
        for (i in 1..width) {
            print("-")
        }
        println("+")
    }
}

class FileDisplayImpl(private val filename: String): DisplayImpl() {
    private var reader: BufferedReader? = null
    private val MAX_READAHEAD_LIMIT: Int = 4096
    override fun rawOpen() {
        try {
            reader = BufferedReader(FileReader(filename))
            reader?.mark(MAX_READAHEAD_LIMIT)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        println("=-=-=-=-=-= " + filename + " =-=-=-=-=-=")
    }

    override fun rawPrint() = try {
        var line: String
        reader?.reset()
        for (line in reader!!.lines()) {
            println("> " + line)
        }
    } catch (e: IOException) {
        e.printStackTrace()
    }

    override fun rawClose() {
        println("=-=-=-=-=-= ")
        try {
            reader?.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}

class CharDisplayImpl(private val head: Char,
                      private val body: Char,
                      private val foot: Char): DisplayImpl() {
    override fun rawOpen() {
        print(head)
    }

    override fun rawPrint() {
        print(body)
    }

    override fun rawClose() {
        println(foot)
    }
}