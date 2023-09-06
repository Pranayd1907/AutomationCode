package com.support;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class supportStepDefination {
WebDriver driver;

@Given("URL has given")
public void url_has_given() {
	driver = new ChromeDriver();
	driver.get("https://reqres.in/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5000));
	
	JavascriptExecutor	js =((JavascriptExecutor)driver);
	js.executeScript("window.scrollBy(0,800)");

	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   
}
@When("I click on support Reques button")
public void i_click_on_support_reques_button() {
	
	
	WebElement element = driver.findElement(By.xpath("//a[normalize-space()='Support ReqRes']"));
	
	JavascriptExecutor	js1 =((JavascriptExecutor)driver);
	js1.executeScript("arguments[0].click();", element);
	
  
}
@Then("I should redirect on support")
public void i_should_redirect_on_support() {
    
}

	
}
