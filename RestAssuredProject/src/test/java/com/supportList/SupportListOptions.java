package com.supportList;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class SupportListOptions {

	WebDriver driver;

	@Given("URL has given")
	public void url_has_given() {
		driver = new ChromeDriver();
		driver.navigate().to("https://reqres.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5000));

		JavascriptExecutor js = ((JavascriptExecutor) driver);
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

		JavascriptExecutor js1 = ((JavascriptExecutor) driver);
		js1.executeScript("arguments[0].click();", element);

	}

	@Then("I should redirect on support")
	public void i_should_redirect_on_support() {
		System.out.println("I am successfully landed on Support Reqres one page application");
	}

	@When("I choose any one value from Support")
	public void i_choose_any_one_value_from_support() {
		List<WebElement> allbuttonsList = driver.findElements(By.xpath("//input[@type='radio']/.."));
		System.out.println("Total Count of radio button is: "+allbuttonsList.size());
		Assertions.assertEquals(allbuttonsList.get(0).getText().trim(), "One-time payment ($)");
		Assertions.assertEquals(allbuttonsList.get(1).getText()
				.trim(), "Monthly support ($5/month)");
		for(int i=0;i<allbuttonsList.size();i++){
		   System.out.println( allbuttonsList.get(i).getText());
		    } 
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@When("click on support Reqres")
	public void click_on_support_reqres() {

		WebElement supportButton = driver.findElement(By.xpath("//button[contains(text(),'Support ReqRes')]"));
		supportButton.click();

	}

	@Then("Page should redirect on stripe checkout")
	public void page_should_redirect_on_stripe_checkout() {
		System.out.println("User successfully landed on Stripe Checkout page");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("Page should redirect on stripe checkout And user click on browser back button")
	public void page_should_redirect_on_stripe_checkout_and_user_click_on_browser_back_button() {
		System.out.println("User is again landing backon reqres website page");

		driver.navigate().to("https://reqres.in/");

		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5000));

		JavascriptExecutor js2 = ((JavascriptExecutor) driver);
		js2.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@When("user scroll page and click on upgrade button")
	public void user_scroll_page_and_click_on_upgrade_button() {
		WebElement upGradeButton = driver.findElement(By.xpath("//button[@id='trigger-pro']"));
		upGradeButton.click();
	}

	@Then("facility to provide option for subscribe")
	public void facility_to_provide_option_for_subscribe() {
		WebElement emailElement = driver.findElement(By.xpath("//input[@type='email']"));
		emailElement.sendKeys("test@gmail.com");

		WebElement subscribe = driver.findElement(By.xpath("//input[@value='Subscribe']"));
		subscribe.click();
	}

}
