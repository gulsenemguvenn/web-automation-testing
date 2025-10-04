import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class AmazonTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void searchTest() {
        driver.get("https://www.amazon.com.tr/ref=nav_logo");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iPhone");
        searchBox.submit();

        WebElement resultText = driver.findElement(By.xpath("//*[@id='search']/span[2]/div/h1/div/div[1]/div/div/span[1]"));
        Assert.assertTrue(resultText.isDisplayed(), "Arama sonucu görüntülenemedi!");

        System.out.println(" Arama testi başarıyla geçti.");
    }

    @Test
    public void addToCartTest() {
        driver.findElement(By.id("sp-cc-accept")).click(); // Çerezleri kabul et

        driver.findElement(By.xpath("//div[@data-index='5'][1]")).click();
        driver.findElement(By.id("add-to-cart-button")).click();

        String count = driver.findElement(By.id("nav-cart-count")).getText();

        Assert.assertNotEquals(count, "0", "Sepet boş olmamalı!");

        System.out.println(" Sepet testi başarıyla geçti.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        System.out.println(" Tarayıcı kapatıldı, test tamamlandı.");
    }
}
