package TestSelf.Learning;

import java.io.File;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StepDefs {
	
	public WebDriver driver;
	
	@Before
	public void setUp() {
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+File.separator+"chromedriver_win32"+File.separator+"chromedriver.exe");
	DesiredCapabilities capability = DesiredCapabilities.chrome();
	capability.setJavascriptEnabled(true);
	driver = new ChromeDriver(capability);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Given("^I redirect to google home page$")
	public void i_redirect_to_google_home_page()
		throws Exception{
		driver.get("http://www.google.com");
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.titleIs("Google"));
		FluentWait<WebDriver> waitFluent = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		WebElement searchbox = waitFluent.until(new Function <WebDriver,WebElement>(){
			public WebElement apply(WebDriver driver) {
				WebElement ele = driver.findElement(By.name("q"));
				return ele;
			}
		});
		searchbox.sendKeys("Sapient");
	}
	
	@Then("^I validate Title$")
	public void i_validate_title()
		throws Exception{
		String actualTitle = driver.getTitle();
		Assert.assertEquals("Google", actualTitle);
	}
	
	@After
	public void closure() {
		driver.close();
	}
}
