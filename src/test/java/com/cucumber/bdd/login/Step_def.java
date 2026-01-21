package com.cucumber.bdd.login;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Step_def {
WebDriver driver;
WebDriverWait wait;

	
	@Given("open chrome")
	public void open_chrome() {
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@Given("go to app link")
	public void go_to_app_link() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));

	}

	@When("enter valid username")
	public void enter_valid_username() {
		wait.until(ExpectedConditions.elementToBeClickable(By.name("username")))
        .sendKeys("Admin");
	}

	@When("enter valid password")
	public void enter_valid_password() {
		wait.until(ExpectedConditions.elementToBeClickable(By.name("password")))
        .sendKeys("admin123");
	}

	@When("click login button")
	public void click_login_button() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@type='submit']")))
        .click();

	}

	@Then("login should pass and there should be logout button visible")
	public void login_should_pass_and_there_should_be_logout_button_visible() {
		// Wait for user dropdown to appear
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
        )).click();

        boolean isLogoutVisible = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[@class='oxd-userdropdown-link']")
                )
        ).isDisplayed();

        Assert.assertTrue(isLogoutVisible, "Logout button should be visible after successful login");
	}

	@When("enter invalid username")
	public void enter_invalid_username() {
		wait.until(ExpectedConditions.elementToBeClickable(By.name("username")))
        .sendKeys("sarower");
	}

	@When("enter invalid password")
	public void enter_invalid_password() {
		wait.until(ExpectedConditions.elementToBeClickable(By.name("password")))
        .sendKeys("sarower21312@");
	}

	@Then("login fails and no logout button")
	public void login_fails_and_no_logout_button() {
		// Wait for login attempt to complete
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));

        try {
            // If dropdown exists → test should fail
            driver.findElement(By.xpath(
                "//*[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']"
            ));

            Assert.fail("Logout dropdown should NOT be visible for failed login");

        } catch (Exception e) {
            // Expected behavior
            Assert.assertTrue(true, "Login failed as expected, logout button not found");
        }
		
	}

	@After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
