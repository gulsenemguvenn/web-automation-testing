package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class StepDefinitions {

    @Given("go to login page")
    public void go_to_login_page() {
        System.out.println("Sayfaya gidildi");
    }

    @And("type username")
    public void type_username() {
        System.out.println("Kullanıcı adı dolduruldu");
    }

    @And("type password")
    public void type_password() {
        System.out.println("Şifre dolduruldu");
    }

    @When("click button")
    public void click_button() {
        System.out.println("Butona tıklandı");
    }

    @Then("assert to success message")
    public void assert_to_success_message() {
        System.out.println("Başarılı mesajı göründü");
    }
}
