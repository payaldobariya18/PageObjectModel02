package org.example;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends BrowseManager{

  @BeforeMethod
  public void setUp()
  {
    openBrowser();
  }
 // @AfterMethod
  public void tearDown(ITestResult result){

      if(!result.isSuccess())
      {
        captureScreenshot(result.getName());
      }

      closeBrowser();
  }












}
