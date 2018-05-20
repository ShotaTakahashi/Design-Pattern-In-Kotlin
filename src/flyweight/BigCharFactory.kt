package flyweight

object BigCharFactory {
    private val pool = HashMap<String, BigChar>()

    fun getBigChar(charname: Char): BigChar {
        var bigChar = pool["$charname"]
        if (bigChar == null) {
            bigChar = BigChar(charname)
            pool["$charname"] = bigChar
        }
        return bigChar
    }
}