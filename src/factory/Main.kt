package factory

import factory.framework.*
import factory.idcard.*

fun main(args: Array<String>) {
    val factory: Factory = IDCardFactory()
    val card1: Product = factory.create("A")
    val card2: Product = factory.create("B")
    val card3: Product = factory.create("C")
    card1.use()
    card2.use()
    card3.use()
}