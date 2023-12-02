package org.rapidswords;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Main {
    @Given("User is on Home Page")
    public void user_is_on_home_page() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        System.out.println("Home Page");
    }

    @When("User Navigate to LogIn Page")
    public void user_navigate_to_log_in_page() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        System.out.println("Navigation");
    }

    @When("User enters UserName and Password")
    public void user_enters_user_name_and_password() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        System.out.println("username and Password");
    }
    @Then("Message displayed Login Successfully")
    public void message_displayed_login_successfully() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        System.out.println("Displayed");
    }


}