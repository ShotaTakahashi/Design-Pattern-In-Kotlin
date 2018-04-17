package iterator

abstract class BookShelf :Aggregate {
    private val books: Array<Book>
    private var last: Int

    constructor(books: Array<Book>) {
        this.books = books
        this.last = 0
    }

    fun getBookAt(index: Int): Book {
        return books[index]
    }

    fun appendBook(book: Book): Unit {
        this.books[last] = book
        last++
    }

    fun getLength(): Int {
        return last
    }

    override fun iterator(): Iterator {
        return BookShelfIterator(this)
    }
}