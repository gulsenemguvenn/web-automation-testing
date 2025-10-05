package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utilities.MyDriver;
import java.time.Duration;

public class StepDefinitions {

    private WebDriver driver;
    private LoginPage loginPage;

    @Given("go to login page")
    public void goToLoginPage() {
        driver = MyDriver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practicetestautomation.com/practice-test-login/");
        System.out.println("🔹 Sayfaya gidildi");
    }

    @And("user types username as {string}")
    public void userTypesUsernameAs(String username) {
        loginPage = new LoginPage(driver);
        loginPage.setUsername(username);
        System.out.println("🔹 Kullanıcı adı girildi: " + username);
    }

    @And("user types password as {string}")
    public void userTypesPasswordAs(String password) {
        loginPage.setPassword(password);
        System.out.println("🔹 Şifre girildi: " + password);
    }

    @When("click button")
    public void clickButton() {
        loginPage.clickButton();
        System.out.println("🔹 Giriş butonuna tıklandı");
    }

    @Then("assert to success message")
    public void assertToSuccessMessage() {
        loginPage.assertToSuccessMessage();
        System.out.println("🔹 Başarılı giriş mesajı göründü");
        MyDriver.closeDriver();
    }
}
