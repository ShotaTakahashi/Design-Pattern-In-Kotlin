package command

import command.command.MacroCommand
import command.drawer.ColorCommand
import command.drawer.DrawCanvas
import command.drawer.DrawCommand
import java.awt.Color
import java.awt.event.*
import javax.swing.Box
import javax.swing.BoxLayout
import javax.swing.JButton
import javax.swing.JFrame
import kotlin.system.exitProcess

class Main: JFrame, ActionListener, MouseMotionListener, WindowListener {
    private val history = MacroCommand()
    private val canvas = DrawCanvas(400, 400, history)
    private val clearButton = JButton("clear")
    private val redButton = JButton("red")
    private val greenButton = JButton("green")
    private val blueButton = JButton("blue")
    private val undoButton = JButton("undo")

    constructor(title: String): super(title) {
        this.addWindowListener(this)
        canvas.addMouseMotionListener(this)
        clearButton.addActionListener(this)
        redButton.addActionListener(this)
        greenButton.addActionListener(this)
        blueButton.addActionListener(this)
        undoButton.addActionListener(this)

        val buttonBox = Box(BoxLayout.X_AXIS)
        buttonBox.add(clearButton)
        buttonBox.add(undoButton)
        buttonBox.add(redButton)
        buttonBox.add(greenButton)
        buttonBox.add(blueButton)
        val mainBox = Box(BoxLayout.Y_AXIS)
        mainBox.add(buttonBox)
        mainBox.add(canvas)
        contentPane.add(mainBox)

        pack()
        show()
    }

    override fun actionPerformed(e: ActionEvent) {
        if (e.source == clearButton) {
            history.clear()
            canvas.init()
            canvas.repaint()
        } else if (e.source == redButton) {
            val cmd = ColorCommand(canvas, Color.red)
            history.append(cmd)
            cmd.execute()
        } else if (e.source == greenButton) {
            val cmd = ColorCommand(canvas, Color.green)
            history.append(cmd)
            cmd.execute()
        } else if (e.source == blueButton) {
            val cmd = ColorCommand(canvas, Color.blue)
            history.append(cmd)
            cmd.execute()
        } else if (e.source == undoButton) {
            history.undo()
            canvas.repaint()
        }
    }

    override fun mouseMoved(e: MouseEvent?) {
    }

    override fun mouseDragged(e: MouseEvent?) {
        val cmd = DrawCommand(canvas, e!!.point)
        history.append(cmd)
        cmd.execute()
    }

    override fun windowClosing(e: WindowEvent?) {
        exitProcess(0)
    }

    override fun windowActivated(e: WindowEvent?) {}
    override fun windowClosed(e: WindowEvent?) {}
    override fun windowDeactivated(e: WindowEvent?) {}
    override fun windowDeiconified(e: WindowEvent?) {}
    override fun windowIconified(e: WindowEvent?) {}
    override fun windowOpened(e: WindowEvent?) {}

}

fun main(args: Array<String>) {
    Main("Command Pattern Sample")
}