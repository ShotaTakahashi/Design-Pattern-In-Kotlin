package state

fun main(args: Array<String>) {
    val frame = SafeFrame("State Sample")
    while (true) {
        for (hour in 0 until 24) {
            frame.setClock(hour)
            try {
                Thread.sleep(1000)
            } catch (e: InterruptedException) {
            }
        }
    }
}