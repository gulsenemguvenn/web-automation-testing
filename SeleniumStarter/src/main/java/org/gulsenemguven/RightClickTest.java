package org.gulsenemguven;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class RightClickTest {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.guru99.com/test/simple_context_menu.html");

        Actions actions = new Actions(driver);

        WebElement button = driver.findElement(By.xpath("//*[@id='authentication']/span"));

        actions.contextClick(button).perform();

        WebElement copy = driver.findElement(By.cssSelector(".context-menu-icon-copy"));
        copy.click();

        driver.switchTo().alert().accept();

        // driver.quit();
    }
}
