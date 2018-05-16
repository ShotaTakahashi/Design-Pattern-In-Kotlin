package memento.game

import java.util.*
import kotlin.collections.ArrayList

class Gamer(private var money: Int) {
    private var fruits = ArrayList<String>()
    private val random = Random()
    private val fruitsname: List<String> = listOf("apple", "grape", "banana", "orange")

    inner class Memento(val money: Int,
                        private val fruits: ArrayList<String> = ArrayList()) {
        fun addFruit(fruit: String) {
            fruits.add(fruit)
        }
        fun getFruits(): List<String> {
            return fruits.clone() as List<String>
        }
    }

    fun getMoney(): Int = money

    fun bet() {
        val dice = random.nextInt(6) + 1
        when {
            dice == 1 -> {
                money += 100
                println("add money")
            }
            dice == 2 -> {
                money /= 2
                println("half")
            }
            dice == 6 -> {
                val f = getFruits()
                println("get $f")
                fruits.add(f)
            }
            else -> {
                println("nothing happens")
            }
        }
    }

    fun createMemento(): Memento {
        val memento = Memento(money)
        val it = fruits.iterator()
        while (it.hasNext()) {
            val f = it.next()
            if (f.startsWith("good")) {
                memento.addFruit(f)
            }
        }
        return memento
    }

    fun restoreMemento(memento: Memento) {
        this.money = memento.money
        this.fruits = memento.getFruits() as ArrayList<String>
    }

    override fun toString(): String {
        return "[money = $money, fruits = $fruits]"
    }
    private fun getFruits(): String {
        var prefix = ""
        if (random.nextBoolean()) {
            prefix = "good "
        }
        return prefix + fruitsname[random.nextInt(fruitsname.size)]
    }
}