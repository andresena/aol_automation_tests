package com.aol.AolTestCases;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AOLTestCases {
  public WebDriver driver;
	
  @BeforeSuite
  public void testBeforeSuite() {
    System.out.println("Creating Firefox driver for AOL Test Cases.");
    driver = new FirefoxDriver();	  
  }
	
  @BeforeMethod
  public void BeforeTest() {
    System.out.println("Loading AOL URL for AOL Test Cases.");
    driver.get("http://www.aol.com/");
  }	
	
  @Test
  public void testcase1() {
    //Verifying condition #2	
    if(driver.findElements(By.id("ghnav-news")).size() != 0){
      System.out.println("News link is present.");
    } else {
      System.out.println("News link is not present.");
    }
	  
    if(driver.findElements(By.id("ghnav-sports")).size() != 0){
      System.out.println("Sports link is present.");
    } else {
	  System.out.println("Sports link is not present.");
    }
	  
    if(driver.findElements(By.id("ghnav-entertainment")).size() != 0){
      System.out.println("Entertainment is Present");
    } else {
	  System.out.println("Entertainment is Absent");
    }	  
	  
    //Verifying condition #3
    driver.findElement(By.id("aol-header-query")).sendKeys("AOL autos");
    driver.findElement(By.id("aol-header-search-button")).click();	 
	  
    //Verifying condition #4
    if(driver.findElements(By.id("Web")).size() != 0){
	  System.out.println("Web link text is present.");
    } else {
	  System.out.println("Web link text is not present.");
    }	
	  
    if(driver.findElements(By.id("Mail")).size() != 0){
      System.out.println("Mail link text is present.");
    } else {
	  System.out.println("Mail link text is not present.");
    }		  	 
	  
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); //Adding sleep time for waiting page elements.	  
	driver.findElement(By.linkText("Autoblog - We Obsessively Cover the Auto Industry")).click();	  
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  
	//Verifying condition #5
	if(driver.findElement(By.xpath("//a[@href ='http://www.autoblog.com/']")).isDisplayed()){
	  System.out.println("Autoblog image is loaded.");   
	} else {
	  System.out.println("Autoblog image is not loaded.");	   
	}        
  }	

  @Test
  public void testcase2() {	
	driver.findElement(By.id("weatheredit")).click();		
	  
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);	  
	driver.findElement(By.cssSelector("input[id='wz']")).clear();
	  
	//Verifying condition #2
	driver.findElement(By.cssSelector("input[id='wz']")).sendKeys("New York");	  
	  
	driver.findElement(By.id("weathersubmit")).click();	
	  
	driver.findElement(By.id("weatheredit")).click(); 
	  
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  
	//Verifying condition #3
	Assert.assertTrue(driver.findElement(By.id("weatheredit")).getText().matches(".*NY"));
	System.out.println("New York location weather was updated.");
	    
	driver.findElement(By.id("weathersubmit")).click();
	  
	driver.findElement(By.id("ghnav-weather")).click();
	
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  
	//Verifying condition #4
	if(driver.findElement(By.xpath("//span[@data-fullname = 'New York']")).getSize().equals(0)){
	   System.out.println("Page does not show the weather for New York.");
	} else {
	  System.out.println("Page shows the weather for New York.");
	}
  }
	
  @AfterSuite
  public void testAfterSuite() {
	System.out.println("Quiting driver when finishing the battery of testing.");
	driver.quit();
  }	
}