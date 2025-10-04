package org.gulsenemguven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TakesScreenshot {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.facebook.com");

        org.openqa.selenium.TakesScreenshot ts = (org.openqa.selenium.TakesScreenshot) driver;

        File srcFile = ts.getScreenshotAs(OutputType.FILE);

        File destFile = new File(System.getProperty("user.home") + "/Desktop/SS/test.png");

        try {
            FileUtils.copyFile(srcFile, destFile);
            System.out.println(" Ekran görüntüsü başarıyla kaydedildi: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException(" Ekran görüntüsü kaydedilemedi!", e);
        }

        driver.quit();
    }
}
