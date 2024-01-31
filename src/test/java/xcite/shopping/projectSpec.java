package xcite.shopping;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class projectSpec {

public RemoteWebDriver driver;
private ExtentTest test;
public static ExtentReports extent;

@BeforeSuite

public void extentReport() {
ExtentSparkReporter htmlReporter = new ExtentSparkReporter("./Reports/ExtentReport.html");
if (extent == null) {
     extent = new ExtentReports();
     extent.attachReporter(htmlReporter);
 }
}


	@Parameters({"browser"})
	@BeforeMethod
	public void browserlogin(String browser) throws InterruptedException {
		   ExtentSparkReporter htmlReporter = new ExtentSparkReporter("./Reports/ExtentReport.html");
		   if (extent == null) {
	            extent = new ExtentReports();
	            extent.attachReporter(htmlReporter);
	        }

            test = extent.createTest("Registration and Shopping Test case");
            ChromeOptions options = new ChromeOptions();
	        options.addArguments("--disable-notifications");
            switch(browser) {
    		case "chrome":
    			driver = new ChromeDriver(options);
    			break;
    		case "edge":
    			driver = new EdgeDriver();
    			break;
    		case "firefox":
    			driver = new FirefoxDriver();
    		   break;
    		default:
    		driver = new InternetExplorerDriver();
    		
    		
    		}     
			driver.manage().window().maximize();
			driver.get("https://www.xcite.com/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			driver.findElement(By.xpath("//span[text()='Dismiss']")).click();

	}
	
	@AfterMethod
	public void postCondition(ITestResult result) {
		
		
		 if (result.getStatus() == ITestResult.FAILURE) {
	          
	            test.log(Status.FAIL, "Test Failed");
	            test.log(Status.FAIL, result.getThrowable());
	        } else if (result.getStatus() == ITestResult.SUCCESS) {
	        

	            test.log(Status.PASS, "Test Passed");
	        } else {
	            test.log(Status.SKIP, "Test Skipped");
	            test.log(Status.SKIP, result.getThrowable());
	        }
	
		driver.close();
		extent.flush();
	}
	
}
