import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertTrue
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions
import java.time.Duration

class SeleniumTest {

    private lateinit var driver: WebDriver

    @BeforeEach
    fun setUp() {
        val options = ChromeOptions()
        //options.addArguments("--headless")
        driver = ChromeDriver(options)
    }

    @Test
    fun testGoogleSearch() {
        driver.get("https://www.google.com")

        val searchBox = driver.findElement(By.name("q"))
        searchBox.sendKeys("Selenium Kotlin")
        searchBox.submit()

        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
        val results = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("h3")))

        assertTrue(results.isNotEmpty(), "Search should return results")

        val pageTitle = driver.title
        assertTrue(pageTitle.contains("Selenium Kotlin"), "Page title should contain 'Selenium Kotlin'")
    }

    @AfterEach
    fun tearDown() {
        driver.quit()
    }
}