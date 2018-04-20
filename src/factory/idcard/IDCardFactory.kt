package factory.idcard

import factory.framework.Factory
import factory.framework.Product
import kotlin.collections.ArrayList

class IDCardFactory: Factory() {
    private val database: HashMap<Int, String> = HashMap()
    private var serial: Int = 100
    override fun createProduct(owner: String): Product {
        return IDCard(owner, serial++)
    }

    override fun registerProduct(product: Product) {
        if(product is IDCard) {
            database.put(product.getSerial(), product.getOwner())
        }
    }
}