package mediator

import java.awt.*
import java.awt.event.ItemEvent
import java.awt.event.ItemListener
import java.awt.event.TextEvent
import java.awt.event.TextListener

interface Colleague {
    fun setMediator(mediator: Mediator)
    fun setColleagueEnabled(enabled: Boolean)
}

class ColleagueButton(caption: String): Button(caption), Colleague {
    private var mediator: Mediator? = null
    override fun setMediator(mediator: Mediator) {
        this.mediator = mediator
    }

    override fun setColleagueEnabled(enabled: Boolean) {
        isEnabled = enabled
    }
}

class ColleagueTextField(text: String, columns: Int): TextField(text, columns), TextListener, Colleague {
    private var mediator: Mediator? = null
    override fun setMediator(mediator: Mediator) {
        this.mediator = mediator
    }

    override fun setColleagueEnabled(enabled: Boolean) {
        isEnabled = enabled
        background = if (enabled) Color.white else Color.lightGray
    }

    override fun textValueChanged(e: TextEvent?) {
        mediator!!.colleagueChanged()
    }
}

class ColleagueCheckbox(caption: String,
                        group: CheckboxGroup,
                        state: Boolean)
    :Checkbox(caption, group, state),
        ItemListener,
        Colleague {
    private var mediator: Mediator? = null
    override fun setMediator(mediator: Mediator) {
        this.mediator = mediator
    }

    override fun setColleagueEnabled(enabled: Boolean) {
        isEnabled = enabled
    }

    override fun itemStateChanged(e: ItemEvent?) {
        mediator!!.colleagueChanged()
    }
}