package abstractFactory.factory

abstract class Item(protected val caption: String) {
    abstract fun makeHTML(): String
}

abstract class Link(protected val url: String, caption: String) : Item(caption) {
}

abstract class Tray(protected val tray: ArrayList<Any> = ArrayList(), caption: String) : Item(caption) {
    fun add(item: Item) {
        tray.add(item)
    }
}