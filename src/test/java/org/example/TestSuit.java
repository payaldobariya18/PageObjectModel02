package org.example;

import org.testng.annotations.Test;

public class TestSuit extends BaseTest{

   HomePage homePage = new HomePage();
   RegistrationPage registrationPage = new RegistrationPage();
   RegistrationResultPage registrationResultPage = new RegistrationResultPage();

   LoginPage loginPage = new LoginPage();
   DetailCommentPage detailCommentPage = new DetailCommentPage();


 @Test
 public void verifyUserShouldAbleToRegisterSuccessfully(){
     //click on registerbutton
     homePage.clickOnRegisterButton();
     //verify user is on register page
     registrationPage.verifyUserOnRegisterationPage();
     //enter registration details
     registrationPage.enterRegistrationDetails();
     //verify user registered successfully
     registrationResultPage.verifyUserRegistraionSuccessfully();

 }
 @Test
 public void verifyUserShouldAbleToLoginSuccessfully(){
     //click on login button
     homePage.clickOnLoginButton();
     //enter login details
     loginPage.verifyUserShouldBeAbleTOLogIn();

}
@Test
 public void verifyUserShouldAddCommentAtLastSuccessfully(){
     //click on  detail button
    homePage.clickOnDetailsButton();
    //enter title
    detailCommentPage.enterTitle();
    //enter comment
    detailCommentPage.enterComment();
    //click on NEW COMMENT button
    detailCommentPage.clickOnNEWCOMMENTButton();
    //  news comment is successfully added
    detailCommentPage.verifyUserAddCommentSuccessfully();
    // verify comment is added at last
    detailCommentPage.verifyCommentAddedAtLast();






 }











}
