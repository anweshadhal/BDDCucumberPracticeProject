package StepDefinitions;


import Pages.FacebookLoginPage;
import Utilities.ScreenshotUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static Utilities.ScreenshotUtil.folder;

public class FacebookLoginSteps {
    FacebookLoginPage loginPage=new FacebookLoginPage();
    @Given("User is able to login to launch the facebook login page")
    public void user_is_able_to_login_to_launch_the_facebook_login_page() throws IOException {
        System.out.println("Given Method");
        ScreenshotUtil.addScreenshotToAllureReport(folder,"Instagram Login Page");
    }
    @When("User enters the {string} and {string} and hit enter")
    public void user_enters_the_and_and_hit_enter(String username, String password) throws InterruptedException, IOException {
        System.out.println("When Method");
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        ScreenshotUtil.addScreenshotToAllureReport(folder,"Instagram Login after updating userID and password");
        loginPage.clickLogin();
    }
    @Then("User should be able to navigate to the facebook home page")
    public void user_should_be_able_to_navigate_to_the_facebook_home_page() throws InterruptedException, IOException {
        System.out.println("Then Method");
        loginPage.validateTitleofHome();
        ScreenshotUtil.addScreenshotToAllureReport(folder,"Instagram home Page");
    }
    @Then("User validates the home page")
    public void user_validates_the_home_page() {
      System.out.println("And Method");
    }
}
