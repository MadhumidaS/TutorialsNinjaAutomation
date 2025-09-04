package register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.CommonUtilities;

public class TC_RF_005 {
	
	@Test
	public void verifyRegisteringAccountBySubscribingToNewsletter()
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		// To Enter Personal Details
		
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Madhumida");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("S");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(CommonUtilities.generateBrandNewEmail());
		driver.findElement(By.xpath("//input[@name='telephone']")).sendKeys("9590020704");
		
		// To Enter Password
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Madhu@01");
		driver.findElement(By.xpath("//input[@name='confirm']")).sendKeys("Madhu@01");
		
		// To Click on Newsletter
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		
		// To click on Privacy Policy and Continue
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
				
		driver.findElement(By.linkText("Continue")).click();
		
		//Newsletter
		driver.findElement(By.linkText("Subscribe / unsubscribe to newsletter")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Newsletter']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).isSelected());
		
		driver.quit();
	}

}
