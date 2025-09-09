package register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_010 {

	@Test
	public void verifyRegisteringAccountUsingInvalidEmail()
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("Madhumida");
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("S");
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("madhucse");
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("9758732411");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Madhu@2903");
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("Madhu@2903");
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String ExpectedWarningMessageOne = "Please include an '@' in the email address. 'madhucse' is missing an '@'.";
		String ActualWarningMessageOne = driver.findElement(By.xpath("//input[@id='input-email']")).getAttribute("validationMessage");
		Assert.assertEquals(ActualWarningMessageOne, ExpectedWarningMessageOne);
		
		driver.findElement(By.xpath("//input[@id='input-email']")).clear();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("madhucse@");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String ExpectedWarningMessageTwo = "Please enter a part following '@'. 'madhucse@' is incomplete.";
		String ActualWarningMessageTwo = driver.findElement(By.xpath("//input[@id='input-email']")).getAttribute("validationMessage");
		//System.out.println(ActualWarningMessageTwo);
		Assert.assertEquals(ActualWarningMessageTwo, ExpectedWarningMessageTwo);
		
		driver.findElement(By.xpath("//input[@id='input-email']")).clear();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("madhucse@gmail");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String ExpectedWarningMessageThree = "E-Mail Address does not appear to be valid!";
		String ActualWarningMessageThree = driver.findElement(By.xpath("//div[text()=\"E-Mail Address does not appear to be valid!\"]")).getText();
		Assert.assertEquals(ActualWarningMessageThree, ExpectedWarningMessageThree);
		
		driver.findElement(By.xpath("//input[@id='input-email']")).clear();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("madhucse@gmail.");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String ExpectedWarningMessageFour = "'.' is used at a wrong position in 'gmail.'.";
		String ActualWarningMessageFour = driver.findElement(By.xpath("//input[@id='input-email']")).getAttribute("validationMessage");
		Assert.assertEquals(ActualWarningMessageFour, ExpectedWarningMessageFour);
		
		driver.quit();
	}
	
}
