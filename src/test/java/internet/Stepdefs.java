package internet;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Stepdefs {

    private WebDriver driver;
    private WebElement username;
    private WebElement password;
    private WebElement button;
    private WebElement successMessage;

    By usernameLocator = By.id("username");
    By passwordLocator = By.id("password");
    By loginBtn = By.cssSelector("button");
    By successLocator = By.id("flash");


    @Before
    public void setup(){
        driver = new FirefoxDriver();
        driver.navigate().to("http://the-internet.herokuapp.com/login");
    }

    @Given("^I am on the Loginpage$")
    public void i_am_on_the_Loginpage(){
        username = driver.findElement(usernameLocator);
        username.isDisplayed();
    }

    @When("^I enter my credentials$")
    public void i_enter_my_credentials(){
        username = driver.findElement(usernameLocator);
        username.sendKeys("tomsmith");
        password = driver.findElement(passwordLocator);
        password.sendKeys("SuperSecretPassword!");

        button = driver.findElement(loginBtn);
        button.click();
    }

    @Then("^I am logged in$")
    public void i_am_logged_in(){
        successMessage = driver.findElement(successLocator);
        successMessage.isDisplayed();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
