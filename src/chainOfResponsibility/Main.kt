package chainOfResponsibility

fun main(args: Array<String>) {
    val alice = NoSupport("Alice")
    val bob = LimitSupport("Bob", 100)
    val charlie = SpecialSupport("Charlie", 429)
    val diana = LimitSupport("Diana", 200)
    val elmo = OddSupport("Elmo")
    val fred = LimitSupport("Fred", 300)
    alice.setNext(bob)
            .setNext(charlie)
            .setNext(diana)
            .setNext(elmo)
            .setNext(fred)
    for (i in 0 until 500 step 33) {
        alice.support(Trouble(i))
    }
}
