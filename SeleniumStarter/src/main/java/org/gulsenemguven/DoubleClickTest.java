package org.gulsenemguven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class DoubleClickTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.guru99.com/test/simple_context_menu.html");

        Actions actions = new Actions(driver);

        WebElement button = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));

        actions.doubleClick(button).perform();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.switchTo().alert().accept();

        // driver.quit();
    }
}
