package bridge

fun main(args: Array<String>) {
    val d1: Display = Display(StringDisplayImpl("Hello, Japan."))
    val d2: Display = CountDisplay(StringDisplayImpl("Hello, World."))
    val d3: CountDisplay = CountDisplay(StringDisplayImpl("Hello, Universe."))
    d1.display()
    d2.display()
    d3.display()
    d3.multiDisplay(5)

    val rd: RandomCountDisplay = RandomCountDisplay(StringDisplayImpl("Hello, Japan."))
    rd.randomDisplay(10)

    val fd: CountDisplay = CountDisplay(FileDisplayImpl("start.txt"))
    fd.multiDisplay(3)

    val d4: IncreaseDisplay = IncreaseDisplay(CharDisplayImpl('<', '*', '>'), 1)
    val d5: IncreaseDisplay = IncreaseDisplay(CharDisplayImpl('|', '#', '-'), 2)
    d4.increaseDisplay(4)
    d5.increaseDisplay(6)
}