package org.gulsenemguven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        String baseURL = "https://www.google.com";
        driver.get(baseURL);

        String expectedData = "Google";
        String actualData = driver.getTitle();

        if (expectedData.equals(actualData)) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }

        driver.quit();

    }
}
