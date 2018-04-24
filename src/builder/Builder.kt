package builder

import java.io.FileWriter
import java.io.IOException
import java.io.PrintWriter

abstract class Builder {
    abstract fun makeTitle(title: String)
    abstract fun makeString(str: String)
    abstract fun makeItems(items: List<String>)
    abstract fun close()
}

class TextBuilder: Builder() {
    private val buffer: StringBuffer = StringBuffer()
    override fun makeTitle(title: String) {
        buffer.append("==============================\n")
        buffer.append("[" + title + "]\n")
        buffer.append("\n")
    }

    override fun makeString(str: String) {
        buffer.append('■' + str + "\n")
        buffer.append("\n")
    }

    override fun makeItems(items: List<String>) {
        for (i in 0..items.size-1) {
            buffer.append(" ・" + items[i] + "\n")
        }
        buffer.append("\n")
    }

    override fun close() {
        buffer.append("==============================\n")
    }

    fun getResult(): String {
        return buffer.toString()
    }
}

class HTMLBuilder: Builder() {
    private lateinit var filename: String
    private lateinit var writer: PrintWriter

    override fun makeTitle(title: String) {
        filename = title + ".html"
        try {
            writer = PrintWriter(FileWriter(filename))
        } catch (e: IOException) {
            e.printStackTrace()
        }
        writer.println("<html><head><title>" + title + "</title></head><body>")
        writer.println("<h1>" + title + "</h1>")
    }

    override fun makeString(str: String) {
        writer.println("<p>" + str + "</p>")
    }

    override fun makeItems(items: List<String>) {
        writer.println("<ul>")
        for (i in 0..items.size-1) {
            writer.println("<li>" + items[i] + "</li>")
        }
        writer.println("</ul>")
    }

    override fun close() {
        writer.println("</body></html>")
        writer.close()
    }

    fun getString(): String {
        return filename
    }
}
