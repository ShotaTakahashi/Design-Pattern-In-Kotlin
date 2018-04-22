package singleton

object TicketMaker {
    private var ticket: Int = 1000
    fun getNextTicketNumber(): Int {
        return ticket++
    }
}