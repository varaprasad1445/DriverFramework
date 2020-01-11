package com.masteringselenium;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

@Listeners(ExtentITestListenerClassAdapter.class)
public class BasicTestWD extends DriverFactory{


    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private static final String IMG_NAME = "screenshot";

    // A static image stored under classpath
    private static final String IMG_PATH = "src/test/resources/" + IMG_NAME;

    // Using the same OUTPUT_PATH as set in extent.properties
    // [extent.reporter.html.out]
    private static final String OUTPUT_PATH = "ETestResults/HtmlReport/";

    private void googleExampleThatSearchfor(final String searchString) throws Exception {

    System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");

   /* ChromeOptions options = new ChromeOptions();
    options.addArguments("chrome.switches","--disable-extensions");*/
    DesiredCapabilities capabilities =   DesiredCapabilities.chrome();
    capabilities.setCapability("chrome.switches", Arrays.asList("--no-default-browser-check"));

    HashMap<String, String> chromePreferences = new HashMap<String, String>();
    chromePreferences.put(   "profile.password_manager_enabled", "false");

    capabilities.setCapability("chrome.prefs",   chromePreferences);

    WebDriver driver = DriverFactory.getDriver();
    driver.get("http://www.google.com");

    WebElement webElement = driver.findElement(By.name("q"));
    webElement.clear();

    webElement.sendKeys(searchString);
    System.out.println("Page title is: " + driver.getTitle());

    webElement.submit();
    System.out.println(driver.getTitle());
}
    @AfterMethod
    public synchronized void afterMethod(ITestResult result) throws Exception {
        switch (result.getStatus()) {
            case ITestResult.FAILURE:
                ExtentTestManager.getTest(result).fail("ITestResult.FAILURE, event afterMethod",
                        MediaEntityBuilder.createScreenCaptureFromPath(getImage()).build());
                break;
            case ITestResult.SKIP:
                ExtentTestManager.getTest(result).skip("ITestResult.SKIP, event afterMethod");
                break;
            default:
                break;
        }
    }

    /**
     * !!This code block is just an example only!!
     * !!Real-world implementation would require capturing a screenshot!!
     *
     * @return Image path
     * @throws IOException
     */
    private String getImage() throws Exception {
        TakesScreenshot ts = (TakesScreenshot) DriverFactory.getDriver();
        File src = ts.getScreenshotAs(OutputType.FILE);
        Files.copy(src.toPath(), new File(OUTPUT_PATH + IMG_NAME + getcurrentdateandtime()+".png").toPath());
        return IMG_NAME;
    }



    @Test
    public void googleCheeseExample() throws Exception {
        System.out.println(System.getProperty("user.dir"));

    googleExampleThatSearchfor("Cheese!");

    Assert.assertTrue(false);
    //ExtentTestManager.getTest().addScreenCaptureFromPath(System.getProperty("user.dir"));

    }
    public String getcurrentdateandtime(){
        String str = null;
        try{
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
            Date date = new Date();
            str= dateFormat.format(date);
            str = str.replace(" ", "").replaceAll("/", "").replaceAll(":", "");
        }
        catch(Exception e){

        }
        return str;
    }

    @BeforeTest
    public void googleMilkExample() throws Exception {
        googleExampleThatSearchfor("Milk!");



    }
    @Test
    public void googleCheeseExample1() throws Exception {       googleExampleThatSearchfor("Cheese!");
    }
    @Test
    public void googleMilkExample2() throws Exception {        googleExampleThatSearchfor("Milk!");
    }
    @Test
    public void googleCheeseExample3() throws Exception {       googleExampleThatSearchfor("Cheese!");
    }
    @Test
    public void googleMilkExample4() throws Exception {     googleExampleThatSearchfor("Milk!");
    }
    @Test
    public void googleCheeseExample5() throws Exception {     googleExampleThatSearchfor("Cheese!");
    }
    @Test
    public void googleMilkExample6() throws Exception {     googleExampleThatSearchfor("Milk!");
    }
    @Test
    public void googleCheeseExample7() throws Exception {      googleExampleThatSearchfor("Cheese!");
    }
    @Test
    public void googleMilkExample8() throws Exception {      googleExampleThatSearchfor("Milk!");
    }


}
