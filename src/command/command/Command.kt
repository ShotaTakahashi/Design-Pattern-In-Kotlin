package command.command

import java.util.*

interface Command {
    fun execute()
}

class MacroCommand: Command {
    private val commands = Stack<Command>()

    override fun execute() {
        val it = commands.iterator()
        while (it.hasNext()) {
            it.next().execute()
        }
    }

    fun append(cmd: Command) {
        if (cmd != this) {
            commands.push(cmd)
        }
    }

    fun undo() {
        if (!commands.empty()) {
            commands.pop()
        }
    }

    fun clear() {
        commands.clear()
    }
}