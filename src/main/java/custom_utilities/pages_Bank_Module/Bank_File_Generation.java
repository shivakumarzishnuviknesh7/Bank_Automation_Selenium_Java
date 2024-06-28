package custom_utilities.pages_Bank_Module;


import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Bank_File_Generation {

	public WebDriver driver;

	public Bank_File_Generation(WebDriver driver) {
		this.driver = driver;
	}

	public void Loader_Wait() {

		/*
		 * This method is used to make wait until the loader image gets disappear
		 */
		
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		List<WebElement> heading_check = driver.findElements(By.xpath("//div//img[contains(@src,'gif')]"));
		wait.until(ExpectedConditions.invisibilityOfAllElements(heading_check));
	}

	public void Country_Selection(String country) {

		/*
		 * This method is used to select the country
		 */

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(120));

		WebElement Country_Selection_box_click = driver.findElement(By.xpath("//ng-select[@name='countryTypeId']"));
		wait1.until(ExpectedConditions.visibilityOf(Country_Selection_box_click));
		Country_Selection_box_click.click();

		WebElement Country_Selection = driver
				.findElement(By.xpath("//div[@role='option']//span[normalize-space()='" + country + "']"));
		wait1.until(ExpectedConditions.visibilityOf(Country_Selection));
		Country_Selection.click();

		WebElement Loader_Wait = driver.findElement(
				By.xpath("//img[@src='https://d18p7q3hkf4a9m.cloudfront.net/Bankfile/BankModule/loader_new.gif']"));
		if (Loader_Wait.isDisplayed()) {
			Loader_Wait();
		} else {

		}

		String text = Country_Selection_box_click.getText();

		Assert.assertEquals(text.contains(country), true, "Test failed value is not selected properly");

	}

	public void Legal_Entity(String legal_entity) {

		/*
		 * This method is used to select the legal entity
		 */
		
		// Implicit wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement Legal_Entity = driver.findElement(By.xpath("//ng-select[@name='buTypeId']"));
		wait1.until(ExpectedConditions.visibilityOf(Legal_Entity));
		wait1.until(ExpectedConditions.elementToBeClickable(Legal_Entity));
		Legal_Entity.click();

		WebElement legal_entity_value = driver
				.findElement(By.xpath("//div[@role='option']//span[normalize-space()='" + legal_entity + "']"));
		wait1.until(ExpectedConditions.visibilityOf(legal_entity_value));
		wait1.until(ExpectedConditions.elementToBeClickable(legal_entity_value));
		legal_entity_value.click();

		WebElement Loader_Wait = driver.findElement(
				By.xpath("//img[@src='https://d18p7q3hkf4a9m.cloudfront.net/Bankfile/BankModule/loader_new.gif']"));
		if (Loader_Wait.isDisplayed()) {
			Loader_Wait();
		} else {

		}

		String text = Legal_Entity.getText();
		Assert.assertEquals(text.contains(legal_entity), true, "Test failed value is not selected properly");

	}

	public void PayGroup(String pay_group) throws InterruptedException {

		/*
		 * This method is used to select the pay group
		 */
		
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement PayGroup = driver.findElement(By.xpath("//ng-select[@name='paygroupTypeId']"));
		wait1.until(ExpectedConditions.visibilityOf(PayGroup));
		wait1.until(ExpectedConditions.elementToBeClickable(PayGroup));
		PayGroup.click();

		Thread.sleep(1000);
		WebElement PayGroup_value = driver
				.findElement(By.xpath("//div[@role='option']//span[normalize-space()='" + pay_group + "']"));
		wait1.until(ExpectedConditions.visibilityOf(PayGroup_value));
		wait1.until(ExpectedConditions.elementToBeClickable(PayGroup_value));
		PayGroup_value.click();

		WebElement Loader_Wait = driver.findElement(
				By.xpath("//img[@src='https://d18p7q3hkf4a9m.cloudfront.net/Bankfile/BankModule/loader_new.gif']"));
		if (Loader_Wait.isDisplayed()) {
			Loader_Wait();
		} else {

		}

		String text = PayGroup.getText();
		Assert.assertEquals(text.contains(pay_group), true, "Test failed value is not selected properly");

	}

	public void Processing_Period(String processing_period) {

		/*
		 * This method is used to select the processing period
		 */
		
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement Processing_Period = driver.findElement(By.xpath("//ng-select[@name='processingPeriod']"));
		wait1.until(ExpectedConditions.visibilityOf(Processing_Period));
		wait1.until(ExpectedConditions.elementToBeClickable(Processing_Period));
		Processing_Period.click();

		WebElement Processing_Period_value = driver
				.findElement(By.xpath("//div[@role='option']//span[normalize-space()='" + processing_period + "']"));
		wait1.until(ExpectedConditions.visibilityOf(Processing_Period_value));
		wait1.until(ExpectedConditions.elementToBeClickable(Processing_Period_value));
		Processing_Period_value.click();

		WebElement Loader_Wait = driver.findElement(
				By.xpath("//img[@src='https://d18p7q3hkf4a9m.cloudfront.net/Bankfile/BankModule/loader_new.gif']"));
		if (Loader_Wait.isDisplayed()) {
			Loader_Wait();
		} else {

		}

		String text = Processing_Period.getText();
		Assert.assertEquals(text.contains(processing_period), true, "Test failed value is not selected properly");

	}

	public void PayRun_Type(String payrunType) {

		/*
		 * This method is used to select the processing period
		 */
		
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement PayRun_Type = driver.findElement(By.xpath("//ng-select[@name='payruntype']"));
		wait1.until(ExpectedConditions.visibilityOf(PayRun_Type));
		wait1.until(ExpectedConditions.elementToBeClickable(PayRun_Type));
		PayRun_Type.click();


		try {
		WebElement PayRun_Type_value = driver
				.findElement(By.xpath("//div[@role='option']//span[normalize-space()='" + payrunType + "']"));
		wait1.until(ExpectedConditions.visibilityOf(PayRun_Type_value));
		wait1.until(ExpectedConditions.elementToBeClickable(PayRun_Type_value));
		PayRun_Type_value.click();
		
		WebElement Loader_Wait = driver.findElement(
				By.xpath("//img[@src='https://d18p7q3hkf4a9m.cloudfront.net/Bankfile/BankModule/loader_new.gif']"));
		if (Loader_Wait.isDisplayed()) {
			Loader_Wait();
		} else {

		}

		String text = PayRun_Type.getText();
		Assert.assertEquals(text.contains(payrunType), true, "Test failed value is not selected properly");

		} catch (Exception e) {
			System.out.println("pay run type not found");
		}
	}

	public void Pay_Type(String paytype) {

		/*
		 * This method is used to select the country
		 */
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement Pay_Type = driver.findElement(By.xpath("//ng-select[@name='paytype']"));
		wait1.until(ExpectedConditions.visibilityOf(Pay_Type));
		wait1.until(ExpectedConditions.elementToBeClickable(Pay_Type));
		Pay_Type.click();

		WebElement Pay_Type_Selection = driver
				.findElement(By.xpath("//div[@role='option']//span[normalize-space()='" + paytype + "']"));
		wait1.until(ExpectedConditions.visibilityOf(Pay_Type_Selection));
		wait1.until(ExpectedConditions.elementToBeClickable(Pay_Type_Selection));
		Pay_Type_Selection.click();

		WebElement Loader_Wait = driver.findElement(
				By.xpath("//img[@src='https://d18p7q3hkf4a9m.cloudfront.net/Bankfile/BankModule/loader_new.gif']"));
		if (Loader_Wait.isDisplayed()) {
			Loader_Wait();
		} else {

		}

		String text = Pay_Type.getText();

		Assert.assertEquals(text.contains(paytype), true, "Test failed value is not selected properly");

	}

	public void Search_Button_Click() {

		/*
		 * This method is used to click the search button
		 */
		
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement Search_Button_Click = driver.findElement(By.xpath("//button[@title='Search']"));
		wait1.until(ExpectedConditions.visibilityOf(Search_Button_Click));
		wait1.until(ExpectedConditions.elementToBeClickable(Search_Button_Click));

		Assert.assertTrue(Search_Button_Click.isDisplayed(), "Test failed - search button not visible");
		Search_Button_Click.click();

	}

	public void Bank_Reports_visibility_check() {

		/*
		 * This method is used for to check bank report is showing or not
		 */

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement Bank_Reports_visibility_check = driver.findElement(By.xpath("//div[text()='Bank reports']"));
		wait1.until(ExpectedConditions.visibilityOf(Bank_Reports_visibility_check));

		String a = "Bank reports";
		String b = Bank_Reports_visibility_check.getText();

		Assert.assertEquals(a, b, "Test case failed - Report  page didn't open properly");

	}

	public void Generate_File_Button_Click() {

		/*
		 * This method is used to click the generate file button
		 */

		// implict wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement Generate_File_Button_Click = driver.findElement(By.xpath("//button[@title='Generate File']"));
		wait1.until(ExpectedConditions.visibilityOf(Generate_File_Button_Click));
		wait1.until(ExpectedConditions.elementToBeClickable(Generate_File_Button_Click));
		Generate_File_Button_Click.click();

	}

	public void Generate_File_Visibility_Check() {

		/*
		 * This method is used for to check generate file is showing or not
		 */
		
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement Generate_File_Visibility_Check = driver.findElement(By.xpath("//button[@title='Generate File']"));
		wait1.until(ExpectedConditions.visibilityOf(Generate_File_Visibility_Check));

		String a = "Generate File";
		String b = Generate_File_Visibility_Check.getText();

		Assert.assertEquals(a, b, "Test case failed - generate file  page didn't open properly");

	}

	public void toaster_invisible() {

		/*
		 * This method is used to check that toaster message all are gone and wait till
		 * that
		 */
		
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		try {
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(50));
			List<WebElement> toaster_message = driver.findElements(By.xpath("//div[@id='toast-container']"));
			wait1.until(ExpectedConditions.invisibilityOfAllElements(toaster_message));
		} catch (Exception e) {
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(50));
			List<WebElement> toaster_message = driver.findElements(By.xpath("//div[@id='toast-container']"));
			wait1.until(ExpectedConditions.invisibilityOfAllElements(toaster_message));
		}
		
	}

	public void Bell_Icon_Click() {

		/*
		 * This method is used for to click bell icon
		 */

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
				
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement Bell_Icon_Click = driver.findElement(By.xpath("//a[@class='notifCount']//img"));
		wait1.until(ExpectedConditions.visibilityOf(Bell_Icon_Click));
		wait1.until(ExpectedConditions.elementToBeClickable(Bell_Icon_Click));
		Bell_Icon_Click.click();

	}

	public void Notification_Check(String message) {

		/*
		 * This method is used for to check generate file is showing or not
		 */

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
				
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(15));

		try {
			WebElement Notification_Check = driver.findElement(By.xpath("//div//a[@title='" + message + "']"));
			wait1.until(ExpectedConditions.visibilityOf(Notification_Check));

			// String a = "et1350 No response from PNC for PayrunType";
			String a = "et1350 " + message;
			String b = Notification_Check.getText();

			System.out.print("text is  - " + b);

			Assert.assertEquals(a, b, "Test case failed - value in notification is not working as we expected");
			
			WebElement clear_all_click = driver.findElement(By.xpath("//a[normalize-space()='Clear All']"));
			wait1.until(ExpectedConditions.visibilityOf(clear_all_click));
			clear_all_click.click();
			
			driver.switchTo().alert().accept();
			

			

		} catch(NoSuchElementException e) {
			System.out.println(e);
			Assert.assertTrue(false,"Test failed because the message is not correct or not visible");
			
			WebElement clear_all_click = driver.findElement(By.xpath("//a[normalize-space()='Clear All']"));
			wait1.until(ExpectedConditions.visibilityOf(clear_all_click));
			clear_all_click.click();
			
			driver.switchTo().alert().accept();
			
		} 
	}
	
	public void Notification_Check_2_messages(String message,String message2) {

		/*
		 * This method is used for to checknotification message
		 */
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			WebElement Notification_Check = driver.findElement(By.xpath("//div//a[@title='" + message + "']"));
			wait1.until(ExpectedConditions.visibilityOf(Notification_Check));

			// String a = "et1350 No response from PNC for PayrunType";
			String a = "et1350 " + message;
			String b = Notification_Check.getText();

			System.out.print("text is  - " + b);

			Assert.assertEquals(a, b, "Test case failed - value in notification is not working as we expected");
			
			
			
			WebElement Notification_2_Check = driver.findElement(By.xpath("//div//a[@title='" + message2 + "']"));
			wait1.until(ExpectedConditions.visibilityOf(Notification_2_Check));

			
			String a2 = "et1350 " + message;
			String b2 = Notification_2_Check.getText();

			System.out.print("text is  - " + b2);

			Assert.assertEquals(a2, b2, "Test case failed - value in notification is not working as we expected");

			
			WebElement clear_all_click = driver.findElement(By.xpath("//a[normalize-space()='Clear All']"));
			wait1.until(ExpectedConditions.visibilityOf(clear_all_click));
			clear_all_click.click();
			
			driver.switchTo().alert().accept();
			

			

		} catch(Exception e) {
			System.out.println(e);
			
			WebElement clear_all_click = driver.findElement(By.xpath("//a[normalize-space()='Clear All']"));
			wait1.until(ExpectedConditions.visibilityOf(clear_all_click));
			clear_all_click.click();
			
			driver.switchTo().alert().accept();
			
		}
	}


	public void Assertion_Check(String message) throws InterruptedException {

		File file = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "java" + File.separator + "resources" + File.separator + "Id_Password.properties");

		FileInputStream fis1 = null;
		try {
			fis1 = new FileInputStream(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(fis1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String Run_Environment = prop.getProperty("Run_environment");

		if (Run_Environment.equals("Featureuat")) {
			
			Thread.sleep(2000);

			/*
			 * This method is used to check that toaster message is coming or not and it
			 * will validate whether correct message is coming or not
			 */
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(50));
			ArrayList<String> messages_Actual = new ArrayList<String>();
			ArrayList<String> messages_Expected = new ArrayList<String>();

			wait1.until(ExpectedConditions.visibilityOfAllElements(
					driver.findElements(By.xpath("//div[@id='toast-container']//span[@class='black-text left']"))));
			List<WebElement> toaster_message_save_record = driver
					.findElements(By.xpath("//div[@id='toast-container']//span[@class='black-text left']"));
			System.out.println("actual size " + toaster_message_save_record.size());
			String toaster_message = "";
			for (int i = 0; i < toaster_message_save_record.size(); i++) {
				String temp_message = toaster_message_save_record.get(i).getText();
				String temp = toaster_message_save_record.get(i).findElement(By.xpath("i")).getText();
				temp_message = temp_message.replaceAll(temp, "");
				temp_message = temp_message.trim();
				if (i == 0) {
					toaster_message = temp_message;
					messages_Actual.add(temp_message);
				}

				else {
					toaster_message = toaster_message + "\n" + temp_message;
					messages_Actual.add(temp_message);
				}
			}

			// System.out.println(message+"\n"+toaster_message);
			String[] expectedmessges = message.split("\n");

			System.out.println("message from the excel is   \n" + expectedmessges);
			// for(int i=0;i<expectedmessges.length;i++)
			// System.out.println(expectedmessges[i]);
			for (String text : expectedmessges) {
				System.out.println("message from the excel is   \n" + text);
				messages_Expected.add(text);
			}

			Collections.sort(messages_Actual);
			Collections.sort(messages_Expected);
			for (int i = 0; i < messages_Actual.size(); i++) {
				System.out.println("message from the Actual is   \n" + messages_Actual.get(i));

			}

			for (int i = 0; i < messages_Expected.size(); i++) {
				System.out.println("message from the expected is   \n" + messages_Expected.get(i));

			}
			// System.out.println("message actual is
			// ---------"+messages_Actual+"\n"+"messages_Expected is
			// -----------"+messages_Expected);
			Assert.assertEquals(messages_Actual.equals(messages_Expected), true,
					" Test case failed - the toaster message is visible and expected and actual text is not same Actual:- "
							+ toaster_message + "Expected:- " + message);

		} else if (Run_Environment.equals("Bugfix")) {

			Thread.sleep(4000);

			/*
			 * This method is used to check that toaster message is coming or not and it
			 * will validate whether correct message is coming or not
			 */
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(50));
			ArrayList<String> messages_Actual = new ArrayList<String>();
			ArrayList<String> messages_Expected = new ArrayList<String>();

			wait1.until(ExpectedConditions
					.visibilityOfAllElements(driver.findElements(By.xpath("//div[@id='toast-container']//div"))));
			List<WebElement> toaster_message_save_record = driver
					.findElements(By.xpath("//div[@id='toast-container']//div"));
			System.out.println("actual size " + toaster_message_save_record.size());
			String toaster_message = "";
			for (int i = 0; i < toaster_message_save_record.size(); i++) {
				String temp_message = toaster_message_save_record.get(i).getText();
				String a = temp_message;
				System.out.println("message which is showing    \n" + temp_message);
				// String temp =
				// toaster_message_save_record.get(i).findElement(By.xpath("i")).getText();
				temp_message = temp_message.replaceAll(a, "");
				temp_message = temp_message.trim();
				if (i == 0) {
					toaster_message = temp_message;
					messages_Actual.add(a);
				}

				else {
					toaster_message = toaster_message + "\n" + temp_message;
					messages_Actual.add(a);
				}
			}

			// System.out.println(message+"\n"+toaster_message);
			String[] expectedmessges = message.split("\n");

			System.out.println("message from the excel is   \n" + expectedmessges);
			// for(int i=0;i<expectedmessges.length;i++)
			// System.out.println(expectedmessges[i]);
			for (String text : expectedmessges) {
				System.out.println("message from the excel is   \n" + text);
				messages_Expected.add(text);
			}

			Collections.sort(messages_Actual);
			Collections.sort(messages_Expected);
			for (int i = 0; i < messages_Actual.size(); i++) {
				System.out.println("message from the Actual is   \n" + messages_Actual.get(i));

			}

			for (int i = 0; i < messages_Expected.size(); i++) {
				System.out.println("message from the expected is   \n" + messages_Expected.get(i));

			}
			Assert.assertEquals(messages_Actual.equals(messages_Expected), true,
					" Test case failed - the toaster message is visible and expected and actual text is not same Actual:- "
							+ toaster_message + "Expected:- " + message);

		} else {

			System.out.println("provide proper instance name");
			Assert.assertTrue(false, "didn't provide proper instance name");
		}

	}

	public void Reset_Button_Click() {

		/*
		 * This method is used for to click reset button
		 */
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(15));

		WebElement Reset_Button_Click = driver.findElement(By.xpath("//div[@class='row bank_questioningCss']//button[@title='Reset' and @type='Reset']"));
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

		// country selecting

		WebElement Country_Selection_box_click = driver.findElement(By.xpath("//ng-select[@name='countryTypeId']"));
		wait1.until(ExpectedConditions.visibilityOf(Country_Selection_box_click));

		System.out.println("country value is     -  " + Country_Selection_box_click.getText());

		if (Country_Selection_box_click.getText().equals("Choose Country Name")) {
			Assert.assertTrue(true, " Test case failed - country not emptied ");
		} else {
			Assert.assertTrue(false, " Test case failed - country value is present ");
		}

		// legal entity

		WebElement Legal_Entity = driver.findElement(By.xpath("//ng-select[@name='buTypeId']"));
		wait1.until(ExpectedConditions.visibilityOf(Legal_Entity));

		System.out.println("Legal_Entity value is     -  " + Legal_Entity.getText());

		if (Legal_Entity.getText().equals("Choose Business unit")) {
			Assert.assertTrue(true, "  Test case failed - Legal_Entity not emptied ");
		} else {
			Assert.assertTrue(false, " Test case failed - Legal_Entity value is present");
		}

		// pay group

		WebElement PayGroup = driver.findElement(By.xpath("//ng-select[@name='paygroupTypeId']"));
		wait1.until(ExpectedConditions.visibilityOf(PayGroup));

		if (PayGroup.getText().equals("Choose Paygroup")) {
			Assert.assertTrue(true, " Test case failed  - PayGroup not empty ");
		} else {
			Assert.assertTrue(false, " Test case failed -PayGroup not empty ");
		}

		// processing period

		WebElement Processing_Period = driver.findElement(By.xpath("//ng-select[@name='processingPeriod']"));
		wait1.until(ExpectedConditions.visibilityOf(Processing_Period));
		if (Processing_Period.getText().equals("Choose Proceesing Period")) {
			Assert.assertTrue(true, " Test case failed - Processing_Period not empty ");
		} else {
			Assert.assertTrue(false, " Test case failed - Processing_Period field is not empty ");
		}

		// payrun type

		WebElement PayRun_Type = driver.findElement(By.xpath("//ng-select[@name='payruntype']"));
		wait1.until(ExpectedConditions.visibilityOf(PayRun_Type));
		if (PayRun_Type.getText().equals("Choose Payrun Type")) {
			Assert.assertTrue(true, " Test case failed - PayRun_Type not empty ");
		} else {
			Assert.assertTrue(false, " Test case failed - PayRun_Type field is not empty ");
		}

		// pay type
		WebElement Pay_Type = driver.findElement(By.xpath("//ng-select[@name='paytype']"));

		System.out.println("paytype  value is     -  " + Pay_Type.getText());

		wait1.until(ExpectedConditions.visibilityOf(Pay_Type));
		if (Pay_Type.getText().equals("Choose PayType")) {
			Assert.assertTrue(true, " Test case failed - PayType not empty ");
		} else {
			Assert.assertTrue(false, " Test case failed - PayType field is not empty ");
		}

	}

}
