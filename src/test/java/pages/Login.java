package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Login {

    private WebDriver driver;

    public Login(WebDriver driver){
        this.driver = driver;
    }

    By usernameLocator = By.id("username");
    By passwordLocator = By.id("password");
    By loginBtn = By.cssSelector("button");
    By successLocator = By.id("flash");


    public void with(String username, String password){
        driver.findElement(usernameLocator).sendKeys(username);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(loginBtn).click();

    }

    public boolean successMessagePresent(){
        return driver.findElement(successLocator).isDisplayed();
    }

    public boolean onLoginPage(){
        return driver.findElement(usernameLocator).isDisplayed();
    }



}
