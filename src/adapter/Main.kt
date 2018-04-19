package adapter
import java.io.*

fun main(args: Array<String>) {
    val print = PrintBanner("Hello")
    print.printWeak()
    print.printStrong()

    val f = FileProperties()
    try {
        f.readFromFile("file.txt")
        f.setValue("year", "2018")
        f.setValue("month", "4")
        f.setValue("day", "19")
        f.writeToFile("newfile.txt")
    } catch (e: IOException) {
        e.printStackTrace()
    }
}