package custom_utilities.pages_Bank_Module;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Bank_Module_Login {
	
		String loginPassword;
	    String loginId;
	    String url;


	public WebDriver driver;

	public Bank_Module_Login(WebDriver driver) {
		this.driver = driver;
	}

	public void bank_Login() throws AWTException, InterruptedException {
		File file = new File(System.getProperty("user.dir")  + File.separator +"src" + File.separator +"test"+ File.separator +"java" + File.separator +"resources" + File.separator +"Id_Password.properties");
		
		
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		String Run_Environment = prop.getProperty("Run_environment");
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(50));

		  if (Run_Environment.equals("Featureuat")) {

			 	 loginPassword = prop.getProperty("passcode_Bank_module");
				 loginId = prop.getProperty("id_Bank_module");
				 url = prop.getProperty("URL_Bank_module");

	        } else if (Run_Environment.equals("Bugfix")) {

	        	 loginPassword = prop.getProperty("passcode_Bank_module_bug_Fix");
	    		 loginId = prop.getProperty("id_Bank_module_bug_Fix");
	    		 url = prop.getProperty("URL_Bank_module_bug_Fix");

	        } else {

	            System.out.println("provide proper instance name");
	            Assert.assertTrue(false, "didn't provide proper instance name");
	        }

		driver.get(url);
		driver.manage().window().maximize();
		
		WebElement heading = driver.findElement(By.xpath("//div[@id='kc-header-wrapper']"));
		wait1.until(ExpectedConditions.visibilityOf(heading));
		String a = heading.getText();
		

		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		wait1.until(ExpectedConditions.visibilityOf(username));
		username.sendKeys(loginId);

		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		wait1.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys(loginPassword);

		WebElement login = driver.findElement(By.xpath("//input[@name='login']"));
		wait1.until(ExpectedConditions.visibilityOf(login));
		login.click();

	}

}
