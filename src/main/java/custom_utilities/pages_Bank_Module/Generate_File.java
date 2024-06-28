package custom_utilities.pages_Bank_Module;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Generate_File {

	public WebDriver driver;

	public Generate_File(WebDriver driver) {
		this.driver = driver;
	}

	public void Generate_Bank_File_Checkbox_click() throws InterruptedException {
		
		/*
		 * This method is used to click Generate Bank File Check box
		 */

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		Thread.sleep(1000);
		
		 WebElement Generate_Bank_File_Checkbox_click =driver.findElement(By.xpath("(//div[@id='bank_generateFileModal']//span[@class='checkbox-input-labels'])[1]"));
		 wait1.until(ExpectedConditions.visibilityOf(Generate_Bank_File_Checkbox_click));
		 wait1.until(ExpectedConditions.elementToBeClickable(Generate_Bank_File_Checkbox_click));
		 Generate_Bank_File_Checkbox_click.click();

	}
	
	public void Check_Box_Selected_Generate_Bank_File_Check() {
		
		/*
		 * This method is used to check Generate Bank File Check box is selected
		 */
		
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		WebElement Generate_Bank_File_Checkbox_click =driver.findElement(By.xpath("(//div[@id='bank_generateFileModal']//span[@class='checkbox-input-labels'])[1]"));
		wait1.until(ExpectedConditions.visibilityOf(Generate_Bank_File_Checkbox_click));
		wait1.until(ExpectedConditions.elementToBeClickable(Generate_Bank_File_Checkbox_click));
		boolean cond = Generate_Bank_File_Checkbox_click.findElement(By.xpath("preceding-sibling::input")).isSelected();
		
		System.out.println("Assert value suppose to be true     -     "+cond);
		
		Assert.assertTrue(cond,"Test failed  - check box is not selected");
		 
	}
	
	public void Generate_Button_Click() {
		
		/*
		 * This method is used to click the generate button
		 */
		
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		WebElement Generate_Button_Click =driver.findElement(By.xpath("//button[@title='Generate']"));
		wait1.until(ExpectedConditions.visibilityOf(Generate_Button_Click));
		wait1.until(ExpectedConditions.elementToBeClickable(Generate_Button_Click));
		
		Assert.assertTrue(Generate_Button_Click.isDisplayed(), " Test case failed the generate button is not visible to click ");
		
		Generate_Button_Click.click();
		
	}
	
public void Generate_Bank_Summary_Checkbox_click() throws InterruptedException {
		
		/*
		 * This method is used to click Generate Bank Summary Check box
		 */
	
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		 WebElement Generate_Bank_Summary_Checkbox_click =driver.findElement(By.xpath("(//div[@id='bank_generateFileModal']//span[@class='checkbox-input-labels'])[2]"));
		 wait1.until(ExpectedConditions.visibilityOf(Generate_Bank_Summary_Checkbox_click));
		 wait1.until(ExpectedConditions.elementToBeClickable(Generate_Bank_Summary_Checkbox_click));
		 Generate_Bank_Summary_Checkbox_click.click();

	}

public void Check_Box_Selected_Generate_Bank_Summary_Check() {
	
	/*
	 * This method is used to check Generate Bank Summary Check box is selected
	 */
	
	// Implicit wait
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	
	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
	
	WebElement Generate_Bank_File_Checkbox_click =driver.findElement(By.xpath("(//div[@id='bank_generateFileModal']//span[@class='checkbox-input-labels'])[2]"));
	wait1.until(ExpectedConditions.visibilityOf(Generate_Bank_File_Checkbox_click));
	wait1.until(ExpectedConditions.elementToBeClickable(Generate_Bank_File_Checkbox_click));
	boolean cond = Generate_Bank_File_Checkbox_click.findElement(By.xpath("preceding-sibling::input")).isSelected();
	
	System.out.println("Assert value suppose to be true     -     "+cond);
	
	Assert.assertTrue(cond,"Test failed  - check box is not selected");
	 
}

public void Generate_Bank_Advice_Checkbox_click() throws InterruptedException {
	
	/*
	 * This method is used to click Generate Bank Summary Check box
	 */
	
	// Implicit wait
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
	
	 WebElement Generate_Bank_Advice_Checkbox_click =driver.findElement(By.xpath("(//div[@id='bank_generateFileModal']//span[@class='checkbox-input-labels'])[3]"));
	 wait1.until(ExpectedConditions.visibilityOf(Generate_Bank_Advice_Checkbox_click));
	 wait1.until(ExpectedConditions.elementToBeClickable(Generate_Bank_Advice_Checkbox_click));
	 Generate_Bank_Advice_Checkbox_click.click();

}

public void Check_Box_Selected_Generate_Bank_Advice_Check() {
	
	/*
	 * This method is used to check Generate Bank Advice Check box is selected
	 */
	
	// Implicit wait
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	
	
	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
	
	WebElement Generate_Bank_File_Checkbox_click =driver.findElement(By.xpath("(//div[@id='bank_generateFileModal']//span[@class='checkbox-input-labels'])[3]"));
	wait1.until(ExpectedConditions.visibilityOf(Generate_Bank_File_Checkbox_click));
	wait1.until(ExpectedConditions.elementToBeClickable(Generate_Bank_File_Checkbox_click));
	boolean cond = Generate_Bank_File_Checkbox_click.findElement(By.xpath("preceding-sibling::input")).isSelected();
	
	System.out.println("Assert value suppose to be true     -     "+cond);
	
	Assert.assertTrue(cond,"Test failed  - check box is not selected");
	 
}
	
	
	

}
