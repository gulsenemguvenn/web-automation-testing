package org.gulsenemguven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
public class ImageSelectTest {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.hepsiburada.com/rks-gt25-katlanabilir-elektrikli-bisiklet-p-HBCV00005Q4D2?magaza=Hepsiburada");

        WebElement logo = driver.findElement(By.xpath("//a[@title='Hepsiburada']"));

        logo.click();

        driver.quit();
    }
}
