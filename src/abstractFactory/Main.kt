package abstractFactory

import abstractFactory.factory.*
import kotlin.system.exitProcess
import abstractFactory.factory.Tray
import java.nio.file.Files.createLink



fun main(args: Array<String>) {
    if (args.size != 1) {
        println("Usage: java Main class.name.of.ConcreteFactory")
        println("Example 1: java Main listfactory.ListFactory")
        println("Example 2: java Main tablefactory.TableFactory")
        exitProcess(0)
    }
    val factory = Factory.getFactory(args[0])

    val asahi: Link = factory.createLink("朝日新聞", "http://www.asahi.com/")
    val yomiuri: Link = factory.createLink("読売新聞", "http://www.yomiuri.co.jp/")

    val us_yahoo = factory.createLink("Yahoo!", "http://www.yahoo.com/")
    val jp_yahoo = factory.createLink("Yahoo!Japan", "http://www.yahoo.co.jp/")
    val excite = factory.createLink("Excite", "http://www.excite.com/")
    val google = factory.createLink("Google", "http://www.google.com/")

    val traynews = factory.createTray("新聞")
    traynews.add(asahi)
    traynews.add(yomiuri)

    val trayyahoo = factory.createTray("Yahoo!")
    trayyahoo.add(us_yahoo)
    trayyahoo.add(jp_yahoo)

    val traysearch = factory.createTray("サーチエンジン")
    traysearch.add(trayyahoo)
    traysearch.add(excite)
    traysearch.add(google)

    val page = factory.createPage("LinkPage", "AAA")
    page.add(traynews)
    page.add(traysearch)
    page.output()

}