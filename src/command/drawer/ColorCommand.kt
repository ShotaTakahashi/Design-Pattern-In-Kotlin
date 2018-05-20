package command.drawer

import command.command.Command
import java.awt.Color

class ColorCommand(
        private val drawable: Drawable,
        private val color: Color
): Command {
    override fun execute() {
        drawable.setColor(color)
    }
}