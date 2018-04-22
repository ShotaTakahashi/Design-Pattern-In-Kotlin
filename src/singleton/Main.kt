package singleton

fun main(args: Array<String>) {
    println("start")
    val obj1 = Singleton
    val obj2 = Singleton
    if(obj1 == obj2) {
        println("obj1 is the same as obj2.")
    } else {
        println("onj1 is not the same as obj2.")
    }
    println("end")
    println("start")
    for(i in 0..9) {
        println(i.toString() + ":" + TicketMaker.getNextTicketNumber().toString())
    }
    println("end")
    println("start")
    for(i in 0..9) {
        val triple: Triple = Triple.getInstance(i % 3)
        println(i.toString() + ":" + triple)
    }
    println("end")
}
