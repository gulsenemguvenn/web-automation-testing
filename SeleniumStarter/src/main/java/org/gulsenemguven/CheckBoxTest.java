package org.gulsenemguven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class CheckBoxTest {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String baseURL = "https://demo.guru99.com/test/radio.html";
        driver.get(baseURL);

        WebElement checkBox1 = driver.findElement(By.id("vfb-6-0"));
        WebElement checkBox2 = driver.findElement(By.id("vfb-6-1"));
        WebElement checkBox3 = driver.findElement(By.id("vfb-6-2"));

        if (!checkBox1.isSelected()) {
            checkBox1.click();
            System.out.println("CheckBox 1 seçildi.");
        } else {
            System.out.println("CheckBox 1 zaten seçiliydi.");
        }

        if (!checkBox2.isSelected()) {
            checkBox2.click();
            System.out.println("CheckBox 2 seçildi.");
        } else {
            System.out.println("CheckBox 2 zaten seçiliydi.");
        }

        if (!checkBox3.isSelected()) {
            checkBox3.click();
            System.out.println("CheckBox 3 seçildi.");
        } else {
            System.out.println("CheckBox 3 zaten seçiliydi.");
        }

        driver.quit();

    }
}
