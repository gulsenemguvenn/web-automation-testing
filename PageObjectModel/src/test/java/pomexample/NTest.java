package pomexample;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class NTest extends BaseTest {

    TabBarPage tabBarPage;
    ResultPage resultPage;
    ProductDetailPage productDetailPage;

    @Test(priority = 1)
    public void searchTest() {
        driver.get("https://www.n11.com/");
        tabBarPage = new TabBarPage(driver);
        tabBarPage.search("Laptop");
    }

    @Test(priority = 2)
    public void resultPageTest() {
        resultPage = new ResultPage(driver);
        WebElement resultWebElement = resultPage.getResultWebElement();
        softAssert.assertTrue(resultWebElement.isDisplayed(), "Search results are not displayed!");
        resultPage.clickToFirstProduct();
    }

    @Test(priority = 3)
    public void addToCartTest() {
        productDetailPage = new ProductDetailPage(driver);
        productDetailPage.addToCart();
        softAssert.assertTrue(
                tabBarPage.getBasketTotalNumber().equals("1"),
                "Basket total number is not 1!"
        );
    }
}