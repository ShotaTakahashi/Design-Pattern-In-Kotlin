package flyweight

class BigString {
    private var bigchars: Array<BigChar?>
    constructor(string: String) {
        bigchars = arrayOfNulls(string.length)
        val factory = BigCharFactory
        for (i in 0 until bigchars.size) {
            bigchars[i] = factory.getBigChar(string[i])
        }
    }

    fun print() {
        for (i in 0 until bigchars.size) {
            bigchars[i]?.print()
        }
    }
}