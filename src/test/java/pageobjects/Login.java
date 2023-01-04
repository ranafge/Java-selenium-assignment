// pageobjects/Login.java

package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends Base {
    private WebDriver driver;

    By usernameLocator = By.id("username");
    By passwordLocator = By.id("password");
    By submitButton = By.cssSelector("button.radius");
    By successMessageLocator = By.id("flash");
    By failureMessageLocator = By.cssSelector(".flash.error");


    public Login(WebDriver driver) {
        super(driver);
//        visit("http://the-internet.herokuapp.com/login");

    }

    public void With(String username, String password) {
        type(username, usernameLocator);
        type(password, passwordLocator);
        click(submitButton);


    }

    public Boolean successMessagePresent() {
        return driver.findElement(successMessageLocator).isDisplayed();
    }

    public Boolean failureMessagePresent() {
        return driver.findElement(failureMessageLocator).isDisplayed();
    }

}
