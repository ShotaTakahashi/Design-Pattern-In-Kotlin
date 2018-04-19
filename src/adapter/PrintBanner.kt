package adapter

class PrintBanner(string: String): Banner(string), Print {
    override fun printStrong() {
        showWithAster()
    }
    override fun printWeak() {
        showWithParen()
    }
}