package chainOfResponsibility

abstract class Support(private val name: String) {
    private var next: Support? = null
    fun setNext(next: Support): Support {
        this.next = next
        return next
    }
    fun support(trouble: Trouble) {
        when {
            resolve(trouble) -> done(trouble)
            next != null -> next!!.support(trouble)
            else -> fail(trouble)
        }
    }

    override fun toString(): String = "[$name]"
    protected abstract fun resolve(trouble: Trouble): Boolean
    protected fun done(trouble: Trouble) {
        println(trouble.toString() + " is resolved by " + this + ".")
    }
    protected fun fail(trouble: Trouble) {
        println(trouble.toString() + " cannot be resolved.")
    }
}

class NoSupport(name: String): Support(name) {
    override fun resolve(trouble: Trouble): Boolean = false
}

class LimitSupport(name: String,
                   private val limit: Int): Support(name) {
    override fun resolve(trouble: Trouble): Boolean {
        return trouble.getNumber() < limit
    }
}

class OddSupport(name: String): Support(name) {
    override fun resolve(trouble: Trouble): Boolean {
        return trouble.getNumber() % 2 == 1
    }
}

class SpecialSupport(name: String,
                     private val number: Int): Support(name) {
    override fun resolve(trouble: Trouble): Boolean {
        return trouble.getNumber() == number
    }
}