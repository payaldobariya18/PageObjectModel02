package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class HomePage extends Utils{

    public void clickOnRegisterButton() {
        clickonelements(By.linkText("Register"));
    }

    public void clickOnLoginButton() {
        clickonelements(By.className("ico-login"));//click on login button
    }
    public void clickOnDetailsButton() {
        clickonelements(By.xpath("//div[@class=\"buttons\"]//a[@href=\"/nopcommerce-new-release\"]"));
    }


   }






