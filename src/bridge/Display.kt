package bridge

import java.util.*

open class Display(private val impl: DisplayImpl) {
    fun open() = impl.rawOpen()
    fun print() = impl.rawPrint()
    fun close() = impl.rawClose()
    fun display() {
        open()
        print()
        close()
    }
}

open class CountDisplay(impl: DisplayImpl): Display(impl) {
    fun multiDisplay(times: Int) {
        open()
        for (i in 1..times) {
            print()
        }
        close()
    }
}

class RandomCountDisplay(impl: DisplayImpl,
                         private val random: Random = Random()): CountDisplay(impl) {
    fun randomDisplay(times: Int) = multiDisplay(random.nextInt(times))
}

class IncreaseDisplay(impl: DisplayImpl,
                      private val step: Int): CountDisplay(impl) {
    fun increaseDisplay(level: Int) {
        var count: Int = 0
        for (i in 1..level) {
            multiDisplay(count)
            count += step
        }
    }
}