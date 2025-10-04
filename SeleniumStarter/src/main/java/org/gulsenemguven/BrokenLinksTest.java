package org.gulsenemguven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.HttpURLConnection;
import java.net.URI;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BrokenLinksTest {

    private static final Logger LOGGER = Logger.getLogger(BrokenLinksTest.class.getName());

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String homePage = "https://demo.guru99.com/test/newtours/";
        driver.get(homePage);

        try {

            List<WebElement> links = driver.findElements(By.tagName("a"));

            for (WebElement link : links) {
                String url = link.getAttribute("href");

                if (url == null || url.isEmpty()) {
                    System.out.println("  Boş bağlantı bulundu, atlandı.");
                    continue;
                }

                if (!url.startsWith(homePage)) {
                    System.out.println("  URL bizim sayfamıza ait değil, atlandı: " + url);
                    continue;
                }

                try {
                    HttpURLConnection connection = (HttpURLConnection) new URI(url).toURL().openConnection();
                    connection.setRequestMethod("HEAD");
                    connection.connect();

                    int respCode = connection.getResponseCode();

                    if (respCode >= 400) {
                        System.out.println(" Kırık link bulundu: " + url + " | Kod: " + respCode);
                    } else {
                        System.out.println(" Çalışan link: " + url + " | Kod: " + respCode);
                    }

                    connection.disconnect();

                } catch (Exception e) {
                    LOGGER.log(Level.WARNING, "Bağlantı kontrol edilirken hata oluştu: " + url, e);
                }
            }

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Beklenmeyen bir hata oluştu.", e);
        } finally {
            driver.quit();
        }
    }
}
