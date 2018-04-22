package prototype.framework

interface Product: Cloneable {
    fun use(s: String)
    fun createClone(): Product
}