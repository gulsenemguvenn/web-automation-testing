package org.gulsenemguven;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class PopupAlertTest {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.guru99.com/test/delete_customer.php");

        WebElement idInput = driver.findElement(By.name("cusid"));
        WebElement submitButton = driver.findElement(By.name("submit"));

        idInput.sendKeys("78582");
        submitButton.click();

        Alert alert = driver.switchTo().alert();

        String alertMessage = alert.getText();
        System.out.println("Popup mesajı: " + alertMessage);

        alert.accept();

        try {
            Thread.sleep(1000);
            Alert secondAlert = driver.switchTo().alert();
            System.out.println("İkinci popup: " + secondAlert.getText());
            secondAlert.accept();
        } catch (Exception e) {
            System.out.println("İkinci popup bulunamadı.");
        }

        driver.quit();
    }
}
