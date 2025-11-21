package com.cucumber.bdd.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Step_def {
WebDriver driver;
	
	@Given("open chrome")
	public void open_chrome() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Given("go to app link")
	public void go_to_app_link() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		try {
	        Thread.sleep(3000); // Pause for 3 seconds
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }

	}

	@When("enter valid username")
	public void enter_valid_username() {
		driver.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
		try {
	        Thread.sleep(2000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}

	@When("enter valid password")
	public void enter_valid_password() {
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("admin123");
		try {
	        Thread.sleep(2000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}

	@When("click login button")
	public void click_login_button() {
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		try {
	        Thread.sleep(3000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }

	}

	@Then("login should pass and there should be logout button visible")
	public void login_should_pass_and_there_should_be_logout_button_visible() {
		driver.findElement(By.xpath("//*[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
Boolean status =	driver.findElement(By.xpath("//*[@class='oxd-userdropdown-link']")).isDisplayed();
		
		System.out.println("Login passed logout button is visible = " + status);
		
		driver.quit();
	}

	@When("enter invalid username")
	public void enter_invalid_username() {
		driver.findElement(By.xpath("//*[@name='username']")).sendKeys("sarower");
		try {
	        Thread.sleep(2000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}

	@When("enter invalid password")
	public void enter_invalid_password() {
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("sarower21312@");
		try {
	        Thread.sleep(2000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}

	@Then("login fails and no logout button")
	public void login_fails_and_no_logout_button() {
		Boolean status;
		try {
			driver.findElement(By.xpath("//*[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
			status = driver.findElement(By.xpath("//*[@class='oxd-userdropdown-link']")).isDisplayed();
			System.out.println("Logout botton not = " + status);
		
		} catch (Exception e) {
		
		}
		driver.quit();

	}

}
