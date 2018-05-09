package mediator

import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import kotlin.system.exitProcess

interface Mediator {
    fun createColleagues()
    fun colleagueChanged()
}

class LoginFrame: Frame, ActionListener, Mediator {
    private var checkGuest: ColleagueCheckbox? = null
    private var checkLogin: ColleagueCheckbox? = null
    private var textUser: ColleagueTextField? = null
    private var textPass: ColleagueTextField? = null
    private var buttonOk: ColleagueButton? = null
    private var buttonCancel: ColleagueButton? = null

    constructor(title: String): super(title) {
        this.title = title
        background = Color.lightGray
        layout = GridLayout(4, 2)
        createColleagues()
        add(checkGuest)
        add(checkLogin)
        add(Label("Username:"))
        add(textUser)
        add(Label("Password:"))
        add(textPass)
        add(buttonOk)
        add(buttonCancel)
        colleagueChanged()
        pack()
        show()
    }

    override fun createColleagues() {
        val g: CheckboxGroup = CheckboxGroup()
        checkGuest = ColleagueCheckbox("Guest", g, true)
        checkLogin = ColleagueCheckbox("Login", g, false)
        textUser = ColleagueTextField("", 10)
        textPass = ColleagueTextField("", 10)
        textPass!!.echoChar = '*'
        buttonOk  = ColleagueButton("OK")
        buttonCancel = ColleagueButton("Cancel")

        checkGuest!!.setMediator(this)
        checkLogin!!.setMediator(this)
        textUser!!.setMediator(this)
        textPass!!.setMediator(this)
        buttonOk!!.setMediator(this)
        buttonCancel!!.setMediator(this)

        checkGuest!!.addItemListener(checkGuest)
        checkLogin!!.addItemListener(checkLogin)
        textUser!!.addTextListener(textUser)
        textPass!!.addTextListener(textPass)
        buttonOk!!.addActionListener(this)
        buttonCancel!!.addActionListener(this)
    }

    override fun colleagueChanged() {
        if (checkGuest!!.state) {
            textUser!!.setColleagueEnabled(false)
            textPass!!.setColleagueEnabled(false)
            buttonOk!!.setColleagueEnabled(false)
        } else {
            textUser!!.setColleagueEnabled(true)
            userpassChanged()
        }
    }

    private fun userpassChanged() {
        if (textUser!!.text.isNotEmpty()) {
            textPass!!.setColleagueEnabled(true)
            if (textPass!!.text.isNotEmpty()) {
                buttonOk!!.setColleagueEnabled(true)
            } else {
                buttonOk!!.setColleagueEnabled(false)
            }
        } else {
            textPass!!.setColleagueEnabled(false)
            buttonOk!!.setColleagueEnabled(false)
        }
    }

    override fun actionPerformed(e: ActionEvent?) {
        println(e.toString())
        exitProcess(0)
    }
}