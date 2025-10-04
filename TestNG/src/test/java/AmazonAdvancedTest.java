import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

public class AmazonAdvancedTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.out.println(" Test başlatılıyor...");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(priority = 1, description = "Amazon ana sayfasını açar ve doğrular.")
    public void openHomePage() {
        driver.get("https://www.amazon.com.tr/");
        String title = driver.getTitle();
        Assert.assertTrue(title != null && title.contains("Amazon"), "Sayfa başlığı Amazon içermiyor!");
        System.out.println(" Ana sayfa başarıyla açıldı.");
    }

    @Test(priority = 2, description = "Ürün arama testi (iPhone).", dependsOnMethods = "openHomePage")
    public void searchProduct() {
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iPhone");
        searchBox.submit();

        WebElement resultText = driver.findElement(By.xpath("//*[@id='search']/span[2]/div/h1/div/div[1]/div/div/span[1]"));
        Assert.assertTrue(resultText.isDisplayed(), "Arama sonuçları görüntülenemedi!");
        System.out.println(" Arama testi başarıyla geçti.");
    }

    @Test(priority = 3, description = "Ürünü favorilere ekleme testi (simülasyon).", dependsOnMethods = "searchProduct", invocationCount = 2)
    public void addToFavorites() {
        System.out.println(" Ürün favorilere eklendi (simülasyon).");
        Assert.assertTrue(true);
    }

    @Test(priority = 4, description = "Sepete ürün ekleme testi.", dependsOnMethods = "searchProduct", timeOut = 10000)
    public void addToCart() {
        driver.findElement(By.xpath("//div[@data-index='2']")).click();
        driver.findElement(By.id("add-to-cart-button")).click();
        String cartCount = driver.findElement(By.id("nav-cart-count")).getText();
        Assert.assertNotEquals(cartCount, "0", " Sepet boş!");
        System.out.println("🛒 Sepete ekleme testi başarıyla geçti.");
    }

    @Test(priority = 5, description = "Sepeti görüntüleme testi (devre dışı).", enabled = false)
    public void viewCart() {
        System.out.println(" Bu test devre dışı bırakıldı (enabled=false).");
    }

    @Test(priority = 6, description = "Sepeti kontrol etme testi.", dependsOnMethods = "addToCart")
    public void verifyCart() {
        driver.findElement(By.id("nav-cart-count-container")).click();
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle != null && pageTitle.contains("Sepet"), "Sepet sayfası görüntülenemedi!");
        System.out.println(" Sepet kontrol testi başarılı.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println(" Tarayıcı kapatıldı, test tamamlandı.");
        }
    }
}
