package template

class StringDisplay: AbstractDisplay {
    private val string: String
    private val width: Int
    constructor(string: String) {
        this.string = string
        this.width = string.toByteArray().size
    }

    override fun open() {
        printLine()
    }

    override fun print() {
        println("|" + string + "|")
    }

    override fun close() {
        printLine()
    }

    private fun printLine() {
        print("+")
        for(i in 1..width) {
            print("-")
        }
        println("+")
    }

}