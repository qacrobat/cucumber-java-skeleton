package internet;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobjects.Login;

import static org.junit.Assert.assertTrue;

public class LoginSteps {

    private WebDriver driver;
    private Login login;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        login = new Login(driver);
    }

    @Given("^User is on Login Page$")
    public void user_is_on_Login_Page(){
        assertTrue("not on loginpage", login.onLoginPage());
    }

    @When("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_enters_and(String username, String password){
        login.with(username, password);
    }

    @Then("^Message displayed Login Successfully$")
    public void message_displayed_Login_Successfully(){
        assertTrue("success Message is not present", login.successMessagePresent());
    }

    @Then("^Message displayed that Login was not successful$")
    public void message_displayed_that_Login_was_not_successful(){
        assertTrue("failure Message is not present", login.failureMessagePresent());
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
