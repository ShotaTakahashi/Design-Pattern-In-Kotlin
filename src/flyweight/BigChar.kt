package flyweight

import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException

class BigChar(private val charname: Char) {
    private var fontdata: String

    fun print() {
        print(fontdata)
    }

    init {
        try {
            val reader = BufferedReader(FileReader("big$charname.txt"))
            val buffer = StringBuilder()
            for (line in reader.lines()) {
                buffer.append(line)
                buffer.append("\n")
            }
            reader.close()
            this.fontdata = buffer.toString()
        } catch (e: IOException) {
            this.fontdata = "$charname?"
        }
    }
}