package interpreter

import java.text.ParseException
import java.util.*

class Context {
    private lateinit var tokenizer: StringTokenizer
    private var currentToken: String? = null
    constructor(text: String) {
        tokenizer = StringTokenizer(text)
        nextToken()
    }

    fun nextToken(): String? {
        if (tokenizer.hasMoreTokens()) {
            currentToken = tokenizer.nextToken()
        } else {
            currentToken = null
        }
        return currentToken
    }

    fun currentToken(): String? {
        return currentToken
    }

    @Throws(ParseException::class)
    fun skipToken(token: String?) {
        if (!token.equals(currentToken)) {
            throw ParseException("Warning: $token is expected, but $currentToken is found.")
        }
        nextToken()
    }

    @Throws(ParseException::class)
    fun currentNumber(): Int {
        var number: Int
        try {
            number = Integer.parseInt(currentToken)
        } catch (e: NumberFormatException) {
            throw ParseException("Warning: $e")
        }
        return number
    }
}