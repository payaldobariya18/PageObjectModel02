package org.example;

import org.openqa.selenium.By;

public class LoginPage extends Utils {

    public void verifyUserShouldBeAbleTOLogIn() {
        //enter email adress
        typetext(By.xpath("//input[@id=\"Email\"]"), email);
        //enter password
        typetext(By.className("password"), password);//enter password
        //click on login button
        clickonelements(By.xpath("//button[contains(@class, 'login-button')]")); //click on login button for login successfully and on screen it shows logout
    }




}