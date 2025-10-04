import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class JUnitSearchAssertionsTest {

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void mySearchTest() {
        driver.get("https://shop.demoqa.com/");

        driver.findElement(By.xpath("//a[@class='noo-search']")).click();

        WebElement searchBox = driver.findElement(By.name("s"));
        searchBox.sendKeys("DRESS");
        searchBox.sendKeys(Keys.ENTER);

        String expectedData = "Showing all 16 results";
        WebElement actualDataElement = driver.findElement(By.className("woocommerce-result-count"));
        String actualData = actualDataElement.getText();

        Assert.assertTrue(actualDataElement.isDisplayed());
        Assert.assertEquals(expectedData, actualData);
        Assert.assertTrue(actualData.contains("16"));
        Assert.assertFalse(actualData.contains("18"));
    }

    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
