package state

import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import kotlin.system.exitProcess

class SafeFrame: Frame, ActionListener, Context {
    private val textClock = TextField(60)
    private val textScreen = TextArea(10, 60)
    private val buttonUse = Button("Use a safe")
    private val buttonAlarm = Button("Emergency call")
    private val buttonPhone = Button("Usual talk")
    private val buttonExit = Button("Finish")

    private var state: State = DayState

    constructor(title: String): super(title) {
        background = Color.lightGray
        layout = BorderLayout()
        add(textClock, BorderLayout.NORTH)
        textClock.isEditable = false
        add(textScreen, BorderLayout.CENTER)
        textScreen.isEditable = false
        val panel = Panel()
        panel.add(buttonUse)
        panel.add(buttonAlarm)
        panel.add(buttonPhone)
        panel.add(buttonExit)
        add(panel, BorderLayout.SOUTH)
        pack()
        show()
        buttonUse.addActionListener(this)
        buttonAlarm.addActionListener(this)
        buttonPhone.addActionListener(this)
        buttonExit.addActionListener(this)
    }

    override fun actionPerformed(e: ActionEvent?) {
        println(e.toString())
        when {
            e?.source == buttonUse -> state.doUse(this)
            e?.source == buttonAlarm -> state.doAlarm(this)
            e?.source == buttonPhone -> state.doPhone(this)
            e?.source == buttonExit -> exitProcess(0)
            else -> println("?")
        }
    }

    override fun setClock(hour: Int) {
        var clockstring = "Current time is "
        if (hour < 10) {
            clockstring += "0$hour:00"
        } else {
            clockstring += "$hour:00"
        }
        println(clockstring)
        textClock.text = clockstring
        state.doClock(this, hour)
    }

    override fun changeState(state: State) {
        println("Changed from ${this.state} to $state")
        this.state = state
    }

    override fun callSecurityCenter(msg: String) {
        textScreen.append("call! $msg \n")
    }

    override fun recordLog(msg: String) {
        textScreen.append("record ... $msg \n")
    }
}