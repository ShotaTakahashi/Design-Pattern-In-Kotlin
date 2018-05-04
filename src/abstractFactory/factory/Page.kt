package abstractFactory.factory

import java.io.*

abstract class Page(protected val title: String,
                    protected val author: String,
                    protected val content: ArrayList<Any> = ArrayList()) {
    fun add(item: Item) {
        content.add(item)
    }
    fun output() {
        try {
            val filename: String = title + ".html"
            val writer: Writer = FileWriter(filename)
            writer.write(this.makeHTML())
            writer.close()
            println("make " + filename)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
    abstract fun makeHTML(): String
}