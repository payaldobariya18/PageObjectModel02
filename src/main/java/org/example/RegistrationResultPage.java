package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class RegistrationResultPage extends Utils{
    static String expectedRegistrationSuccessMessage= "Your registration completed";

    public void verifyUserRegistraionSuccessfully(){
        //verify user registered successfully
        String actualRegistrationSuccessMessage= getTextFromElement(By.xpath("//div[@class=\"result\"]"));
        Assert.assertEquals(actualRegistrationSuccessMessage, expectedRegistrationSuccessMessage,"Your registration is not completed");
 }
 }
