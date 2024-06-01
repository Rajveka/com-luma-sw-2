package testsuite;

import browserfactory.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SaleTest extends BaseTest {

    @Test
    public void verifyTheTotalItemsDisplayedOnTheWomensJacketsPage() {
        driver.findElement(By.linkText("Sale")).click();
        driver.findElement(By.linkText("Jackets")).click();
        assert driver.findElement(By.xpath("//h1/span[text()='Jackets']")).isDisplayed();
        List<WebElement> items = driver.findElements(By.xpath("//ol[@class='products list items product-items']/li"));
        items.forEach(item -> System.out.println(item.findElement(By.className("product-item-link")).getText()));
        assert items.size() == 12;
    }
}
