package template

class CharDisplay: AbstractDisplay {
    private val ch: Char
    constructor(ch: Char) {
        this.ch = ch
    }

    override fun open() {
        print("<<")
    }

    override fun print() {
        print(ch)
    }

    override fun close() {
        println(">>")
    }
}