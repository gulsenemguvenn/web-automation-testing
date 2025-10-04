package org.gulsenemguven;

import java.io.File;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FileDownload {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        driver.get("https://demoqa.com/upload-download");

        driver.findElement(By.id("downloadButton")).click();

        String downloadPath = System.getProperty("user.home") + "/Downloads";
        String fileName = "sampleFile.jpeg";

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        boolean isDownloaded = isFileDownloaded(downloadPath, fileName);
        if (isDownloaded) {
            System.out.println(" Dosya başarıyla indirildi: " + fileName);
        } else {
            System.out.println(" Dosya indirilemedi veya bulunamadı: " + fileName);
        }

        driver.quit();
    }

    public static boolean isFileDownloaded(String downloadPath, String fileName) {
        File folder = new File(downloadPath);

        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println(" Geçersiz indirme klasörü: " + downloadPath);
            return false;
        }

        File[] files = folder.listFiles();
        if (files == null || files.length == 0) {
            System.out.println(" Klasörde hiç dosya bulunamadı.");
            return false;
        }

        for (File file : files) {
            if (file.getName().equals(fileName)) {
                return true;
            }
        }

        return false;
    }
}
