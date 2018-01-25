package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends Base {

    private WebDriver driver;

    public Login(WebDriver loginDriver){
        super(loginDriver);
        driver = loginDriver;
        visit("http://the-internet.herokuapp.com/login");
    }

    By usernameLocator = By.id("username");
    By passwordLocator = By.id("password");
    By loginBtn = By.cssSelector("button");
    By successLocator = By.cssSelector(".flash.success");
    By failureLocator = By.cssSelector(".flash.error");


    public void visit(String url){
        driver.get(url);
    }
    public void with(String username, String password){
        type(usernameLocator, username);
        type(passwordLocator, password);
        click(loginBtn);
    }

    public boolean successMessagePresent(){
        return isDisplayed(successLocator);
    }

    public boolean failureMessagePresent() {
        return isDisplayed(failureLocator);
    }

    public boolean onLoginPage(){
        return isDisplayed(usernameLocator);
    }
}
