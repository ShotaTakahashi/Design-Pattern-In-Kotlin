package factory.idcard

import factory.framework.Factory
import factory.framework.Product
import kotlin.collections.ArrayList

class IDCardFactory: Factory() {
    private val owners: List<String> = ArrayList()
    override fun createProduct(owner: String): Product {
        return IDCard(owner)
    }

    override fun registerProduct(product: Product) {
        if(product is IDCard) {
            owners.plus(product.getOwner())
        }
    }
}