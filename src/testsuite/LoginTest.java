package testsuite;

import browserfactory.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        driver.findElement(By.linkText("Sign In")).click();
        driver.findElement(By.id("email")).sendKeys("rajvekariya03@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Surat@1234");
        driver.findElement(By.id("send2")).click();
        assert driver.findElement(By.xpath("//span[contains(text(), 'Welcome')]")).isDisplayed();
    }

    @Test
    public void verifyTheErrorMessageWithInvalidCredentials() {
        driver.findElement(By.linkText("Sign In")).click();
        driver.findElement(By.id("email")).sendKeys("rajvekariya0@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Surat@123");
        driver.findElement(By.id("send2")).click();
        assert driver.findElement(By.xpath("//div[contains(text(), 'The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.')]")).isDisplayed();
    }

    @Test
    public void userShouldLogOutSuccessfully() {
        driver.findElement(By.linkText("Sign In")).click();
        driver.findElement(By.id("email")).sendKeys("rajvekariya03@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Surat@1234");
        driver.findElement(By.id("send2")).click();
        assert driver.findElement(By.xpath("//span[contains(text(), 'Welcome')]")).isDisplayed();
        driver.findElement(By.xpath("//button[@data-action='customer-menu-toggle']")).click();
        driver.findElement(By.linkText("Sign Out")).click();
        assert driver.findElement(By.xpath("//h1[text()='You are signed out']")).isDisplayed();
    }
}
