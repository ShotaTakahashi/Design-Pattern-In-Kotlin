package composite

abstract class Entry {
    abstract fun getName(): String
    abstract fun getSize(): Int
    open fun add(entry: Entry): Entry {
        throw FileTreatmentException()
    }
    fun printList() = printList("")
    abstract fun printList(prefix: String)
    override fun toString(): String = getName() + "(" + getSize() + ")"
}

class File(private val name: String,
           private val size: Int): Entry() {
    override fun getName(): String = name

    override fun getSize(): Int = size

    override fun printList(prefix: String) {
        println(prefix + "/" + this)
    }
}

class Directory(private val name: String): Entry() {
    private val directory: ArrayList<Entry> = ArrayList()
    override fun getName(): String = name
    override fun getSize(): Int {
        var size = 0
        val it = directory.iterator()
        while (it.hasNext()) {
            val entry = it.next() as Entry
            size += entry.getSize()
        }
        return size
    }
    override fun add(entry: Entry): Entry {
        directory.add(entry)
        return this
    }

    override fun printList(prefix: String) {
        println(prefix + "/" + this)
        val it = directory.iterator()
        while (it.hasNext()) {
            val entry = it.next() as Entry
            entry.printList(prefix + "/" + name)
        }
    }
}