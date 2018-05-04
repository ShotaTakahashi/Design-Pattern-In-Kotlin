package strategy

import java.util.*

interface Strategy {
    fun nextHand(): Hand
    fun study(win: Boolean)
}

class WinningStrategy(private val seed: Int,
                      private val random: Random = Random(seed.toLong())): Strategy {
    private var won: Boolean = false
    private var prevHand: Hand? = null

    override fun nextHand(): Hand {
        if (!won) {
            prevHand = Hand.getHand(random.nextInt(3))
        }
    return prevHand!!
    }

    override fun study(win: Boolean) {
        won = win
    }
}

class ProbStrategy(private val seed: Int,
                   private val random: Random = Random(seed.toLong())): Strategy {
    private var prevHandValue: Int = 0
    private var currentHandValue: Int = 0
    private var history = Array(3, {Array(3, {1})})
    override fun nextHand(): Hand {
        val bet: Int = random.nextInt(getSum(currentHandValue))
        var handvalue: Int
        handvalue = when {
            (bet < history[currentHandValue][0]) -> 0
            (bet < history[currentHandValue][0] + history[currentHandValue][1]) -> 1
            else -> 2
        }
        prevHandValue = currentHandValue
        currentHandValue = handvalue
        return Hand.getHand(handvalue)
    }
    
    private fun getSum(hv: Int): Int {
        var sum = 0
        for (i in 0..2) sum += history[hv][i]
        return sum
    }

    override fun study(win: Boolean) {
        if (win) history[prevHandValue][currentHandValue]++
        else {
            history[prevHandValue][(currentHandValue + 1) % 3]++
            history[prevHandValue][(currentHandValue + 2) % 3]++
        }
    }
}