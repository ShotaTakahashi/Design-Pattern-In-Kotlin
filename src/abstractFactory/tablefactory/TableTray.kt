package abstractFactory.tablefactory

import abstractFactory.factory.*

class TableTray(caption: String): Tray(caption = caption) {
    override fun makeHTML(): String {
        val buffer = StringBuffer()
        buffer.append("<td>")
        buffer.append("<table width=\"100%\" border=\"1\"><tr>")
        buffer.append("<td bgcolor=\"#cccccc\" alogn=\"center\" colspan\""
                + tray.size + "\"><b>" + caption + "</b></td>")
        buffer.append("</tr>\n")
        buffer.append("<tr>\n")
        val it = tray.iterator()
        while (it.hasNext()) {
            val item = it.next() as Item
            buffer.append(item.makeHTML())
        }
        buffer.append("</tr></table>\n")
        buffer.append("</td>\n")
        return buffer.toString()
    }
}
