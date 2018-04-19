package adapter

import java.io.*
import java.util.*

class FileProperties: Properties(), FileIO {
    override fun readFromFile(filename: String) {
        this.load(FileInputStream(filename))
    }

    override fun writeToFile(filename: String) {
        this.store(FileOutputStream(filename), "written by FileProperties")
    }

    override fun setValue(key: String, value: String) {
        this.setProperty(key, value)
    }

    override fun getValue(key: String) {
        this.getProperty(key, "")
    }

}