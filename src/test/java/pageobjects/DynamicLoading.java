package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import javax.swing.*;

public class DynamicLoading extends Base {

    public DynamicLoading(WebDriver driver) {
        super(driver);
    }

    By startButton = By.cssSelector("#start button");
    By finishText = By.id("finish");

    public void loadExample(String exampleNumber) {
        visit("http://the-internet.herokuapp.com/dynamic_loading/" + exampleNumber);
        click(startButton);
    }

    public Boolean finishTextPresent() {
        return isDisplayed(finishText, 10);
    }
}
