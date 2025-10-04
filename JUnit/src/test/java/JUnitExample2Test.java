import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class JUnitExample2Test {

    static WebDriver driver;

    @BeforeClass
    public static void setupTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println(" Tarayıcı başlatıldı ve test ortamı hazırlandı.\n");
    }

    @Test
    public void LoginTest() {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        try {
            Thread.sleep(2000);
            driver.findElement(By.id("username")).sendKeys("student");
            Thread.sleep(1000);
            driver.findElement(By.id("password")).sendKeys("Password123");
            Thread.sleep(1000);
            driver.findElement(By.id("submit")).click();
            Thread.sleep(2000);
            System.out.println(" Login testi tamamlandı!\n");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testPractice() {
        driver.get("https://practicetestautomation.com/practice-test-exceptions/");
        try {
            Thread.sleep(2000);
            driver.findElement(By.id("edit_btn")).click();
            Thread.sleep(1000);
            driver.findElement(By.id("add_btn")).click();
            Thread.sleep(2000);
            System.out.println(" Practice testi tamamlandı!\n");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterClass
    public static void tearDown() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
        System.out.println(" Tarayıcı kapatıldı. Tüm testler sonlandırıldı.\n");
    }
}