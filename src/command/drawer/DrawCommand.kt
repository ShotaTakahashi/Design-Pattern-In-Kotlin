package command.drawer

import command.command.Command
import command.command.MacroCommand
import java.awt.Canvas
import java.awt.Color
import java.awt.Graphics
import java.awt.Point

interface Drawable {
    fun init()
    fun draw(x: Int, y: Int)
    fun setColor(color: Color)
}

open class DrawCommand(
        private val drawable: Drawable,
        private val position: Point
): Command {
    override fun execute() {
        drawable.draw(position.x, position.y)
    }
}

class DrawCanvas: Canvas, Drawable {
    private lateinit var color: Color
    private var radius: Int = 0
    private val history: MacroCommand

    constructor(width: Int, height: Int, history: MacroCommand) {
        setSize(width, height)
        background = Color.white
        this.history = history
        init()
    }

    override fun paint(g: Graphics) {
        history.execute()
    }
    override fun draw(x: Int, y: Int) {
        val g = graphics
        g.color = color
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2)
    }

    override fun init() {
        color = Color.red
        radius = 6
        history.append(ColorCommand(this, color))
    }

    override fun setColor(color: Color) {
        this.color = color
    }
}