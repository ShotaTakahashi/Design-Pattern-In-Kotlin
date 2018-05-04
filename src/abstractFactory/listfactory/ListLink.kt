package abstractFactory.listfactory

import abstractFactory.factory.*

class ListLink(caption: String,
               url: String): Link(caption, url) {
    override fun makeHTML(): String {
        return " <li><a href=\"" + url + "\">" + caption + "</a></li>\n"
    }
}