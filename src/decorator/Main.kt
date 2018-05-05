package decorator

fun main(args: Array<String>) {
    val b1 = StringDisplay("Hello, world.")
    val b2 = SideBorder(b1, '#')
    val b3 = FullBorder(b2)
    b1.show()
    b2.show()
    b3.show()
    val b4 = SideBorder(
            FullBorder(
                    FullBorder(
                            SideBorder(
                                    FullBorder(
                                            StringDisplay("こんにちは．")
                                    )
                                    ,
                                    '*'
                            )
                    )
            )
            ,
            '/'
    )
    b4.show()
}