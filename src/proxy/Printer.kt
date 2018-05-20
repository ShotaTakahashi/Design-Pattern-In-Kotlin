package proxy

interface Printable {
    fun setPrinterName(name: String)
    fun getPrinterName(): String
    fun print(string: String)
}

class Printer(private var name: String): Printable {
    override fun setPrinterName(name: String) {
        this.name = name
    }

    override fun getPrinterName(): String {
        return name
    }

    override fun print(string: String) {
        println("=== $name ===")
        println(string)
    }

    private fun heavyJob(msg: String) {
        print(msg)
        for (i in 0 until 5) {
            try {
                Thread.sleep(1000)
            } catch (e: InterruptedException) {
            }
            print(".")
        }
        println("Done.")
    }
}

class PrinterProxy(private var name: String) : Printable {
    private var real: Printer? = null

    override fun setPrinterName(name: String) {
        if (real != null) {
            real?.setPrinterName(name)
        }
        this.name = name
    }

    override fun getPrinterName(): String {
        return name
    }

    override fun print(string: String) {
        realize()
        real?.print(string)
    }

    private fun realize() {
        if (real == null) {
            real = Printer(name)
        }
    }
}