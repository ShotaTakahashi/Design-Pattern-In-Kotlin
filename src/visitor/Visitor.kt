package visitor

abstract class Visitor {
    abstract fun visit(file: File)
    abstract fun visit(directory: Directory)
}

class ListVisitor(): Visitor() {
    private var currentdir: String = ""
    override fun visit(file: File) = println("$currentdir/$file")
    override fun visit(directory: Directory) {
        println("$currentdir/$directory")
        val savedir = currentdir
        currentdir = currentdir + "/" + directory.getName()
        val it = directory.iterator()
        while (it.hasNext()) {
            val entry = it.next() as Entry
            entry.accept(this)
        }
        currentdir = savedir
    }
}