package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;

public class Utils extends BasePage{

   //static String email = "nickjonas20231124114717@gmail.com";
   static String email = "nickjonas" + timeStamp() + "@gmail.com";
    static String password = "Test1234";

    public static void clickonelements(By by) {
        driver.findElement(by).click();
    }

    public static void typetext(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public static String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }
    public static void selectByText(By by,String Text){
        Select selectMonth = new Select(driver.findElement(by));
        selectMonth.selectByVisibleText(Text);
    }
    public static void selectByIndex(By by,int index){

        Select selectDay = new Select(driver.findElement(by));
        selectDay.selectByIndex(index);
    }
    public static void selectByValue(By by,String value){

        Select selectDay = new Select(driver.findElement(by));
        selectDay.selectByValue(value);
    }



    public static void waitForClickable(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void waitForElementToBeVisible(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitForElementToBeInvisible(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public static void waitForElementtobeDisappear(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(by)));
    }

    public static void waitUrlToBe(int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.urlToBe(driver.getCurrentUrl()));
    }

    public static String timeStamp() {
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
        return timeStamp;
    }

    public static void captureScreenshot(String screenShotName) {
        //convert web driver object to screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        //call getScreenshotAs method to create image file
        File source = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(source, new File("ScreenshotsTS\\" + screenShotName + timeStamp() + ".png"));
            System.out.println("Screenshot taken");
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot" + e.getMessage());
        }
    }




















}
