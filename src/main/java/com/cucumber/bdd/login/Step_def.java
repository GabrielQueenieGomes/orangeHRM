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
	}

	@When("enter valid username")
	public void enter_valid_username() {
		driver.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
	}

	@When("enter valid password")
	public void enter_valid_password() {
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("admin123");
	}

	@When("click login button")
	public void click_login_button() {
		driver.findElement(By.xpath("//*[class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();
	}

	@Then("login should pass and there should be logout button visible")
	public void login_should_pass_and_there_should_be_logout_button_visible() {
		Boolean status = driver.findElement(By.xpath("//*[@id='logoutButton']")).isDisplayed();
		System.out.println("Log out button there or not = " + status);

	driver.quit();
	}

	@When("enter invalid username")
	public void enter_invalid_username() {
		driver.findElement(By.xpath("//*[@name='username']")).sendKeys("sarower");
	}

	@When("enter invalid password")
	public void enter_invalid_password() {
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("sarower21312@");
	}

	@Then("login fails and no logout button")
	public void login_fails_and_no_logout_button() {
		try {
			Boolean status = driver.findElement(By.xpath("//*[@id='logoutButton']")).isDisplayed();
			System.out.println("Log out button there or not = " + status);
		} catch (Exception e) {
			
		}
	    driver.quit();
	}

}
