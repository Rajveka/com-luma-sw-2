package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class RegisterTest extends BaseTest {

    String BaseUrl ="https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(BaseUrl);
    }
    @Test
    public void veifyThatSignInPageDisplay(){
        driver.findElement(By.linkText("Create an Account")).click();
        assert driver.findElement(By.xpath("/span[text()='Creat New Customer Account']")).isDisplayed();
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        driver.findElement(By.linkText("Create an Account")).click();
        driver.findElement(By.id("firstname")).sendKeys("Raj");
        driver.findElement(By.id("lastname")).sendKeys("Vekariya");
        driver.findElement(By.id("is_subscribed")).click();
        driver.findElement(By.id("email_address")).sendKeys("rajvekariya03@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Surat@1234");
        driver.findElement(By.id("password-confirmation")).sendKeys("Surat@1234");
        driver.findElement(By.xpath("//button[@title='Create an Account']")).click();
        assert driver.findElement(By.xpath("//span[text()='Thank you for registering with Main Website Store.']")).isDisplayed();
        driver.findElement(By.xpath("//button[@data-action='customer-menu-toggle']")).click();
        driver.findElement(By.linkText("Sign Out")).click();
        assert driver.findElement(By.xpath("//h1[text()='You are signed out']")).isDisplayed();
    }

    @After
    //close the browser
    public void tearDown() {
        closeBrowser();
    }
}

