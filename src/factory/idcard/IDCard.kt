package factory.idcard

import factory.framework.Product

class IDCard: Product {
    private val owner: String
    constructor(owner: String) {
        println(owner + "のカードを作ります．")
        this.owner = owner
    }

    override fun use() {
        println(owner + "のカードを使います．")
    }

    fun getOwner(): String{
        return owner
    }
}