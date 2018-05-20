package interpreter

import java.text.ParseException

abstract class Node {
    @Throws(ParseException::class)
    abstract fun parse(context: Context)
}

//<program> ::= program <command list>
class ProgramNode: Node() {
    private var commandListNode: Node? = null
    override fun parse(context:Context) {
        context.skipToken("program")
        commandListNode = CommandListNode()
        commandListNode!!.parse(context)
    }

    override fun toString(): String {
        return "[program $commandListNode]"
    }
}

class CommandListNode: Node() {
    private val list = ArrayList<Node>()

    override fun parse(context: Context) {
        while (true) {
            if (context.currentToken() == null) {
                throw ParseException("Missing 'end'", 0)
            } else if (context.currentToken().equals("end")) {
                context.skipToken("end")
                break
            } else {
                val commandNode = CommandNode()
                commandNode.parse(context)
                list.add(commandNode)
            }
        }
    }

    override fun toString(): String {
        return list.toString()
    }
}

class CommandNode: Node() {
    private var node: Node? = null
    override fun parse(context: Context) {
        if (context.currentToken().equals("repeat")) {
            val node = RepeatCommandNode()
            node.parse(context)
        } else {
            val node = PrimitiveCommandNode()
            node.parse(context)
        }
    }

    override fun toString(): String {
        return node.toString()
    }
}

class RepeatCommandNode: Node() {
    private var number: Int = 0
    private var commandListNode: Node? = null
    override fun parse(context: Context) {
        context.skipToken("repeat")
        number = context.currentNumber()
        context.nextToken()
        commandListNode = CommandListNode()
        commandListNode!!.parse(context)
    }

    override fun toString(): String {
        return "[repeat $number $commandListNode]"
    }
}

class PrimitiveCommandNode: Node() {
    private var name: String = ""
    override fun parse(context: Context) {
        name = context.currentToken()!!
        context.skipToken(name)
        if (name != "go" && name != "right" && name != "left") {
            throw ParseException("$name is undefined", 0)
        }
    }

    override fun toString(): String {
        return name
    }
}

