package builder

class Director {
    private val builder: Builder
    constructor(builder: Builder) {
        this.builder = builder
    }

    fun constract() {
        builder.makeTitle("Greeting")
        builder.makeString("from morning to noon")
        builder.makeItems(mutableListOf("Good mornig", "Good afternoon"))
        builder.makeString("at night")
        builder.makeItems(mutableListOf("Good night", "Good bye"))
        builder.close()
    }
}