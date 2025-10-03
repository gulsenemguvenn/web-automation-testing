package org.gulsenemguven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginTest {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String baseURL = "https://demo.guru99.com/test/login.html";
        driver.get(baseURL);

        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("passwd"));

        email.sendKeys("gulsenem@outlook.com");
        password.sendKeys("1234");

        WebElement button = driver.findElement(By.id("SubmitLogin"));
        button.click();

        String pageTitle = driver.getTitle();
        System.out.println("Sayfa Başlığı: " + pageTitle);

        driver.quit();
    }
}
