package chapterThree.page

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

open class HomePage(private val driver: WebDriver) {

    private val searchField = By.cssSelector("input.searchBox")

    fun getTitle(): String {
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
        wait.until(ExpectedConditions.presenceOfElementLocated(searchField))
        return driver.title
    }
}
