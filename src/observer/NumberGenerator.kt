package observer

import java.util.*

abstract class NumberGenerator {
    private val observers: ArrayList<Observer> = arrayListOf()
    fun addObserver(observer: Observer) {
        observers.add(observer)
    }
    fun deleteObserver(observer: Observer) {
        observers.remove(observer)
    }
    fun notifyObserver() {
        val it = observers.iterator()
        while (it.hasNext()) {
            val o = it.next() as Observer
            o.update(this)
        }
    }
    abstract fun getNumber(): Int
    abstract fun execute()
}

class RandomNumberGenerator: NumberGenerator() {
    private val random: Random = Random()
    private var number: Int = 0
    override fun getNumber(): Int = number
    override fun execute() {
        for (i in 0 until 20) {
            number = random.nextInt(50)
            notifyObserver()
        }
    }
}