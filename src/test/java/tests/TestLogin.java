//test/TestLogin

package tests;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.Login;

import javax.swing.table.TableRowSorter;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class TestLogin {
    private WebDriver driver;
    private Login login;

    @Before
    public void setUp() {
        System.setProperty("Webdriver.chrome.driver", "resources\\drivers\\chromedriver.exe");
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.addArguments();
        driver = new ChromeDriver(browserOptions);
        login = new Login(driver);
    }


    @Test
    public void rightClickButton() {
        login.visit("https://demoqa.com/buttons");
        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
        Actions action = new Actions(driver);
        action.contextClick(rightClickBtn).perform();
        String rightClickBtnMessage = driver.findElement(By.id("rightClickMessage")).getText();
        System.out.println("\n right click message " + rightClickBtnMessage);
        Assert.assertTrue(rightClickBtnMessage.contains("You have done a right click"));


    }

    @Test
    public void acceptCookies() throws InterruptedException {
        login.visit("https://cleanerdhaka.ideascale.com/a/community/login");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        WebElement cookiesBtn = driver.findElement(By.cssSelector("button.btn.btn-primary.flex-fill.json-link"));
        cookiesBtn.click();

    }

    @Test
    public void handleAlert() throws InterruptedException {
        login.visit("https://demoqa.com/alerts");
        driver.manage().window().maximize();
        driver.findElement(By.id("confirmButton")).click();
        Thread.sleep(5000);
        String alertWindowMessage = driver.switchTo().alert().getText();
        System.out.println("Alert window message is: " + alertWindowMessage);
        driver.switchTo().alert().accept();
        Thread.sleep(5000);
        String alertMessage = driver.findElement(By.id("confirmResult")).getText();
        System.out.println("Alter message is:  "+ alertMessage);

    }

    @Test
    public void selectDropdown() throws InterruptedException {
        login.visit("https://demoqa.com/select-menu");
        login.maximizeWindow();
        Select color = new Select(driver.findElement(By.id("oldSelectMenu")));
        color.selectByIndex(0);
        Thread.sleep(3000);
        color.selectByValue("8");
        Thread.sleep(3000);
        if(color.isMultiple()){
            color.selectByValue("2");
        } else {
            color.selectByIndex(0);
        }
        Thread.sleep(3000);
    }


    @Test
    public void SelectMultipoleElementDropDownMenu() throws InterruptedException {
        login.visit("https://demoqa.com/select-menu");
        login.maximizeWindow();
        login.waitForLoad(1000);
        WebElement selectEle = driver.findElement(By.id("cars"));
        Select select = new Select(selectEle);
        select.selectByValue("saab");
        select.selectByValue("audi");

        Thread.sleep(1000);


    }

    @Test
    public void selecMultiItem() throws InterruptedException {
        login.visit("https://demoqa.com/select-menu");
        login.maximizeWindow();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scroll(0, 450)");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='row']/*/div[@class=' css-2b097c-container']")).click();
        driver.findElement(By.id("react-select-4-option-0")).click();
        driver.findElement(By.id("react-select-4-option-1")).click();
        driver.findElement(By.id("react-select-4-option-2")).click();
        driver.findElement(By.id("react-select-4-option-3")).click();
        Thread.sleep(3000);



    }

    @Test
    public void takeScreenshot() throws IOException {
        driver.get("https://demoqa.com");
        // File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File screenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        //capturing date
        String time = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss-aa").format(new Date());

        String fileWithPath = "./src/test/resources/screenshots/" + time + ".png";
        File DestFile = new File(fileWithPath);
        FileUtils.copyFile(screenshotFile, DestFile);



    }



    @After
    public void tearDown() {
        driver.quit();
    }


}
