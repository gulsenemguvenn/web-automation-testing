package org.gulsenemguven;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TooltipTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.guru99.com/test/social-icon.html");

        String expectedTooltip = "Github";

        WebElement githubButton = driver.findElement(By.xpath("//*[@id='page']/div[2]/div/a[4]"));

        String actualTooltip = githubButton.getAttribute("title");

        if (expectedTooltip.equals(actualTooltip)) {
            System.out.println("Tooltip is valid: " + actualTooltip);
        } else {
            System.out.println("Tooltip is NOT valid! Found: " + actualTooltip);
        }

        driver.quit();
    }
}
