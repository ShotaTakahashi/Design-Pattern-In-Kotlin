package prototype

import prototype.framework.*

class UnderlinePen: Product {
    private val ulchar: Char
    constructor(ulchar: Char) {
        this.ulchar = ulchar
    }

    override fun use(s: String) {
        val length: Int = s.toByteArray().size
        println("\"" + s + "\"")
        print(" ")
        for (i in 1..length) {
            print(ulchar)
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