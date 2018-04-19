package adapter

open class Banner {
    private val string: String
    constructor(string: String){
        this.string = string
    }

    fun showWithParen() {
        println("($string)")
    }
    fun showWithAster() {
        println("*$string*")
    }
}