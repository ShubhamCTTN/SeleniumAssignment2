/*Q1- Launch Firefox browser & navigate to https://rahulshettyacademy.com/AutomationPractice/
a- Try to Fetch the alert popup text.
b- Try to Dismiss the popup.
c- Try to enter some data on an alert popup.
d- Try to accept the popup.*/

package seleniumSession2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Q1 {
	public WebDriver driver;

	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.gecko.driver",
				"D:\\SeleniumClassroom\\learnselenium\\src\\main\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	}

	@Test(priority = 1)
	public void fetchingAlertPopUpTextAndDismissTset() {
		driver.findElement(By.id("confirmbtn")).click();
		Alert obj = driver.switchTo().alert();
		System.out.println(obj.getText());
		obj.dismiss();
	}

	@Test(priority=2)
	public void enterDataInAlertPopUpTset() {
		driver.findElement(By.id("name")).sendKeys("Shubham");
		driver.findElement(By.id("alertbtn")).click();
		Alert obj2 = driver.switchTo().alert();
		System.out.println(obj2.getText());
		obj2.accept();
	}

	@AfterClass
	public void ClosingBrowser() {
		driver.close();
	}

}
