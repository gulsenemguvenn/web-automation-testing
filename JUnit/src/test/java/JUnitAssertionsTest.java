import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JUnitAssertionsTest {

    WebDriver driver;

    @Test
    public void facebookTitleTest() {
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com");

        String expectedData = "Facebook";
        String actualData = driver.getTitle();

        System.out.println("Sayfa başlığı: " + actualData);

        assertNotNull(actualData, "Sayfa başlığı null olmamalı!");
        assertFalse(actualData.isEmpty(), "Başlık boş olmamalı!");
        assertTrue(actualData.contains(expectedData), "Sayfa başlığı bekleneni içermiyor!");

        System.out.println(" Başlık testleri başarıyla geçti.");
    }

    @Test
    public void nullVeExceptionTest() {
        String nullValue = getNullValue();

        assertNull(nullValue, "Değer null olmalı!");
        assertThrows(NumberFormatException.class, () -> Integer.parseInt("abc"));

        System.out.println(" Null ve exception testleri geçti.");
    }

    private String getNullValue() {
        return null;
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println(" Test tamamlandı - tarayıcı kapatıldı.");
        }
    }
}
