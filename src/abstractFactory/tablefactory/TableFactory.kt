package abstractFactory.tablefactory

import abstractFactory.factory.*

class TableFactory: AbstractFactory() {
    override fun createLink(caption: String, url: String): Link {
        return TableLink(caption, url)
    }

    override fun createTray(caption: String): Tray {
        return TableTray(caption)
    }

    override fun createPage(title: String, author: String): Page {
        return TablePage(title, author)
    }
}