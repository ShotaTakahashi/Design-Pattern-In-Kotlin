package observer

interface Observer {
    fun update(generator: NumberGenerator)
}

class DigitObserver: Observer {
    override fun update(generator: NumberGenerator) {
        println("DigitObserver:${generator.getNumber()}")
        try {
            Thread.sleep(100)
        } catch (e: InterruptedException) {
        }
    }
}

class GraphObserver: Observer {
    override fun update(generator: NumberGenerator) {
        println("GraphObserver:")
        val count: Int = generator.getNumber()
        for (i in 0 until count) {
            print('*')
        }
        println("")
        try {
            Thread.sleep(100)
        } catch (e: InterruptedException) {
        }
    }
}