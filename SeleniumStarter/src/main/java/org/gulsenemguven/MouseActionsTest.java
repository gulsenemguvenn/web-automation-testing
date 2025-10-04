package org.gulsenemguven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.logging.Logger;

public class MouseActionsTest {

    private static final Logger logger = Logger.getLogger(MouseActionsTest.class.getName());

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            driver.get("https://www.amazon.com.tr/");

            WebElement element = driver.findElement(By.id("nav-link-accountList"));
            Actions actions = new Actions(driver);
            actions.moveToElement(element).perform();

            Thread.sleep(2000);

            System.out.println("Mouse, 'Hesap ve Listeler' elementinin üzerine getirildi.");

        } catch (Exception e) {

            logger.severe("Bir hata oluştu: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
