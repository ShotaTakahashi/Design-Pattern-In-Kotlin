package adapter

import java.io.FileInputStream
import java.util.*

class FileProperties: FileIO, Properties() {
    override fun readFromFile(filename: String) {
        load(FileInputStream(filename))
    }

    override fun writeToFile(filename: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setValue(key: String, value: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getValue(key: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}