package factory.idcard

import factory.framework.Product

class IDCard: Product {
    private val owner: String
    private val serial: Int
    constructor(owner: String, serial: Int) {
        println(owner + "(" + serial + ")" + "のカードを作ります．")
        this.owner = owner
        this.serial = serial
    }

    override fun use() {
        println(owner + "(" + serial + ")" + "のカードを使います．")
    }

    fun getOwner(): String{
        return owner
    }

    fun getSerial(): Int {
        return serial
    }
}