package facade.pagemaker

import java.io.FileInputStream
import java.io.IOException
import java.util.*

object Database {
    fun getProperites(dbname: String): Properties {
        val filename = "$dbname.txt"
        val prop = Properties()
        try {
            prop.load(FileInputStream(filename))
        } catch (e: IOException) {
            println("Warning $filename is not found.")
        }
        return prop
    }

}