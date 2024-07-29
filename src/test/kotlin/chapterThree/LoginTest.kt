package chapterThree

import chapterThree.base.BaseTests
import chapterThree.page.LoginPage
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import java.nio.file.Files
import java.nio.file.Paths

class LoginTest : BaseTests() {

    @Test
    fun verifySuccessfulLogin() {
        val loginPage = LoginPage(driver)
        try {
            assertEquals(loginPage.login("example@gmail.com", "Admin123").getTitle(), "Home page")
        } catch (e: AssertionError) {
            val screenshot = (driver as TakesScreenshot).getScreenshotAs(OutputType.FILE)
            Files.copy(screenshot.toPath(), Paths.get("src/main/resources/screenshots/img.png"))
            throw e
        }
    }
}
