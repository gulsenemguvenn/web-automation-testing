package pomexample;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class TabBarPage {

    private final WebDriver driver;
    private final By searchBoxLocator = By.id("searchData");
    private final By basketTotalNumberLocator = By.className("basketTotalNum");

    public TabBarPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchWord(String searchWord) {
        driver.findElement(searchBoxLocator).sendKeys(searchWord + Keys.ENTER);
    }

    public String getBasketTotalNumber() {
        return driver.findElement(basketTotalNumberLocator).getText();
    }
}
