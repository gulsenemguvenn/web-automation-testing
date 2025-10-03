package org.gulsenemguven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DriverMethods {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        String title = driver.getTitle();
        System.out.println("Sayfa başlığı: " + title);

        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);

        driver.navigate().to("https://www.selenium.dev");

        driver.navigate().back();

        driver.navigate().forward();

        driver.navigate().refresh();

        driver.manage().window().maximize();

        driver.quit();

    }

}
