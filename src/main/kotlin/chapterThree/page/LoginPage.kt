package chapterThree.page

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class LoginPage(private val driver: WebDriver) {

    private val emailID = By.id("user_email")
    private val passwordField = By.id("user_password")
    private val signInButton = By.cssSelector("input.gr-button.gr-button--large")

    fun login(email: String, password: String): HomePage {
        driver.findElement(emailID).sendKeys(email)
        driver.findElement(passwordField).sendKeys(password)
        driver.findElement(signInButton).click()
        return HomePage(driver)
    }
}
