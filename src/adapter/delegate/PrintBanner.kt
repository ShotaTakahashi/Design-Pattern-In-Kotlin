package adapter.delegate

import adapter.Banner

class PrintBanner : Print {
    private val banner: Banner

    constructor(string: String) {
        this.banner = Banner(string)
    }

    override fun printWeak() {
        banner.showWithParen()
    }

    override fun printStrong() {
        banner.showWithAster()
    }
}