package facade.pagemaker

import java.io.FileWriter
import java.io.IOException

object PageMaker {
    fun makeWelcomePage(mailaddr: String,
                        filename: String) {
        try {
            val mailprop = Database.getProperites("maildata")
            val usename = mailprop.getProperty(mailaddr)
            val writer = HtmlWriter(FileWriter(filename))
            writer.title("Welcome to $usename's page!")
            writer.paragraph("Welcome to $usename' page!")
            writer.paragraph("I wait your e-mail.")
            writer.mailto(mailaddr, usename)
            writer.close()
            println("$filename is created for $mailaddr ($usename)")
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}