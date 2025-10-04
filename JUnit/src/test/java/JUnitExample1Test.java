import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class JUnitExample1Test {

    WebDriver driver;

    @Before
    public void hazirlikYap() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void ziyaretEt1() {
        driver.get("https://www.facebook.com");
        bekle(2000);
        System.out.println(">>> Facebook testi tamamlandı!\n");
    }

    @Test
    public void ziyaretEt2() {
        driver.get("https://www.google.com");
        bekle(2000);
        System.out.println(">>> Google testi tamamlandı!\n");
    }

    @After
    public void tearDown() {
        System.out.println("Tarayıcı kapatılıyor...");
        driver.quit();
        System.out.println("Test sonlandırıldı.\n");
    }

    public void bekle(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}