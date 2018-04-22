package prototype.framework

interface Product: Cloneable {
    fun use(s: String)
    fun createClone(): Product
    public override fun clone(): Any {
        return super.clone()
    }
}