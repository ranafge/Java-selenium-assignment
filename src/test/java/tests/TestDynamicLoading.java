package tests;

import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobjects.DynamicLoading;

public class TestDynamicLoading {
    private WebDriver driver;
    private DynamicLoading dynamicLoading;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--warning-mode all");
        driver = new ChromeDriver(options);
        dynamicLoading = new DynamicLoading(driver);
    }

    @Test
    public void hiddenElementLoads() {
        dynamicLoading.loadExample("1");
        Assert.assertTrue("finish text didn't display after loading", dynamicLoading.finishTextPresent());
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
