package chainOfResponsibility

class Trouble(private val number: Int) {
    override fun toString(): String = "[Trouble $number]"
    fun getNumber(): Int = number
}