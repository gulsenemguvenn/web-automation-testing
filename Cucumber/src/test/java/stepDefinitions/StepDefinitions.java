package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import utilities.MyDriver;
import java.time.Duration;

public class StepDefinitions {

    private WebDriver driver;
    LoginPage loginPage;

    @Given("go to login page")
    public void goToLoginPage() {
        driver = MyDriver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    @And("user types username as {string}")
    public void userTypesUsernameAs(String username) {
        loginPage = new LoginPage(driver);
        loginPage.setUsername(username);
    }

    @And("user types password as {string}")
    public void userTypesPasswordAs(String password) {
        loginPage.setPassword(password);
    }

    @When("click button")
    public void clickButton() {
        loginPage.clickButton();
    }

    @Then("assert to success message")
    public void assertToSuccessMessage() {
        loginPage.assertToSuccessMessage();
        MyDriver.closeDriver();
    }

    @Given("go to home page")
    public void goToHomePage() {
        driver = MyDriver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practicetestautomation.com/");
    }

    @When("wait two seconds")
    public void waitTwoSeconds() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("see {string} text")
    public void seeText(String text) {
        WebElement helloMessageEl = driver.findElement(By.className("post-title"));
        String helloMessage = helloMessageEl.getText();
        Assert.assertEquals(text, helloMessage);
        MyDriver.closeDriver();
    }
}
