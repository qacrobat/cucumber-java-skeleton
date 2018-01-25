package internet;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.Login;

import static org.junit.Assert.assertTrue;

public class LoginSteps {

    private WebDriver driver;
    private Login login;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        login = new Login(driver);
    }

    @Given("^Go to Loginpage$")
    public void go_to_Loginpage(){
        driver.navigate().to("http://the-internet.herokuapp.com/login");
        assertTrue("not on loginpage", login.onLoginPage());
    }

    @When("^I enter my credentials$")
    public void i_enter_my_credentials(){
        login.with("tomsmith", "SuperSecretPassword!");
    }

    @Then("^I am logged in$")
    public void i_am_logged_in(){
        assertTrue("success Message is not present", login.successMessagePresent());
    }

    @When("^I enter invalid credentials$")
    public void i_enter_invalid_credentials(){
        login.with("tomsmith", "SuperSecretPassword!!!");

    }

    @Then("^I am not logged in$")
    public void i_am_not_logged_in(){
        assertTrue("failure Message is not present", login.failureMessagePresent());
    }


    @After
    public void tearDown(){
        driver.quit();
    }

}
