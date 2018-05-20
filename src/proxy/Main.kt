package proxy

fun main(args: Array<String>) {
    val p = PrinterProxy("Alice")
    println("Now, the name is ${p.getPrinterName()}.")
    p.setPrinterName("Bob")
    println("Now, the name is ${p.getPrinterName()}.")
    p.print("Hello, world.")
}