package chapterThree.base


import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

open class BaseTests {
    lateinit var driver: WebDriver

    @BeforeEach
    fun setUp() {
        val options = ChromeOptions()
        driver = ChromeDriver(options)
        driver.get("https://eCommerce.com/sign_in")
    }

    @AfterEach
    fun tearDown() {
        driver.quit()
    }

}