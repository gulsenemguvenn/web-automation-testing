package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import utilities.MyDriver;
import pages.LoginPage;
import java.time.Duration;

public class MyStepDefinitions {

    private WebDriver driver;
    LoginPage loginPage;

    @Given("go to login page")
    public void goToLoginPage() {
        driver = MyDriver.getDriver(); // WebDriver nesnesini MyDriver'dan alıyoruz
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practicetestautomation.com/practice-test-login/");
        System.out.println("🔹 Sayfaya gidildi");
    }

    @And("type username")
    public void typeUsername() {
        loginPage = new LoginPage(driver);
        loginPage.setUsername("student");
        System.out.println("🔹 Kullanıcı adı dolduruldu");
    }

    @And("type password")
    public void typePassword() {
        loginPage.setPassword("Password123");
        System.out.println("🔹 Şifre dolduruldu");
    }

    @When("click button")
    public void clickButton() {
        loginPage.clickButton();
        System.out.println("🔹 Butona tıklandı");
    }

    @Then("assert to success message")
    public void assertToSuccessMessage() {
        loginPage.assertToSuccessMessage();
        System.out.println("🔹 Başarılı mesajı göründü");
        MyDriver.closeDriver(); // Test sonunda tarayıcıyı kapatır
    }
}
