package xcite.shopping;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class registerUser extends projectSpec{
	@Test	
	public void register() {
		
		String username="winvin112u@gmail.com";
		String password="Test@123";
		driver.findElement(By.xpath("//div[@class='relative z-50 ']/button")).click();
		driver.findElement(By.xpath("//span[text()='Create an account in less than 1 minute']")).click();
	    WebElement user=driver.findElement(By.xpath("//input[@placeholder='Please enter your email']"));
	    user.sendKeys(username);
	    WebElement pwd = driver.findElement(By.xpath("//input[@placeholder='Choose a password']"));
	    pwd.sendKeys(password);
	    driver.findElement(By.xpath("//input[@type='checkbox']")).click();
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    System.out.println("verification code sent successfully for registration");
	    
	    
		}
		
		
	
}
