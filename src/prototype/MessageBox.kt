package prototype

import prototype.framework.*

class MessageBox: Product {
    private val decochar: Char
    constructor(decochar: Char) {
        this.decochar = decochar
    }

    override fun use(s: String) {
        val length: Int = s.toByteArray().size
        for (i in 1..length+4) {
            print(decochar)
        }
        println("")
        println(decochar + " " + s + " " + decochar)
        for (i in 1..length+4) {
            print(decochar)
        }
        println("")
    }

    override fun createClone(): Product {
        var p: Product? = null
        try {
            if (p is Product) {
                p = clone() as Product
            }
        } catch (e: CloneNotSupportedException) {
            e.printStackTrace()
        }
        return p!!
    }
}