package singleton

object Triple {
    private val id: Int=0
    private val triple: ArrayList<Triple>
        get() = ArrayList(3)

    fun getInstance(id: Int): Triple {
        return triple[id]
    }
    override fun toString(): String {
        return "[Triple id=$id]"
    }
}