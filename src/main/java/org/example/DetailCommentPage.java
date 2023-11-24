package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class DetailCommentPage extends Utils{
    private By _title = By.id("AddNewComment_CommentTitle");
    private By _comment = By.className("enter-comment-text");
    private By _NEWCOMMENT = By.xpath("//button[@name=\"add-comment\"]");
    private By _addCommentSuccessfully = By.xpath("//div[@class=\"result\"]");
    private By _commentAddedAtLast = By.xpath("//div[@class=\"comments\"]/div/div[2]/div[3]");
    String comment = "This is very useful website for shopping purpose" +timeStamp();

    String expectedCommentSuccessMessage = "News comment is successfully added.";
    //String commentList;
    public void enterTitle(){
        //enter title
        typetext((_title),"Discount");
    }
    public void enterComment(){
        //type comment
        typetext((_comment),comment);
    }

    public void clickOnNEWCOMMENTButton(){
        //click on NEW COMMENT button
        clickonelements(_NEWCOMMENT);
    }
    public void verifyUserAddCommentSuccessfully(){
        //verify user add comment successfully
        String actualCommentSuccessMessage = getTextFromElement(_addCommentSuccessfully);
        Assert.assertEquals(actualCommentSuccessMessage,expectedCommentSuccessMessage,"News comment is not added.");
    }
    public void verifyCommentAddedAtLast() {
        //verify comment added atlast
        List<WebElement> commentListEle = driver.findElements(_commentAddedAtLast);
        System.out.println(commentListEle.size());
        int comments =commentListEle.size();
        System.out.println(commentListEle.get(comments-1).getText());
        Assert.assertEquals(commentListEle.get(comments-1).getText(),comment,"comment is not added at last");

    }



















}
