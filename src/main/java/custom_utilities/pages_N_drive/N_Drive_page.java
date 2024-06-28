package custom_utilities.pages_N_drive;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class N_Drive_page {

	public WebDriver driver;

	public N_Drive_page(WebDriver driver) {

		this.driver = driver;

	}

	public void Loader_Wait() throws InterruptedException {

		/*
		 * This method is used to make wait until the loader image gets disappear
		 */

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		try {
		
			List<WebElement> heading_check = driver.findElements(By.xpath("//div//img[contains(@src,'gif')]"));
			wait.until(ExpectedConditions.invisibilityOfAllElements(heading_check));
		} catch (Exception e) {
			try {
				List<WebElement> heading_check = driver.findElements(By.xpath("//div//img[contains(@src,'gif')]"));
				wait.until(ExpectedConditions.invisibilityOfAllElements(heading_check));
			} catch (Exception e1) {
				// TODO: handle exception
			}
			
		}

	}

	public void Form_Selection(String Form_Name) {

		/*
		 * This method is used to select the Form Selection
		 */
		
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement Form_Selection = driver.findElement(By.xpath("//div[@id='slide-out']//div[@title='" + Form_Name + "']"));
		wait1.until(ExpectedConditions.visibilityOf(Form_Selection));
		wait1.until(ExpectedConditions.elementToBeClickable(Form_Selection));
		Form_Selection.click();

	}

	public void Form_Selection_Check(String Form_Name) {

		/*
		 * This method is used to select the Form Selection check
		 */
		
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement Form_Selection_Check = driver.findElement(By.xpath("//div[@class='card-title']//div[@title='" + Form_Name + "']"));
		wait1.until(ExpectedConditions.visibilityOf(Form_Selection_Check));
		String form_name = Form_Selection_Check.getText();

		Assert.assertEquals(form_name, Form_Name, "Test failed - form name is mismatched");

	}

	public void Apply_Filter_Clicking_Plus_Button() {

		/*
		 * This method is used to select the Apply Filter Clicking Plus Button
		 */
		
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement Apply_Filter_Clicking_Plus_Button = driver.findElement(By.xpath("//i[@class='material-icons prefix']"));
		wait1.until(ExpectedConditions.visibilityOf(Apply_Filter_Clicking_Plus_Button));
		wait1.until(ExpectedConditions.elementToBeClickable(Apply_Filter_Clicking_Plus_Button));
		Apply_Filter_Clicking_Plus_Button.click();

	}

	public void Clicking_Client_Drop_Down(String client) throws InterruptedException {

		/*
		 * This method is used to select the Clicking Client Drop Down
		 */
		
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));

		try {
			WebElement Clicking_Client_Drop_Down = driver.findElement(By.xpath("//ng-select[@placeholder='Choose client']"));
			wait1.until(ExpectedConditions.visibilityOf(Clicking_Client_Drop_Down));
			wait1.until(ExpectedConditions.elementToBeClickable(Clicking_Client_Drop_Down));
			Clicking_Client_Drop_Down.click();
			Thread.sleep(1000);

			WebElement Clicking_Client_Drop_Down_To_Select_Value = driver.findElement(By.xpath("//ng-select[@placeholder='Choose client']//span[normalize-space()='" + client + "' and @class='ng-option-label' ]"));
			wait1.until(ExpectedConditions.visibilityOf(Clicking_Client_Drop_Down_To_Select_Value));
			wait1.until(ExpectedConditions.elementToBeClickable(Clicking_Client_Drop_Down_To_Select_Value));
			Clicking_Client_Drop_Down_To_Select_Value.click();

			Loader_Wait();
			String value = "";

			try {
				value = Clicking_Client_Drop_Down_To_Select_Value.getText();
			} catch (StaleElementReferenceException e) {
				wait1.until(ExpectedConditions
						.refreshed(ExpectedConditions.stalenessOf(Clicking_Client_Drop_Down_To_Select_Value)));
				value = driver
						.findElement(By.xpath("//ng-select[@placeholder='Choose client']//div[@class='ng-value']"))
						.getText();
			}
			System.out.println("Client name  is     -  " + value);
			Assert.assertEquals(value, client , "Test failed - client name is not selected properly");

		} catch (Exception e) {

			try {
				WebElement Clicking_Client_Drop_Down = driver
						.findElement(By.xpath("//ng-select[@placeholder='Choose client']"));
				wait1.until(ExpectedConditions.visibilityOf(Clicking_Client_Drop_Down));
				Clicking_Client_Drop_Down.click();
			} catch (Exception e1) {
				Thread.sleep(2000);
				WebElement Clicking_Client_Drop_Down = driver
						.findElement(By.xpath("//ng-select[@placeholder='Choose client']"));
				wait1.until(ExpectedConditions.visibilityOf(Clicking_Client_Drop_Down));
				Clicking_Client_Drop_Down.click();

			}
			try {
				Thread.sleep(1000);
				driver.switchTo().defaultContent();
				WebElement Clicking_Client_Drop_Down_To_Select_Value = driver.findElement(By.xpath("//ng-select[@placeholder='Choose client']//span[normalize-space()='" + client + "' and @class='ng-option-label' ]"));
				wait1.until(ExpectedConditions.visibilityOf(Clicking_Client_Drop_Down_To_Select_Value));
				Clicking_Client_Drop_Down_To_Select_Value.click();
				Loader_Wait();
			} catch (Exception e2) {
				Thread.sleep(2000);
				driver.switchTo().defaultContent();
				WebElement Clicking_Client_Drop_Down_To_Select_Value = driver.findElement(By.xpath("//ng-select[@placeholder='Choose client']//span[normalize-space()='" + client + "' and @class='ng-option-label' ]"));
				wait1.until(ExpectedConditions.visibilityOf(Clicking_Client_Drop_Down_To_Select_Value));
				
				Clicking_Client_Drop_Down_To_Select_Value.click();
				Loader_Wait();

			}

		}
	}

	public void Clicking_Country_Drop_Down(String country) throws InterruptedException {

		/*
		 * This method is used to select the Clicking Country Drop Down
		 */
		
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));

		try {
			WebElement Clicking_Country_Drop_Down = driver
					.findElement(By.xpath("//ng-select[@placeholder='Choose Country']"));
			wait1.until(ExpectedConditions.visibilityOf(Clicking_Country_Drop_Down));
			wait1.until(ExpectedConditions.elementToBeClickable(Clicking_Country_Drop_Down));
			Clicking_Country_Drop_Down.click();

			Thread.sleep(1000);

			WebElement Clicking_Country_Drop_Down_To_Select_Value = driver.findElement(By.xpath("//ng-select[@placeholder='Choose Country']//span[normalize-space()='" + country + "' and @class='ng-option-label']"));
			wait1.until(ExpectedConditions.visibilityOf(Clicking_Country_Drop_Down_To_Select_Value));
			wait1.until(ExpectedConditions.elementToBeClickable(Clicking_Country_Drop_Down_To_Select_Value));
			Clicking_Country_Drop_Down_To_Select_Value.click();

			Loader_Wait();

			String value = "";

			try {
				value = Clicking_Country_Drop_Down_To_Select_Value.getText();
			} catch (StaleElementReferenceException e) {
				wait1.until(ExpectedConditions
						.refreshed(ExpectedConditions.stalenessOf(Clicking_Country_Drop_Down_To_Select_Value)));
				value = driver
						.findElement(By.xpath("//ng-select[@placeholder='Choose Country']//div[@class='ng-value']"))
						.getText();
			}
			System.out.println("Country name  is     " + value);
			Assert.assertEquals(value, country, "Test failed - country name not selected properly");

		} catch (Exception e) {

			try {
				WebElement Clicking_Country_Drop_Down = driver
						.findElement(By.xpath("//ng-select[@placeholder='Choose Country']"));
				wait1.until(ExpectedConditions.visibilityOf(Clicking_Country_Drop_Down));
				wait1.until(ExpectedConditions.elementToBeClickable(Clicking_Country_Drop_Down));
				Clicking_Country_Drop_Down.click();
			} catch (Exception e1) {
				Thread.sleep(2000);
				WebElement Clicking_Country_Drop_Down = driver
						.findElement(By.xpath("//ng-select[@placeholder='Choose Country']"));
				wait1.until(ExpectedConditions.visibilityOf(Clicking_Country_Drop_Down));
				wait1.until(ExpectedConditions.elementToBeClickable(Clicking_Country_Drop_Down));
				Clicking_Country_Drop_Down.click();
			}

			try {
				Thread.sleep(1000);
				driver.switchTo().defaultContent();
				
				WebElement Clicking_Country_Drop_Down_To_Select_Value = driver.findElement(By.xpath("//ng-select[@placeholder='Choose Country']//span[normalize-space()='" + country + "' and @class='ng-option-label']"));
				wait1.until(ExpectedConditions.visibilityOf(Clicking_Country_Drop_Down_To_Select_Value));
				wait1.until(ExpectedConditions.elementToBeClickable(Clicking_Country_Drop_Down_To_Select_Value));
				Clicking_Country_Drop_Down_To_Select_Value.click();
				Loader_Wait();
			} catch (Exception e2) {
				Thread.sleep(2000);
				driver.switchTo().defaultContent();
				try {
					WebElement Clicking_Country_Drop_Down_To_Select_Value = driver.findElement(By.xpath("//ng-select[@placeholder='Choose Country']//span[normalize-space()='" + country + "' and @class='ng-option-label']"));
					wait1.until(ExpectedConditions.visibilityOf(Clicking_Country_Drop_Down_To_Select_Value));
					Clicking_Country_Drop_Down_To_Select_Value.click();
					Loader_Wait();
				}
				catch (Exception e3) {
					
				}
				
			}

		}

	}

	public void Clicking_Legal_Entity_Drop_Down(String Legal_entity) throws InterruptedException {

		/*
		 * This method is used to select the Clicking Legal Entity Drop Down
		 */

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
				
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));

		try {
			WebElement Clicking_Legal_Entity_Drop_Down = driver.findElement(By.xpath("//ng-select[@bindvalue='businessunitCode']"));
			wait1.until(ExpectedConditions.visibilityOf(Clicking_Legal_Entity_Drop_Down));
			wait1.until(ExpectedConditions.elementToBeClickable(Clicking_Legal_Entity_Drop_Down));
			Clicking_Legal_Entity_Drop_Down.click();

			Thread.sleep(1000);

			WebElement Clicking_legal_Entity_Drop_Down_To_Select_Value = driver.findElement(By.xpath("//ng-select[@bindvalue='businessunitCode']//span[normalize-space()='" + Legal_entity + "' and @class='ng-option-label']"));
			wait1.until(ExpectedConditions.visibilityOf(Clicking_legal_Entity_Drop_Down_To_Select_Value));
			wait1.until(ExpectedConditions.elementToBeClickable(Clicking_legal_Entity_Drop_Down_To_Select_Value));

			Clicking_legal_Entity_Drop_Down_To_Select_Value.click();

			Loader_Wait();

			String value = "";

			try {
				value = Clicking_legal_Entity_Drop_Down_To_Select_Value.getText();
			} catch (StaleElementReferenceException e) {
				wait1.until(ExpectedConditions
						.refreshed(ExpectedConditions.stalenessOf(Clicking_legal_Entity_Drop_Down_To_Select_Value)));
				value = driver
						.findElement(By.xpath("//ng-select[@bindvalue='businessunitCode']//div[@class='ng-value']"))
						.getText();
			}
			System.out.println("Legal_entity name  is     " + value);
			Assert.assertEquals(value, Legal_entity, "Legal entity is not selected properly");

		} catch (Exception e) {

			try {
				WebElement Clicking_Legal_Entity_Drop_Down = driver.findElement(By.xpath("//ng-select[@bindvalue='businessunitCode']"));
				wait1.until(ExpectedConditions.visibilityOf(Clicking_Legal_Entity_Drop_Down));
				Clicking_Legal_Entity_Drop_Down.click();

			} catch (Exception e1) {
				Thread.sleep(2000);
				WebElement Clicking_Legal_Entity_Drop_Down = driver.findElement(By.xpath("//ng-select[@bindvalue='businessunitCode']"));
				wait1.until(ExpectedConditions.visibilityOf(Clicking_Legal_Entity_Drop_Down));
				Clicking_Legal_Entity_Drop_Down.click();

			}
			try {
				Thread.sleep(1000);
				driver.switchTo().defaultContent();

				WebElement Clicking_legal_Entity_Drop_Down_To_Select_Value = driver.findElement(By.xpath("//ng-select[@bindvalue='businessunitCode']//span[normalize-space()='" + Legal_entity + "' and @class='ng-option-label']"));
				wait1.until(ExpectedConditions.visibilityOf(Clicking_legal_Entity_Drop_Down_To_Select_Value));
				Clicking_legal_Entity_Drop_Down_To_Select_Value.click();
				Loader_Wait();
			} catch (Exception e2) {
				Thread.sleep(2000);
				driver.switchTo().defaultContent();
				
				WebElement Clicking_legal_Entity_Drop_Down_To_Select_Value = driver.findElement(By.xpath("//ng-select[@bindvalue='businessunitCode']//span[normalize-space()='" + Legal_entity + "' and @class='ng-option-label']"));
				wait1.until(ExpectedConditions.visibilityOf(Clicking_legal_Entity_Drop_Down_To_Select_Value));
				Clicking_legal_Entity_Drop_Down_To_Select_Value.click();
				Loader_Wait();

			}

		}
	}

	public void Clicking_Application_Drop_Down(String Application) throws InterruptedException {

		/*
		 * This method is used to select the Clicking Application Drop Down
		 */
		
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));

		try {
			WebElement Clicking_Application_Drop_Down = driver
					.findElement(By.xpath("//ng-select[@placeholder='Choose Application']"));
			wait1.until(ExpectedConditions.visibilityOf(Clicking_Application_Drop_Down));
			wait1.until(ExpectedConditions.elementToBeClickable(Clicking_Application_Drop_Down));
			Clicking_Application_Drop_Down.click();

			Thread.sleep(1000);

			WebElement Clicking_Application_Name_Drop_Down_To_Select_Value = driver.findElement(By.xpath("//ng-select[@placeholder='Choose Application']//span[normalize-space()='" + Application + "' and @class='ng-option-label']"));
			wait1.until(ExpectedConditions.visibilityOf(Clicking_Application_Name_Drop_Down_To_Select_Value));
			wait1.until(ExpectedConditions.elementToBeClickable(Clicking_Application_Name_Drop_Down_To_Select_Value));

			Clicking_Application_Name_Drop_Down_To_Select_Value.click();

			Loader_Wait();

			String value = "";

			try {
				value = Clicking_Application_Name_Drop_Down_To_Select_Value.getText();
			} catch (StaleElementReferenceException e) {
				wait1.until(ExpectedConditions.refreshed(
						ExpectedConditions.stalenessOf(Clicking_Application_Name_Drop_Down_To_Select_Value)));
				value = driver
						.findElement(By.xpath("//ng-select[@placeholder='Choose Application']//div[@class='ng-value']"))
						.getText();
			}
			System.out.println("Application name  is     " + value);
			Assert.assertEquals(value, Application, "Test failed - application name not selected properly");

		} catch (Exception e) {

			try {
				WebElement Clicking_Application_Drop_Down = driver
						.findElement(By.xpath("//ng-select[@placeholder='Choose Application']"));
				wait1.until(ExpectedConditions.visibilityOf(Clicking_Application_Drop_Down));
				wait1.until(ExpectedConditions.elementToBeClickable(Clicking_Application_Drop_Down));
				Clicking_Application_Drop_Down.click();

			} catch (Exception e1) {

				Thread.sleep(2000);
				WebElement Clicking_Application_Drop_Down = driver
						.findElement(By.xpath("//ng-select[@placeholder='Choose Application']"));
				wait1.until(ExpectedConditions.visibilityOf(Clicking_Application_Drop_Down));
				wait1.until(ExpectedConditions.elementToBeClickable(Clicking_Application_Drop_Down));
				Clicking_Application_Drop_Down.click();
			}

			try {
				Thread.sleep(1000);
				driver.switchTo().defaultContent();

				WebElement Clicking_Application_Name_Drop_Down_To_Select_Value = driver.findElement(
						By.xpath("//ng-select[@placeholder='Choose Application']//span[normalize-space()='" + Application + "' and @class='ng-option-label']"));
				wait1.until(ExpectedConditions.visibilityOf(Clicking_Application_Name_Drop_Down_To_Select_Value));
				Clicking_Application_Name_Drop_Down_To_Select_Value.click();

				Loader_Wait();

			} catch (Exception e2) {
				Thread.sleep(2000);
				driver.switchTo().defaultContent();

				WebElement Clicking_Application_Name_Drop_Down_To_Select_Value = driver.findElement(
						By.xpath("//ng-select[@placeholder='Choose Application']//span[normalize-space()='" + Application + "' and @class='ng-option-label']"));
				wait1.until(ExpectedConditions.visibilityOf(Clicking_Application_Name_Drop_Down_To_Select_Value));
				Clicking_Application_Name_Drop_Down_To_Select_Value.click();

				Loader_Wait();
			}
		}
	}

	public void Clicking_Category_One_Drop_Down(String data) throws InterruptedException {

		/*
		 * This method is used to select the Clicking Category One Drop Down
		 */
		
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));

		try {
			WebElement Clicking_Category_One_Drop_Down = driver
					.findElement(By.xpath("//ng-select[@placeholder='Choose Category1']"));
			wait1.until(ExpectedConditions.visibilityOf(Clicking_Category_One_Drop_Down));
			wait1.until(ExpectedConditions.elementToBeClickable(Clicking_Category_One_Drop_Down));
			Clicking_Category_One_Drop_Down.click();

			Thread.sleep(1000);

			WebElement Clicking_Category_One_Drop_Down_To_Select_Value = driver
					.findElement(By.xpath("//ng-select[@placeholder='Choose Category1']//span[normalize-space()='" + data + "' and @class='ng-option-label']"));
			wait1.until(ExpectedConditions.visibilityOf(Clicking_Category_One_Drop_Down_To_Select_Value));
			wait1.until(ExpectedConditions.elementToBeClickable(Clicking_Category_One_Drop_Down_To_Select_Value));
			Clicking_Category_One_Drop_Down_To_Select_Value.click();

			Loader_Wait();
			String value = "";

			try {
				value = Clicking_Category_One_Drop_Down_To_Select_Value.getText();
			} catch (StaleElementReferenceException e) {
				wait1.until(ExpectedConditions
						.refreshed(ExpectedConditions.stalenessOf(Clicking_Category_One_Drop_Down_To_Select_Value)));
				value = driver
						.findElement(By.xpath("//ng-select[@placeholder='Choose Category1']//div[@class='ng-value']"))
						.getText();
			}
			System.out.println("Category_One  name  is     " + value);
			Assert.assertEquals(value, data, "Test failed - category 1 not selected properly");

		}

		catch (Exception e) {

			try {
				WebElement Clicking_Category_One_Drop_Down = driver
						.findElement(By.xpath("//ng-select[@placeholder='Choose Category1']"));
				wait1.until(ExpectedConditions.visibilityOf(Clicking_Category_One_Drop_Down));
				wait1.until(ExpectedConditions.elementToBeClickable(Clicking_Category_One_Drop_Down));
				Clicking_Category_One_Drop_Down.click();

			} catch (Exception e1) {
				Thread.sleep(2000);

				WebElement Clicking_Category_One_Drop_Down = driver
						.findElement(By.xpath("//ng-select[@placeholder='Choose Category1']"));
				wait1.until(ExpectedConditions.visibilityOf(Clicking_Category_One_Drop_Down));
				wait1.until(ExpectedConditions.elementToBeClickable(Clicking_Category_One_Drop_Down));
				Clicking_Category_One_Drop_Down.click();
			}

			try {
				Thread.sleep(1000);
				driver.switchTo().defaultContent();
				
				WebElement Clicking_Category_One_Drop_Down_To_Select_Value = driver
						.findElement(By.xpath("//ng-select[@placeholder='Choose Category1']//span[normalize-space()='" + data + "' and @class='ng-option-label']"));
				wait1.until(ExpectedConditions.visibilityOf(Clicking_Category_One_Drop_Down_To_Select_Value));
				wait1.until(ExpectedConditions.elementToBeClickable(Clicking_Category_One_Drop_Down_To_Select_Value));
				Clicking_Category_One_Drop_Down_To_Select_Value.click();

				Loader_Wait();

			} catch (Exception e2) {
				Thread.sleep(2000);
				driver.switchTo().defaultContent();
				
				WebElement Clicking_Category_One_Drop_Down_To_Select_Value = driver
						.findElement(By.xpath("//ng-select[@placeholder='Choose Category1']//span[normalize-space()='" + data + "' and @class='ng-option-label']"));
				wait1.until(ExpectedConditions.visibilityOf(Clicking_Category_One_Drop_Down_To_Select_Value));
				wait1.until(ExpectedConditions.elementToBeClickable(Clicking_Category_One_Drop_Down_To_Select_Value));
				Clicking_Category_One_Drop_Down_To_Select_Value.click();

				Loader_Wait();

			}

		}

	}

	public void Clicking_Category_Two_Drop_Down(String data) throws InterruptedException {

		/*
		 * This method is used to select the Clicking Category Two Drop Down
		 */
		
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
				
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		try {

			WebElement Clicking_Category_Two_Drop_Down = driver
					.findElement(By.xpath("//ng-select[@placeholder='Choose Category2']"));
			wait1.until(ExpectedConditions.visibilityOf(Clicking_Category_Two_Drop_Down));
			wait1.until(ExpectedConditions.elementToBeClickable(Clicking_Category_Two_Drop_Down));
			Clicking_Category_Two_Drop_Down.click();

			Thread.sleep(1000);

			WebElement Clicking_Category_Two_Drop_Down_To_Select_Value = driver
					.findElement(By.xpath("//ng-select[@placeholder='Choose Category2']//span[normalize-space()='" + data + "' and @class='ng-option-label' ]"));
			wait1.until(ExpectedConditions.visibilityOf(Clicking_Category_Two_Drop_Down_To_Select_Value));
			wait1.until(ExpectedConditions.elementToBeClickable(Clicking_Category_Two_Drop_Down_To_Select_Value));
			Clicking_Category_Two_Drop_Down_To_Select_Value.click();

			Loader_Wait();

			String value = "";

			try {
				value = Clicking_Category_Two_Drop_Down_To_Select_Value.getText();
			} catch (StaleElementReferenceException e) {
				wait1.until(ExpectedConditions
						.refreshed(ExpectedConditions.stalenessOf(Clicking_Category_Two_Drop_Down_To_Select_Value)));
				value = driver
						.findElement(By.xpath("//ng-select[@placeholder='Choose Category2']//div[@class='ng-value']"))
						.getText();
			}
			System.out.println("Category_Two name  is     " + value);
			Assert.assertEquals(value, data,"Test failed - category 2 not selected properly");

		} catch (Exception e) {

			try {

				WebElement Clicking_Category_Two_Drop_Down = driver
						.findElement(By.xpath("//ng-select[@placeholder='Choose Category2']"));
				wait1.until(ExpectedConditions.visibilityOf(Clicking_Category_Two_Drop_Down));
				wait1.until(ExpectedConditions.elementToBeClickable(Clicking_Category_Two_Drop_Down));
				Clicking_Category_Two_Drop_Down.click();

			} catch (Exception e1) {
				Thread.sleep(2000);
				WebElement Clicking_Category_Two_Drop_Down = driver
						.findElement(By.xpath("//ng-select[@placeholder='Choose Category2']"));
				wait1.until(ExpectedConditions.visibilityOf(Clicking_Category_Two_Drop_Down));
				wait1.until(ExpectedConditions.elementToBeClickable(Clicking_Category_Two_Drop_Down));
				Clicking_Category_Two_Drop_Down.click();
			}

			try {
				Thread.sleep(1000);
				
				driver.switchTo().defaultContent();
				
				WebElement Clicking_Category_Two_Drop_Down_To_Select_Value = driver.findElement(
						By.xpath("//ng-select[@placeholder='Choose Category2']//span[normalize-space()='" + data + "' and @class='ng-option-label' ]"));
				wait1.until(ExpectedConditions.visibilityOf(Clicking_Category_Two_Drop_Down_To_Select_Value));
				wait1.until(ExpectedConditions.elementToBeClickable(Clicking_Category_Two_Drop_Down_To_Select_Value));
				Clicking_Category_Two_Drop_Down_To_Select_Value.click();

				Loader_Wait();
			} catch (Exception e2) {
				Thread.sleep(2000);
				
				driver.switchTo().defaultContent();
				WebElement Clicking_Category_Two_Drop_Down_To_Select_Value = driver.findElement(
						By.xpath("//ng-select[@placeholder='Choose Category2']//span[normalize-space()='" + data + "' and @class='ng-option-label' ]"));
				wait1.until(ExpectedConditions.visibilityOf(Clicking_Category_Two_Drop_Down_To_Select_Value));
				wait1.until(ExpectedConditions.elementToBeClickable(Clicking_Category_Two_Drop_Down_To_Select_Value));
				Clicking_Category_Two_Drop_Down_To_Select_Value.click();

				Loader_Wait();
			}

		}

	}

	public void Clicking_Category_Three_Drop_Down(String data) throws InterruptedException {

		/*
		 * This method is used to select the Clicking Category Three Drop Down
		 */
		
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));

		try {
			WebElement Clicking_Category_Three_Drop_Down = driver
					.findElement(By.xpath("//ng-select[@placeholder='Choose Category3']"));
			wait1.until(ExpectedConditions.visibilityOf(Clicking_Category_Three_Drop_Down));
			wait1.until(ExpectedConditions.elementToBeClickable(Clicking_Category_Three_Drop_Down));
			Clicking_Category_Three_Drop_Down.click();

			Thread.sleep(1000);

			WebElement Clicking_Category_Three_Drop_Down_To_Select_Value = driver
					.findElement(By.xpath("//ng-select[@placeholder='Choose Category3']//span[normalize-space()='" + data + "' and @class='ng-option-label' ]"));
			wait1.until(ExpectedConditions.visibilityOf(Clicking_Category_Three_Drop_Down_To_Select_Value));
			wait1.until(ExpectedConditions.elementToBeClickable(Clicking_Category_Three_Drop_Down_To_Select_Value));
			Clicking_Category_Three_Drop_Down_To_Select_Value.click();

			Loader_Wait();

			String value = "";

			try {
				value = Clicking_Category_Three_Drop_Down_To_Select_Value.getText();
			} catch (StaleElementReferenceException e) {
				wait1.until(ExpectedConditions
						.refreshed(ExpectedConditions.stalenessOf(Clicking_Category_Three_Drop_Down_To_Select_Value)));
				value = driver
						.findElement(By.xpath("//ng-select[@placeholder='Choose Category3']//div[@class='ng-value']"))
						.getText();
			}
			System.out.println("Category_Three name  is     " + value);
			Assert.assertEquals(value, data , "Test failed - category 3 not selected propely");

		} catch (Exception e) {
			try {
				WebElement Clicking_Category_Three_Drop_Down = driver
						.findElement(By.xpath("//ng-select[@placeholder='Choose Category3']"));
				wait1.until(ExpectedConditions.visibilityOf(Clicking_Category_Three_Drop_Down));
				wait1.until(ExpectedConditions.elementToBeClickable(Clicking_Category_Three_Drop_Down));
				Clicking_Category_Three_Drop_Down.click();
			} catch (Exception e1) {
				Thread.sleep(2000);
				WebElement Clicking_Category_Three_Drop_Down = driver
						.findElement(By.xpath("//ng-select[@placeholder='Choose Category3']"));
				wait1.until(ExpectedConditions.visibilityOf(Clicking_Category_Three_Drop_Down));
				wait1.until(ExpectedConditions.elementToBeClickable(Clicking_Category_Three_Drop_Down));
				Clicking_Category_Three_Drop_Down.click();
			}

			try {
				Thread.sleep(1000);
				driver.switchTo().defaultContent();
				
				WebElement Clicking_Category_Three_Drop_Down_To_Select_Value = driver.findElement(
						By.xpath("//ng-select[@placeholder='Choose Category3']//span[normalize-space()='" + data + "' and @class='ng-option-label' ]"));
				wait1.until(ExpectedConditions.visibilityOf(Clicking_Category_Three_Drop_Down_To_Select_Value));
				wait1.until(ExpectedConditions.elementToBeClickable(Clicking_Category_Three_Drop_Down_To_Select_Value));
				Clicking_Category_Three_Drop_Down_To_Select_Value.click();

				Loader_Wait();
			} catch (Exception e2) {
				Thread.sleep(2000);
				driver.switchTo().defaultContent();
				
				WebElement Clicking_Category_Three_Drop_Down_To_Select_Value = driver.findElement(
						By.xpath("//ng-select[@placeholder='Choose Category3']//span[normalize-space()='" + data + "' and @class='ng-option-label' ]"));
				wait1.until(ExpectedConditions.visibilityOf(Clicking_Category_Three_Drop_Down_To_Select_Value));
				wait1.until(ExpectedConditions.elementToBeClickable(Clicking_Category_Three_Drop_Down_To_Select_Value));
				Clicking_Category_Three_Drop_Down_To_Select_Value.click();

				Loader_Wait();
			}
		}

	}

	public void Clicking_Category_four_Drop_Down(String data) throws InterruptedException {

		/*
		 * This method is used to select the Clicking Category four Drop Down
		 */

		
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
				
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));

		try {

			WebElement Clicking_Category_four_Drop_Down = driver
					.findElement(By.xpath("//ng-select[@placeholder='Choose Category4']"));
			wait1.until(ExpectedConditions.visibilityOf(Clicking_Category_four_Drop_Down));
			wait1.until(ExpectedConditions.elementToBeClickable(Clicking_Category_four_Drop_Down));
			Clicking_Category_four_Drop_Down.click();

			Thread.sleep(1000);

			WebElement Clicking_Category_four_Drop_Down_To_Select_Value = driver
					.findElement(By.xpath("//ng-select[@placeholder='Choose Category4']//span[normalize-space()='" + data + "' and @class='ng-option-label' ]"));
			wait1.until(ExpectedConditions.visibilityOf(Clicking_Category_four_Drop_Down_To_Select_Value));
			wait1.until(ExpectedConditions.elementToBeClickable(Clicking_Category_four_Drop_Down_To_Select_Value));
			Clicking_Category_four_Drop_Down_To_Select_Value.click();

			Loader_Wait();

			String value = "";

			try {
				value = Clicking_Category_four_Drop_Down_To_Select_Value.getText();
			} catch (StaleElementReferenceException e) {
				wait1.until(ExpectedConditions
						.refreshed(ExpectedConditions.stalenessOf(Clicking_Category_four_Drop_Down_To_Select_Value)));
				Thread.sleep(1000);
				value = driver
						.findElement(By.xpath("//ng-select[@placeholder='Choose Category4']//div[@class='ng-value']"))
						.getText();
			}
			System.out.println("Category_four name  is     " + value);
			Assert.assertEquals(value, data,"Test failed category 4 not selected properly");

		} catch (Exception e) {
			try {
				WebElement Clicking_Category_four_Drop_Down = driver
						.findElement(By.xpath("//ng-select[@placeholder='Choose Category4']"));
				wait1.until(ExpectedConditions.visibilityOf(Clicking_Category_four_Drop_Down));
				wait1.until(ExpectedConditions.elementToBeClickable(Clicking_Category_four_Drop_Down));
				Clicking_Category_four_Drop_Down.click();
			} catch (Exception e1) {
				Thread.sleep(2000);
				WebElement Clicking_Category_four_Drop_Down = driver
						.findElement(By.xpath("//ng-select[@placeholder='Choose Category4']"));
				wait1.until(ExpectedConditions.visibilityOf(Clicking_Category_four_Drop_Down));
				wait1.until(ExpectedConditions.elementToBeClickable(Clicking_Category_four_Drop_Down));
				Clicking_Category_four_Drop_Down.click();
			}
			try {
				Thread.sleep(1000);
					
				driver.switchTo().defaultContent();
				
				WebElement Clicking_Category_four_Drop_Down_To_Select_Value = driver
						.findElement(By.xpath("//ng-select[@placeholder='Choose Category4']//span[normalize-space()='" + data + "' and @class='ng-option-label' ]"));
				wait1.until(ExpectedConditions.visibilityOf(Clicking_Category_four_Drop_Down_To_Select_Value));
				wait1.until(ExpectedConditions.elementToBeClickable(Clicking_Category_four_Drop_Down_To_Select_Value));

				Clicking_Category_four_Drop_Down_To_Select_Value.click();

				Loader_Wait();

			}catch (Exception e2) {
				Thread.sleep(2000);
				driver.switchTo().defaultContent();

				WebElement Clicking_Category_four_Drop_Down_To_Select_Value = driver
						.findElement(By.xpath("//ng-select[@placeholder='Choose Category4']//span[normalize-space()='" + data + "' and @class='ng-option-label' ]"));
				wait1.until(ExpectedConditions.visibilityOf(Clicking_Category_four_Drop_Down_To_Select_Value));
				wait1.until(ExpectedConditions.elementToBeClickable(Clicking_Category_four_Drop_Down_To_Select_Value));

				Clicking_Category_four_Drop_Down_To_Select_Value.click();

				Loader_Wait();
			}

			
		}

	}

	public void Clicking_Category_Five_Drop_Down(String data) throws InterruptedException {

		/*
		 * This method is used to select the Clicking Category five Drop Down
		 */
		
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));

		try {
			WebElement Clicking_Category_Five_Drop_Down = driver
					.findElement(By.xpath("//ng-select[@placeholder='Choose Category5']"));
			wait1.until(ExpectedConditions.visibilityOf(Clicking_Category_Five_Drop_Down));
			wait1.until(ExpectedConditions.elementToBeClickable(Clicking_Category_Five_Drop_Down));
			Clicking_Category_Five_Drop_Down.click();

			Thread.sleep(1000);

			WebElement Clicking_Category_Five_Drop_Down_To_Select_Value = driver
					.findElement(By.xpath("//ng-select[@placeholder='Choose Category5']//span[normalize-space()='" + data + "' and @class='ng-option-label' ]"));
			wait1.until(ExpectedConditions.visibilityOf(Clicking_Category_Five_Drop_Down_To_Select_Value));
			wait1.until(ExpectedConditions.elementToBeClickable(Clicking_Category_Five_Drop_Down_To_Select_Value));
			Clicking_Category_Five_Drop_Down_To_Select_Value.click();

			Loader_Wait();

			String value = "";

			try {
				value = Clicking_Category_Five_Drop_Down_To_Select_Value.getText();
			} catch (StaleElementReferenceException e) {
				wait1.until(ExpectedConditions
						.refreshed(ExpectedConditions.stalenessOf(Clicking_Category_Five_Drop_Down_To_Select_Value)));
				value = driver
						.findElement(By.xpath("//ng-select[@placeholder='Choose Category5']//div[@class='ng-value']"))
						.getText();
			}
			System.out.println("Category_five name is     " + value);
			Assert.assertEquals(value, data, "Test failed -category 5 value not seletced properly");
		} catch (Exception e) {
			
			try {
				WebElement Clicking_Category_Five_Drop_Down = driver
						.findElement(By.xpath("//ng-select[@placeholder='Choose Category5']"));
				wait1.until(ExpectedConditions.visibilityOf(Clicking_Category_Five_Drop_Down));
				wait1.until(ExpectedConditions.elementToBeClickable(Clicking_Category_Five_Drop_Down));
				Clicking_Category_Five_Drop_Down.click();
			}
			catch (Exception e1) {
				WebElement Clicking_Category_Five_Drop_Down = driver
						.findElement(By.xpath("//ng-select[@placeholder='Choose Category5']"));
				wait1.until(ExpectedConditions.visibilityOf(Clicking_Category_Five_Drop_Down));
				wait1.until(ExpectedConditions.elementToBeClickable(Clicking_Category_Five_Drop_Down));
				Clicking_Category_Five_Drop_Down.click();
			}

			try {
				Thread.sleep(1000);
				driver.switchTo().defaultContent();
				WebElement Clicking_Category_Five_Drop_Down_To_Select_Value = driver
						.findElement(By.xpath("//ng-select[@placeholder='Choose Category5']//span[normalize-space()='" + data + "' and @class='ng-option-label' ]"));
				wait1.until(ExpectedConditions.visibilityOf(Clicking_Category_Five_Drop_Down_To_Select_Value));
				Clicking_Category_Five_Drop_Down_To_Select_Value.click();

				Loader_Wait();
			}catch (Exception e2) {
				Thread.sleep(2000);
				driver.switchTo().defaultContent();
				WebElement Clicking_Category_Five_Drop_Down_To_Select_Value = driver
						.findElement(By.xpath("//ng-select[@placeholder='Choose Category5']//span[normalize-space()='" + data + "' and @class='ng-option-label' ]"));
				wait1.until(ExpectedConditions.visibilityOf(Clicking_Category_Five_Drop_Down_To_Select_Value));
				Clicking_Category_Five_Drop_Down_To_Select_Value.click();

				Loader_Wait();
			}

		
		}

	}

	public void Clicking_Processing_Year_Drop_Down(String data) throws InterruptedException {

		/*
		 * This method is used to select the Clicking Processing_Year Drop Down
		 */
		
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement Clicking_Processing_Year_Drop_Down = driver
				.findElement(By.xpath("//ng-select[@placeholder='Choose Processing Year']"));
		wait1.until(ExpectedConditions.visibilityOf(Clicking_Processing_Year_Drop_Down));
		wait1.until(ExpectedConditions.elementToBeClickable(Clicking_Processing_Year_Drop_Down));
		Clicking_Processing_Year_Drop_Down.click();

		WebElement Clicking_Processing_Year_Drop_Down_To_Select_Value = driver
				.findElement(By.xpath("//span[normalize-space()='" + data + "' and @class='ng-option-label' ]"));
		wait1.until(ExpectedConditions.visibilityOf(Clicking_Processing_Year_Drop_Down_To_Select_Value));
		wait1.until(ExpectedConditions.elementToBeClickable(Clicking_Processing_Year_Drop_Down_To_Select_Value));
		Clicking_Processing_Year_Drop_Down_To_Select_Value.click();

		Loader_Wait();

		String value = "";

		try {
			value = Clicking_Processing_Year_Drop_Down_To_Select_Value.getText();
		} catch (StaleElementReferenceException e) {
			wait1.until(ExpectedConditions
					.refreshed(ExpectedConditions.stalenessOf(Clicking_Processing_Year_Drop_Down_To_Select_Value)));
			value = driver
					.findElement(By.xpath("//ng-select[@placeholder='Choose Processing Year']//div[@class='ng-value']"))
					.getText();
		}
		System.out.println("processing year   is     " + value);
		Assert.assertEquals(value, data, "Test failed processing year not selected properly");

	}

	public void Clicking_Processing_Period_Drop_Down(String data) throws InterruptedException {

		/*
		 * This method is used to select the Clicking Category Three Drop Down
		 */

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
				
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement Clicking_Processing_Period_Drop_Down = driver
				.findElement(By.xpath("//ng-select[@placeholder='Choose Processing Period']"));
		wait1.until(ExpectedConditions.visibilityOf(Clicking_Processing_Period_Drop_Down));
		wait1.until(ExpectedConditions.elementToBeClickable(Clicking_Processing_Period_Drop_Down));
		Clicking_Processing_Period_Drop_Down.click();

		WebElement Clicking_Processing_Period_Drop_Down_To_Select_Value = driver
				.findElement(By.xpath("//div[@role='option']//span[normalize-space()='" + data + "']"));
		wait1.until(ExpectedConditions.visibilityOf(Clicking_Processing_Period_Drop_Down_To_Select_Value));
		wait1.until(ExpectedConditions.elementToBeClickable(Clicking_Processing_Period_Drop_Down_To_Select_Value));
		Clicking_Processing_Period_Drop_Down_To_Select_Value.click();

		Loader_Wait();

	}

	public void Clicking_Search_Button() throws InterruptedException {

		/*
		 * This method is used to select the Clicking Category One Drop Down
		 */
		
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement Clicking_Search_Button = driver.findElement(By.xpath("//div//a[@title='Fetch documents']"));
		wait1.until(ExpectedConditions.visibilityOf(Clicking_Search_Button));
		wait1.until(ExpectedConditions.elementToBeClickable(Clicking_Search_Button));
		Clicking_Search_Button.click();

		Loader_Wait();

		WebElement Table_visiblity_Check = driver.findElement(By.xpath("//table[@class='card']"));
		wait1.until(ExpectedConditions.visibilityOf(Table_visiblity_Check));
		wait1.until(ExpectedConditions.elementToBeClickable(Table_visiblity_Check));
		Assert.assertTrue(Table_visiblity_Check.isDisplayed(),
				"Test failed - list view is not showing and search button not clicked");

	}

	public void Uploaded_On_Drop_Down_Click() {

		/*
		 * This method is used to select the Uploaded On Drop Down
		 */
		
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement Uploaded_On_Drop_Down_Click = driver.findElement(By.xpath("//span[@id='ndrice_spoc_listview3']//i"));
		wait1.until(ExpectedConditions.visibilityOf(Uploaded_On_Drop_Down_Click));
		Uploaded_On_Drop_Down_Click.click();

	}

	public void Sort_By_Newest_First_Click() throws InterruptedException {

		/*
		 * This method is used to select the Uploaded On Drop Down
		 */

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		WebElement Sort_By_Newest_First_Click = driver.findElement(By.xpath("(//ul[@id='ndrice_spoc_listviewtarget3']//div//span)[1]"));
		new Actions(driver).doubleClick(Sort_By_Newest_First_Click).perform();

		Actions action1 = new Actions(driver);
		action1.sendKeys(Keys.ESCAPE).build().perform();

	}

	public void Download_Button_Click() throws InterruptedException {

		/*
		 * This method is used to click download button
		 */
		
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement Download_Button_Click = driver.findElement(By.xpath("(//button[@title='downlaod file'])[1]"));
		wait1.until(ExpectedConditions.visibilityOf(Download_Button_Click));
		wait1.until(ExpectedConditions.elementToBeClickable(Download_Button_Click));
		Download_Button_Click.click();

		Loader_Wait();

	}

	public void Reset_Button_Click() {

		/*
		 * This method is used to click reset button
		 */
		
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement Reset_Button_Click = driver.findElement(By.xpath("(//div//a[@title='Reset'])[1]"));
		wait1.until(ExpectedConditions.visibilityOf(Reset_Button_Click));
		wait1.until(ExpectedConditions.elementToBeClickable(Reset_Button_Click));
		Reset_Button_Click.click();

	}

	public void Reset_Working_Check() {

		/*
		 * This method is used to check that all fields are empty or not
		 */
		
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(50));

		// Client selecting

		WebElement Clicking_Client_Drop_Down = driver
				.findElement(By.xpath("//ng-select[@placeholder='Choose client']"));
		wait1.until(ExpectedConditions.visibilityOf(Clicking_Client_Drop_Down));

		if (Clicking_Client_Drop_Down.getText().equals("Choose client")) {
			Assert.assertTrue(true, " Test case failed - Client field not emptied ");
		} else {
			Assert.assertTrue(false, " Test case failed - Client field not emptied  ");
		}

		// Country

		WebElement Clicking_Country_Drop_Down = driver
				.findElement(By.xpath("//ng-select[@placeholder='Choose Country']"));
		wait1.until(ExpectedConditions.visibilityOf(Clicking_Country_Drop_Down));

		if (Clicking_Country_Drop_Down.getText().equals("Choose Country")) {
			Assert.assertTrue(true, "  Test case failed - Country field not emptied ");
		} else {
			Assert.assertTrue(false, " Test case failed - Country field not emptied ");
		}

		// legal entity

		WebElement Clicking_Legal_Entity_Drop_Down = driver
				.findElement(By.xpath("//ng-select[@bindvalue='businessunitCode']"));
		wait1.until(ExpectedConditions.visibilityOf(Clicking_Legal_Entity_Drop_Down));

		if (Clicking_Legal_Entity_Drop_Down.getText().equals("Choose Legal Entity")) {
			Assert.assertTrue(true, " Test case failed  - Legal Entity field not empty ");
		} else {
			Assert.assertTrue(false, " Test case failed  - Legal Entity field not empty ");
		}

		// application

		WebElement Clicking_Application_Drop_Down = driver
				.findElement(By.xpath("//ng-select[@placeholder='Choose Application']"));
		wait1.until(ExpectedConditions.visibilityOf(Clicking_Application_Drop_Down));

		if (Clicking_Application_Drop_Down.getText().equals("Choose Application")) {
			Assert.assertTrue(true, " Test case failed - Application field not empty ");
		} else {
			Assert.assertTrue(false, " Test case failed - Application field not empty ");
		}

		// Category 1

		WebElement Clicking_Category_One_Drop_Down = driver
				.findElement(By.xpath("//ng-select[@placeholder='Choose Category1']"));
		wait1.until(ExpectedConditions.visibilityOf(Clicking_Category_One_Drop_Down));
		if (Clicking_Category_One_Drop_Down.getText().equals("Choose Category1")) {
			Assert.assertTrue(true, " Test case failed -  Category1 field not empty ");
		} else {
			Assert.assertTrue(false, " Test case failed -  Category1 field not empty ");
		}

		// Category 2
		WebElement Clicking_Category_Two_Drop_Down = driver
				.findElement(By.xpath("//ng-select[@placeholder='Choose Category2']"));
		wait1.until(ExpectedConditions.visibilityOf(Clicking_Category_Two_Drop_Down));
		if (Clicking_Category_Two_Drop_Down.getText().equals("Choose Category2")) {
			Assert.assertTrue(true, " Test case failed -  Category 2 field not empty ");
		} else {
			Assert.assertTrue(false, " Test case failed -  Category 2 field not empty ");
		}

		// Category 3
		WebElement Clicking_Category_Three_Drop_Down = driver
				.findElement(By.xpath("//ng-select[@placeholder='Choose Category3']"));
		wait1.until(ExpectedConditions.visibilityOf(Clicking_Category_Three_Drop_Down));
		if (Clicking_Category_Three_Drop_Down.getText().equals("Choose Category3")) {
			Assert.assertTrue(true, " Test case failed -  Category 3 field not empty ");
		} else {
			Assert.assertTrue(false, " Test case failed -  Category 3 field not empty ");
		}

		// Category 4
		WebElement Clicking_Category_four_Drop_Down = driver
				.findElement(By.xpath("//ng-select[@placeholder='Choose Category4']"));
		wait1.until(ExpectedConditions.visibilityOf(Clicking_Category_four_Drop_Down));
		if (Clicking_Category_four_Drop_Down.getText().equals("Choose Category4")) {
			Assert.assertTrue(true, " Test case failed -  Category 4 field not empty ");
		} else {
			Assert.assertTrue(false, "Test case failed -  Category 4 field not empty ");
		}

		// Category 5
		WebElement Clicking_Category_Five_Drop_Down = driver
				.findElement(By.xpath("//ng-select[@placeholder='Choose Category5']"));
		wait1.until(ExpectedConditions.visibilityOf(Clicking_Category_Five_Drop_Down));
		if (Clicking_Category_Five_Drop_Down.getText().equals("Choose Category5")) {
			Assert.assertTrue(true, " Test case failed -  Category 5 field not empty ");
		} else {
			Assert.assertTrue(false, " Test case failed -  Category 5 field not empty ");
		}

		// Choose Processing Year
		WebElement Clicking_Processing_Year_Drop_Down = driver
				.findElement(By.xpath("//ng-select[@placeholder='Choose Processing Year']"));
		wait1.until(ExpectedConditions.visibilityOf(Clicking_Processing_Year_Drop_Down));

		if (Clicking_Processing_Year_Drop_Down.getText().equals("Choose Processing Year")) {
			Assert.assertTrue(true, " Test case failed - Processing Year field not empty ");
		} else {
			Assert.assertTrue(false, " Test case failed - Processing Year field not empty ");
		}

		// Choose Processing Period
		WebElement Clicking_Processing_Period_Drop_Down = driver
				.findElement(By.xpath("//ng-select[@placeholder='Choose Processing Period']"));
		wait1.until(ExpectedConditions.visibilityOf(Clicking_Processing_Period_Drop_Down));
		if (Clicking_Processing_Period_Drop_Down.getText().equals("Choose Processing Period")) {
			Assert.assertTrue(true, " Test case failed - Processing Period field not empty ");
		} else {
			Assert.assertTrue(false, " Test case failed - Processing Period field not empty ");
		}

	}

	public void Date_Time_Check() {
		
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
				
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));

		try {
			WebElement Date_Time_Check = driver.findElement(
					By.xpath("//table//tr//td//span[@id=\"ndrice_spoc_listviewtableDataColumn30\"]//span"));
			wait1.until(ExpectedConditions.visibilityOf(Date_Time_Check));

			String a = Date_Time_Check.getText();

			System.out.print("Time is   -  " + a);

			String[] Actual = a.split(" ");
			String Actual2 = Actual[1];

			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss a");
			LocalDateTime now = LocalDateTime.now();
			String date_and_time = dtf.format(now);
			System.out.println("current time" + date_and_time);
			String[] current = date_and_time.split(" ");
			String current2 = current[1];

			String date_and_time_reduced = dtf.format(now.minusMinutes(5));
			System.out.println("reduced time" + date_and_time_reduced);

			// day month and year are equal
			Assert.assertEquals(Actual[0], current[0]);

		} catch (ArrayIndexOutOfBoundsException e) {
			Assert.assertTrue(false, "Test failed there is no date to check");
		}

	}

}
