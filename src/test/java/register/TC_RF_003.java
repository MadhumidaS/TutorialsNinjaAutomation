package register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.CommonUtilities;

public class TC_RF_003 {
	
		@Test
		public void verifyRegisteringAccount() {
			// TODO Auto-generated method stub
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
			
			// To Check if the user is logged in to Account Success page
			Assert.assertTrue(driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Logout']")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.xpath("//ul[@class=\"breadcrumb\"]//a[text()=\"Success\"]")).isDisplayed());
			
			String text1 = "Your Account Has Been Created!";
			String text2 = "Congratulations! Your new account has been successfully created!";
			String text3 = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
			String text4 = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
			String text5 = "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please contact us.";
			
			
			Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']")).getText().contains(text1));
			Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']")).getText().contains(text2));
			Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']")).getText().contains(text3));
			Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']")).getText().contains(text4));
			Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']")).getText().contains(text5));
			
			driver.findElement(By.linkText("Continue")).click();
			
			Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
			
			
			driver.quit();

	}

}
