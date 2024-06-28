package custom_utilities.pages_Bank_Module;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Neosuite_Home_Page {

	public WebDriver driver;

	public Neosuite_Home_Page(WebDriver driver) {
		this.driver = driver;
	}

	public void Bank_Module_click(String widget_name) throws InterruptedException {
		
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement Bank_Module_click = driver.findElement(By.xpath("//div[@title='"+widget_name+"']"));
		wait1.until(ExpectedConditions.visibilityOf(Bank_Module_click));
		wait1.until(ExpectedConditions.elementToBeClickable(Bank_Module_click));
		Bank_Module_click.click();
		Loader_Wait();
		Thread.sleep(3000);
		
		WebElement heading_check = driver.findElement(By.xpath("//span[text()='Bank File Generation']"));
		wait1.until(ExpectedConditions.visibilityOf(heading_check));
		
		String a = "Bank File Generation";
		String b = heading_check.getText();		
		
		Assert.assertEquals(a , b ,"Test case failed - bank module page didn't opened properly" );

	}

	public void Loader_Wait() {

		/*
		 * This method is used to make wait until the loader image gets disappear
		 */
		
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		List <WebElement> Loader_Wait = driver.findElements(By.xpath("//div//img[contains(@src,'gif')]"));
		wait.until(ExpectedConditions.invisibilityOfAllElements(Loader_Wait));
	}
	
	public void loader_wait2() {

		/*
		 * This method is used to make wait until the loader image gets disappear
		 */
		
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		List<WebElement> heading_check = driver.findElements(By.xpath("//div"));
		wait.until(ExpectedConditions.invisibilityOfAllElements(heading_check));
	}
	
	public void Click_on_AppRole_Icon() {
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement sidebar = driver.findElement(By.xpath("//a[@data-target='setting_SideBar_out']"));
		wait1.until(ExpectedConditions.elementToBeClickable(sidebar));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",sidebar);

		
		
		By click_AppRole = By.xpath("//a[text()=' App Roles ']");
		wait1.until(ExpectedConditions.visibilityOf(driver.findElement(click_AppRole)));
		driver.findElement(click_AppRole).click();

		By ITD_Click = By.xpath("//span[text()='Bank Module']");
		driver.findElement(ITD_Click).click();

		By employee_Role_Click = By.xpath("//div[@class='collapsible-body']//ul[@id='appRole_Collapsible']//span[text()='Bank Module']//parent::div//parent::div//parent::li//span[@title='Admin']//parent::div//parent::div//label//parent::div//span");
		driver.findElement(employee_Role_Click).click();

		By click_Save_Approle = By.xpath("//div//a[text()='Save App Role']");
		JavascriptExecutor js  = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(click_Save_Approle));
		driver.findElement(click_Save_Approle).click();

		loader_wait2();
	}

}
