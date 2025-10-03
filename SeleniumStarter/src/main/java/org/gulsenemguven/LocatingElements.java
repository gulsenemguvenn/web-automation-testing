package org.gulsenemguven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class LocatingElements {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.selenium.dev/");

        WebElement searchIcon = driver.findElement(By.id("navbarDropdown"));
        System.out.println("Bulunan element (By.id): " + searchIcon.getText());

        WebElement searchBox = driver.findElement(By.name("search"));
        System.out.println("Bulunan element (By.name): " + searchBox.getAttribute("name"));

        WebElement projectsLink = driver.findElement(By.xpath("//a[normalize-space()='Projects']"));
        System.out.println("Bulunan element (By.xpath): " + projectsLink.getText());

        WebElement documentationLink = driver.findElement(By.linkText("Documentation"));
        System.out.println("Bulunan element (By.linkText): " + documentationLink.getText());

        WebElement supportLink = driver.findElement(By.partialLinkText("Support"));
        System.out.println("Bulunan element (By.partialLinkText): " + supportLink.getText());

        WebElement firstHeader = driver.findElement(By.tagName("h1"));
        System.out.println("Bulunan element (By.tagName): " + firstHeader.getText());

        WebElement banner = driver.findElement(By.className("navbar-brand"));
        System.out.println("Bulunan element (By.className): " + banner.getText());

        driver.quit();
    }

}
