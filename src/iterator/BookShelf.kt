package iterator

import java.util.ArrayList

class BookShelf: Aggregate {

    private var books: ArrayList<Book>

    constructor(initialize: Int) {
        this.books = ArrayList(initialize)
    }


    fun getBookAt(index: Int): Book {
        return books[index]
    }

    fun appendBook(book: Book) {
        books.add(book)
    }

    fun getLength(): Int {
        return books.size
    }

    override fun iterator(): Iterator {
        return BookShelfIterator(this)
    }
}
