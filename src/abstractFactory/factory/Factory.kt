package abstractFactory.factory

object Factory {
    fun getFactory(classname: String): AbstractFactory {
        var factory: AbstractFactory? = null
        try {
            factory = Class.forName(classname).newInstance() as AbstractFactory
        } catch (e: ClassNotFoundException) {
            println("Not found " + classname )
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return factory!!
    }
}

abstract class AbstractFactory {
    abstract fun createLink(caption: String, url: String): Link
    abstract fun createTray(caption: String): Tray
    abstract fun createPage(title: String, author: String): Page
}