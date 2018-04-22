package prototype.framework

class Manager {
    private val showcase: HashMap<String, Product> = HashMap()
    fun register(name: String, proto: Product) {
        showcase.put(name, proto)
    }
    fun create(protoname: String): Product {
        val p: Product = showcase.get(protoname) as Product
        return p.createClone()
    }
}