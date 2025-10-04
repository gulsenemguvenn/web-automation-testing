package org.gulsenemguven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.logging.Logger;

public class DropdownTest {

    private static final Logger logger = Logger.getLogger(DropdownTest.class.getName());

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();

            driver.get("http://output.jsbin.com/osebed/2");

            WebElement country = driver.findElement(By.name("country"));
            Select dropCountry = new Select(country);
            dropCountry.selectByVisibleText("TURKEY");

            WebElement selectedCountry = dropCountry.getFirstSelectedOption();
            System.out.println("Seçilen Ülke: " + selectedCountry.getText());

            WebElement fruits = driver.findElement(By.id("fruits"));
            Select dropFruits = new Select(fruits);
            dropFruits.selectByVisibleText("Apple");

            WebElement selectedFruit = dropFruits.getFirstSelectedOption();
            System.out.println("Seçilen Meyve: " + selectedFruit.getText());

        } catch (Exception e) {
            logger.severe("Bir hata oluştu: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
