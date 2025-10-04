package org.gulsenemguven;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TabsHandling {
    private static final Logger logger = Logger.getLogger(TabsHandling.class.getName());

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            driver.get("https://demo.guru99.com/popup.php");

            WebElement link = driver.findElement(By.xpath("//a[contains(@href,'popup.php') or contains(text(),'Click Here')]"));
            link.click();

            Thread.sleep(1500);

            Set<String> handlesSet = driver.getWindowHandles();
            logger.info("Window handles (set): " + handlesSet);

            List<String> handles = new ArrayList<>(handlesSet);

            if (handles.size() < 2) {
                logger.severe("Yeni sekme/pencere görünmüyor. Popup engelleyici olabilir veya link yeni sekme açmıyor.");
                return;
            }

            String originalHandle = driver.getWindowHandle();
            String newHandle = null;
            for (String h : handles) {
                if (!h.equals(originalHandle)) {
                    newHandle = h;
                    break;
                }
            }

            if (newHandle == null) {
                logger.severe("Yeni pencere handle bulunamadı.");
                return;
            }

            driver.switchTo().window(newHandle);
            logger.info("Switched to new window: " + newHandle);

            driver.findElement(By.name("emailid")).sendKeys("test@example.com");
            driver.findElement(By.name("btnLogin")).click();

            driver.close();
            driver.switchTo().window(originalHandle);
            logger.info("Returned to original window: " + originalHandle);

        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
            logger.log(Level.SEVERE, "Thread interrupted", ie);
        } catch (NoSuchElementException ne) {
            logger.log(Level.SEVERE, "Element bulunamadı: kontrol et lütfen locator'ı", ne);
        } catch (WebDriverException we) {
            logger.log(Level.SEVERE, "Webdriver hatası", we);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Beklenmeyen hata", e);
        } finally {
            driver.quit();
        }
    }


}
