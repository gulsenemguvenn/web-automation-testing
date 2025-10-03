package org.gulsenemguven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class MultipleLinksTest {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.guru99.com/test/link.html");

        List<WebElement> baglantilar = driver.findElements(By.linkText("click here"));

        System.out.println("Toplam link sayısı: " + baglantilar.size());

        if (baglantilar.size() > 1) {
            WebElement baglanti = baglantilar.get(1);
            baglanti.click();
            System.out.println("2. linke tıklandı!");
        } else {
            System.out.println("Yeterli link yok!");
        }

        driver.quit();
    }
}
