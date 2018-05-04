package abstractFactory.listfactory

import abstractFactory.factory.*

class ListTray(caption: String): Tray(caption = caption) {
    override fun makeHTML(): String {
        val buffer: StringBuffer = StringBuffer()
        buffer.append("<li>\n")
        buffer.append(caption + "\n")
        buffer.append("<ul>\n")
        val it = tray.iterator()
        while (it.hasNext()) {
            val item = it.next() as Item
            buffer.append(item.makeHTML())
        }
        buffer.append("</ul>\n")
        buffer.append("</li>\n")
        return buffer.toString()
    }
}