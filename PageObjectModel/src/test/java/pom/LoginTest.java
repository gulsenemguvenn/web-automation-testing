package pom;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void login() {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        loginPage.enterUsername("student");
        loginPage.enterPassword("Password123");
        loginPage.clickSubmitButton();
    }
}