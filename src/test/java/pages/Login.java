package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

    private WebDriver driver;

    public Login(WebDriver driver){
        this.driver = driver;
    }

    By usernameLocator = By.id("username");
    By passwordLocator = By.id("password");
    By loginBtn = By.cssSelector("button");
    By successLocator = By.cssSelector(".flash.success");
    By failureLocator = By.cssSelector(".flash.error");


    public void with(String username, String password){
        driver.findElement(usernameLocator).sendKeys(username);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(loginBtn).click();

    }

    public boolean successMessagePresent(){
        return driver.findElement(successLocator).isDisplayed();
    }

    public boolean failureMessagePresent() {
        return driver.findElement(failureLocator).isDisplayed();
    }

    public boolean onLoginPage(){
        return driver.findElement(usernameLocator).isDisplayed();
    }



}
