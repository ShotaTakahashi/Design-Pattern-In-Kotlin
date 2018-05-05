package decorator

abstract class Display {
    abstract fun getColumns(): Int
    abstract fun getRows(): Int
    abstract fun getRowText(row: Int): String
    fun show() {
        for (i in 0 until getRows()) {
            println(getRowText(i))
        }
    }
}

class StringDisplay(private val string: String): Display() {
    override fun getColumns(): Int = string.toByteArray().size
    override fun getRows(): Int = 1
    override fun getRowText(row: Int): String {
        return when (row) {
            0 -> string
            else -> null.toString()
        }
    }
}