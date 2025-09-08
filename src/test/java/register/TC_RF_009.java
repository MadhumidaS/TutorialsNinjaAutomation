package register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_009 
{

	@Test
	public void verifyRegisteringAccountByProvidingExistingAccountDetails() 
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("Madhumida");
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("S");
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("madhucse99@gmail.com");
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("9758732411");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Madhu@2903");
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("Madhu@2903");
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String ExpectedWarning = "Warning: E-Mail Address is already registered!";
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText(), ExpectedWarning);
		
		driver.quit();
	}
}
