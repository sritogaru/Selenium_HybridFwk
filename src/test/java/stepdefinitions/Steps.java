package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testBase.BaseClass;

public class Steps extends BaseClass {
	
	@Given("I want to open Chrome browser")
	public void i_want_to_open_chrome_browser() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\salad\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	    throw new io.cucumber.java.PendingException();
	}

	@Given("open Orange HRM application with url as {string}")
	public void open_orange_hrm_application_with_url_as(String string) {
		driver.get("https://demowebshop.tricentis.com");
	    throw new io.cucumber.java.PendingException();
	}

	@When("enter username as {string}")
	public void enter_username_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("enter password as {string}")
	public void enter_password_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("click on Login button")
	public void click_on_login_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("we should able to see {string} text on left side")
	public void we_should_able_to_see_text_on_left_side(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("user should able to see {string} option on left side")
	public void user_should_able_to_see_option_on_left_side(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}


}
