package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegistrationPage extends Utils {
    private By _registerLink = By.linkText("Register");
    private By _firstName = By.id("FirstName");
    private By _lastName = By.id("LastName");
    private By _date = By.name("DateOfBirthDay");
    private By _month = By.name("DateOfBirthMonth");
    private By _year = By.name("DateOfBirthYear");
    private By _email = By.id("Email");
    private By _componyName = By.id("Company");
    private By _password = By.id("Password");
    private By _confirmPassword = By.id("ConfirmPassword");
    private By _registerResult = By.id("register-button");

    LoadProp loadProp = new LoadProp();

    public void verifyUserOnRegisterationPage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("register"), "USer on not on register page");

    }

    public void enterRegistrationDetails() {
        //explicit wait untill the element to be clickable
        waitForClickable((_registerLink), 10);
        //enter firstname
        typetext((_firstName), loadProp.getProperty("firstName"));
        //enter lastname
        typetext((_lastName), loadProp.getProperty("lastName"));
        //enter date
        selectByValue((_date), loadProp.getProperty("date"));
        //enter month
        selectByText((_month), loadProp.getProperty("month"));
        //enter year
        selectByText((_year), loadProp.getProperty("year"));
        //enter email
        typetext((_email), email);
        //enter company name
        typetext((_componyName), loadProp.getProperty("nameOfCompany"));
        //enter password
        typetext((_password), password);
        //enter confirm password
        typetext((_confirmPassword), password);
        //click on register button
        clickonelements(_registerResult);


    }
}