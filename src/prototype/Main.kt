package prototype

import prototype.framework.*

fun main(args: Array<String>) {
    val manager: Manager = Manager()
    val upen: UnderlinePen = UnderlinePen('~')
    val mbox: MessageBox = MessageBox('*')
    val sbox: MessageBox = MessageBox('/')
    manager.register("strong message", upen)
    manager.register("warning box", mbox)
    manager.register("slash box", sbox)

    val p1: Product = manager.create("strong message")
    p1.use("Hello, world.")
    val p2: Product = manager.create("warning box")
    p2.use("Hello, world.")
    val p3: Product = manager.create("slash box")
    p3.use("Hello, world.")
}