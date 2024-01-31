package xcite.shopping;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;






public class AddProducts extends projectSpec {
	
	@Test
	public void addProducts() throws InterruptedException   {
		
		driver.findElement(By.xpath("//div[@class='relative z-50 ']/button")).click();
		WebElement user=driver.findElement(By.xpath("//input[@placeholder='Please enter your email']"));
	    user.sendKeys("winvin2u@gmail.com");
	    driver.findElement(By.xpath("//span[text()='Log in']")).click();
	    driver.findElement(By.id("password")).sendKeys("Test@123");
	    driver.findElement(By.xpath("//span[text()='Log in']")).click();
		//search iphone
		WebElement search =driver.findElement(By.xpath("//input[@id='search']"));
		search.sendKeys("iphone");
		search.sendKeys(Keys.RETURN);
		//select 2nd iphone
		List <WebElement> iphone = driver.findElements(By.xpath("//div[@class='ProductList_tileWrapper__cV7B_']"));
		if(iphone.size()>=2){
			iphone.get(1).click();
		}
		
		else {
			
			System.out.println("No more additional items found");
		}
		
		driver.findElement(By.xpath("//button[@class='button primaryCta w-full sm:max-w-[335px]']")).click();
		driver.findElement(By.xpath("//a[@href='https://www.xcite.com/checkout/cart']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement quantity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='increase quantity']")));
		quantity.click();
		driver.findElement(By.xpath("//button[@class='button primaryOnLight ']//span")).click();
		driver.findElement(By.xpath("//label[@for='location']//div[contains(@class,'cursor-pointer')]")).click();
		WebElement address = driver.findElement(By.xpath("//input[@placeholder='Please, enter your address']"));
		Thread.sleep(4000);
		address.clear();
		address.sendKeys("salmiya block10");
		Thread.sleep(3000);
		
		List<WebElement> suggestionList = driver.findElements(By.xpath("//ul[@role='listbox']//li"));

		for (WebElement suggestion : suggestionList) {
		    if (suggestion.getText().contains("Block 10, Salmiya, Kuwait")) {
		        suggestion.click();
		        Thread.sleep(2000);
		        // Re-find the elements after clicking on the suggestion
		        address = driver.findElement(By.xpath("//input[@placeholder='Please, enter your address']"));
		        break;
		    }
		}

	            
	            driver.findElement(By.xpath("//span[text()='Confirm location']")).click();
	            
	            driver.findElement(By.xpath("//input[@placeholder='Primary Phone Number']")).sendKeys("+96566874512");
                driver.findElement(By.xpath("//button[@class='button primaryOnLight ']//span")).click();
		}
	}
	
			

