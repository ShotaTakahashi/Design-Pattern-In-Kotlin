package abstractFactory.tablefactory

import abstractFactory.factory.*

class TableLink(url: String,
                caption: String):
        Link(url = url,
        caption = caption) {
    override fun makeHTML(): String {
        return "<td><a href=\"" + url + "\">" + caption + "</a></td>\n"
    }
}