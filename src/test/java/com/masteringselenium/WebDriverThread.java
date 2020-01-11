package com.masteringselenium;

import com.masteringselenium.config.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;

import static com.masteringselenium.config.DriverType.CHROME;

public class WebDriverThread {
    private WebDriver webdriver;
    private DriverType selectedDriverType;
    private final DriverType defaultDriverType = CHROME;
 //   private final String browser =      System.getProperty("browser").toUpperCase();
    private final String operatingSystem =      System.getProperty("os.name").toUpperCase();
    private final String systemArchitecture =      System.getProperty("os.arch");

    public WebDriver getDriver() throws Exception
    {
        if (null == webdriver)
    {
        selectedDriverType = determineEffectiveDriverType();

    DesiredCapabilities desiredCapabilities = selectedDriverType.getDesiredCapabilities();
    instantiateWebDriver(desiredCapabilities);
    }
        return webdriver;
    }



    public void quitDriver()
    {
        if (null != webdriver)

        {
            webdriver.quit();
        }
    }

    private DriverType determineEffectiveDriverType()

    {
        DriverType driverType = defaultDriverType;

        try
            {
                //driverType = DriverType.valueOf(browser);
                driverType = defaultDriverType;
            }
        catch (IllegalArgumentException ignored)
              {
                 System.err.println("Unknown driver specified,   defaulting to '" + driverType + "'...");
              }
              catch (NullPointerException ignored)
              {
                    System.err.println("No driver specified, defaulting to '" + driverType + "'...");
              }
        return driverType;
    }

    private void instantiateWebDriver(DesiredCapabilities      desiredCapabilities) throws MalformedURLException
    {
        System.out.println(" ");
        System.out.println("Current Operating System: " +          operatingSystem);
        System.out.println("Current Architecture: " +          systemArchitecture);
        System.out.println("Current Browser Selection: " +          selectedDriverType);
        System.out.println(" ");
        webdriver = selectedDriverType.getWebDriverObject(desiredCapabilities);
    }
}






