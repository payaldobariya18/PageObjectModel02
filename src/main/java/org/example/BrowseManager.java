package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BrowseManager extends Utils {

    String browserName = "Edge";
    public void openBrowser() {


        switch (browserName) {
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
                driver = new ChromeDriver();
                break;

            case "Firefox":
                System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
                driver = new FirefoxDriver();
                break;

            case "Edge":
                System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/msedgedriver.exe");
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Your browsername is not match:" + browserName);
        }
                // implicitly wait for each command
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                // maximize full web screen
                driver.manage().window().maximize();
                //open url
                driver.get("https://demo.nopcommerce.com");
        }

    public void closeBrowser()
    {
        driver.quit();
    }
 }