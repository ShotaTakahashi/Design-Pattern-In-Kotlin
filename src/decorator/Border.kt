package decorator

abstract class Border(protected val display: Display): Display()

class SideBorder(display: Display,
                 private val borderChar: Char): Border(display) {
    override fun getColumns(): Int = 1 + display.getColumns() + 1
    override fun getRows(): Int = display.getRows()
    override fun getRowText(row: Int): String = borderChar + display.getRowText(row) + borderChar
}

class FullBorder(display: Display): Border(display) {
    override fun getColumns(): Int = 1 + display.getColumns() + 1
    override fun getRows(): Int = 1 + display.getRows() + 1
    override fun getRowText(row: Int): String {
        return when(row) {
            0 -> "+" + makeLine('-', display.getColumns()) + "+"
            display.getRows() + 1 -> "+" + makeLine('-', display.getColumns()) + "+"
            else -> "|" + display.getRowText(row - 1) + "|"
        }
    }
    private fun makeLine(ch: Char, count: Int): String {
        val buffer = StringBuilder()
        for (i in 0 until count) {
            buffer.append(ch)
        }
        return buffer.toString()
    }
}