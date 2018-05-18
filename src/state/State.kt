package state

interface State {
    fun doClock(context: Context, hour: Int)
    fun doUse(context: Context)
    fun doAlarm(context: Context)
    fun doPhone(context: Context)
}

object DayState: State {
    override fun doClock(context: Context, hour: Int) {
        if (hour < 9 || 17 <= hour) {
            context.changeState(NightState)
        }
    }

    override fun doUse(context: Context) {
        context.recordLog("A safe is used (Day)")
    }

    override fun doAlarm(context: Context) {
        context.callSecurityCenter("Emergency call (Day)")
    }

    override fun doPhone(context: Context) {
        context.callSecurityCenter("Usually Talk (Day)")
    }

    override fun toString(): String {
        return "[Day]"
    }
}

object NightState: State {
    override fun doClock(context: Context, hour: Int) {
        if (hour in 9..16) {
            context.changeState(DayState)
        }
    }

    override fun doUse(context: Context) {
        context.callSecurityCenter("Emergency:A safe is used in the night !!")
    }

    override fun doAlarm(context: Context) {
        context.callSecurityCenter("Emergency call (Night)")
    }

    override fun doPhone(context: Context) {
        context.recordLog("Record talk in the night.")
    }

    override fun toString(): String {
        return "[Night]"
    }
}