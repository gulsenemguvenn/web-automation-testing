package org.gulsenemguven;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FileUploadTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.guru99.com/test/upload/");

        WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));

        uploadElement.sendKeys("/Users/gulse/web-automation-testing/SeleniumStarter/src/images/Selenium_Logo.png");

        driver.findElement(By.id("terms")).click();

        driver.findElement(By.id("submitbutton")).click();

        // driver.quit();
    }
}
