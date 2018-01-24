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

public class LoginTest {

    private WebDriver driver;
    private Login login;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        login = new Login(driver);
        driver.navigate().to("http://the-internet.herokuapp.com/login");
    }


    @Given("^I am on the Loginpage$")
    public void i_am_on_the_Loginpage(){
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

    @After
    public void tearDown(){
        driver.quit();
    }

}
