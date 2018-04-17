package iterator


fun main(args: Array<String>) {
    val bookShelf = BookShelf(4)
    bookShelf.appendBook(Book("Around the World in 80 Days"))
    bookShelf.appendBook(Book("Bible"))
    bookShelf.appendBook(Book("Cinderella"))
    bookShelf.appendBook(Book("Daddy-Long-Legs"))
   /* bookShelf.appendBook(Book("East of Eden"))
    bookShelf.appendBook(Book("Frankenstein"))
    bookShelf.appendBook(Book("Gulliver's Travels"))
    bookShelf.appendBook(Book("Hamlet"))*/
    val it: Iterator = bookShelf.iterator()
    while (it.hasNext()) {
        run {
            val book: Book = it.next() as Book
            println(message = book.name)
        }
    }
}