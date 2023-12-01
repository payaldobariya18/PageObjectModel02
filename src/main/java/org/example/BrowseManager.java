package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BrowseManager extends Utils {
    URL url = null;
    LoadProp loadProp = new LoadProp();
   // String browserName = loadProp.getProperty("browser");

    String browserName = System.getProperty("browser");

   // boolean sauce = false;
    boolean sauce = Boolean.parseBoolean(System.getProperty("sauce"));

    public void openBrowser() {

        if (sauce)
        {
            System.out.println("running in sauce lab........");
            if (browserName.equalsIgnoreCase("chrome")) {
                ChromeOptions browserOptions = new ChromeOptions();
                browserOptions.setPlatformName("Windows 10");
                browserOptions.setBrowserVersion("latest");
                Map<String, Object> sauceOptions = new HashMap<>();
                sauceOptions.put("username", loadProp.getProperty("sauceUserName"));
                sauceOptions.put("accessKey", loadProp.getProperty("saucePassword"));
                sauceOptions.put("build", "<your build id>");
                sauceOptions.put("name", "<your test name>");
                browserOptions.setCapability("sauce:options", sauceOptions);


                try {
                    url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                driver = new RemoteWebDriver(url, browserOptions);

            } else if (browserName.equalsIgnoreCase("firefox")) {
                FirefoxOptions browserOptions = new FirefoxOptions();
                browserOptions.setPlatformName("Windows 10");
                browserOptions.setBrowserVersion("latest");
                Map<String, Object> sauceOptions = new HashMap<>();
                sauceOptions.put("username", loadProp.getProperty("sauceUserName"));
                sauceOptions.put("accessKey", loadProp.getProperty("saucePassword"));
                sauceOptions.put("build", "<your build id>");
                sauceOptions.put("name", "<your test name>");
                browserOptions.setCapability("sauce:options", sauceOptions);


                try {
                    url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                driver = new RemoteWebDriver(url, browserOptions);

            } else if (browserName.equalsIgnoreCase("edge"))
            {
                EdgeOptions browserOptions = new EdgeOptions();
                browserOptions.setPlatformName("Windows 10");
                browserOptions.setBrowserVersion("latest");
                Map<String, Object> sauceOptions = new HashMap<>();
                sauceOptions.put("username",loadProp.getProperty("sauceUserName"));
                sauceOptions.put("accessKey", loadProp.getProperty("saucePassword"));
                sauceOptions.put("build", "<your build id>");
                sauceOptions.put("name", "<your test name>");
                browserOptions.setCapability("sauce:options", sauceOptions);


                try {
                    url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                RemoteWebDriver driver = new RemoteWebDriver(url, browserOptions);

            } else
            {
                System.out.println("Your browsername is not match :" + browserName);
            }

        } else {
            System.out.println("running in local.........");
            if (browserName.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
                // setting for chrome browser run
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("Firefox")) {
                System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
                // setting for chrome browser run
                driver = new FirefoxDriver();
            } else if (browserName.equalsIgnoreCase("Edge")) {
                System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/msedgedriver.exe");
                // setting for chrome browser run
                driver = new EdgeDriver();
            } else {
                System.out.println("Your browser name is not match:" + browserName);

            }
        }
                 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                // maximize full web screen
                driver.manage().window().maximize();
                //open url
                driver.get("https://demo.nopcommerce.com");
   }

   public void closeBrowser() {
        driver.quit();
    }
}

