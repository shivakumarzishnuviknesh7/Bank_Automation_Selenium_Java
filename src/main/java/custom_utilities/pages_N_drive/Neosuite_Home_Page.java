package custom_utilities.pages_N_drive;

import org.openqa.selenium.By;
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

	public void NDrive_click(String widget_name) {

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement NDrive_click = driver.findElement(By.xpath("//div[@title='"+widget_name+"']"));
		wait1.until(ExpectedConditions.visibilityOf(NDrive_click));
		wait1.until(ExpectedConditions.elementToBeClickable(NDrive_click));
		NDrive_click.click();
	}

	public void Loader_Wait() {

		/*
		 * This method is used to make wait until the loader image gets disappear
		 */

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		List<WebElement> Loader_Wait = driver.findElements(By.xpath("//img[@src='https://d18p7q3hkf4a9m.cloudfront.net/NDrive/ndrive/ndriveLoader.gif']"));
		wait.until(ExpectedConditions.invisibilityOfAllElements(Loader_Wait));
	}

}
