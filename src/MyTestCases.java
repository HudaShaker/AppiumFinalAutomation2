import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class MyTestCases {
	// step 1
	DesiredCapabilities caps = new DesiredCapabilities();
	SoftAssert myAssertion = new SoftAssert();

	
	@BeforeTest
	public void myBeforeTest() {
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "huda");
//	   caps.setCapability("chromedriverExecutable","C:\\Users\\User\\OneDrive\\Desktop\\mydriver\\chromewebdriver\\chromedriver.exe");
//	   caps.setCapability(MobileCapabilityType.BROWSER_NAME,"chrome");
		File app = new File("src/myApplications/calculator.apk");
		caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
	}

	@Test
	public void ClickonAllDigits() throws MalformedURLException, InterruptedException {
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);

		List<WebElement> myButtons = driver.findElements(By.className("android.widget.ImageButton"));

		for (int i = 0; i < myButtons.size(); i++) {
			if (myButtons.get(i).getAttribute("resource-id").contains("digit")) {
				myButtons.get(i).click();
			}
	           
//				softassert
				String Expected ="7894561230";
				String Actual =driver.findElement(By.id("com.google.android.calculator:id/formula")).getText();
			
			    myAssertion.assertEquals(Actual,Expected);
		        myAssertion.assertAll();
			
}}

	
		
//		    hardassert
//			Assertion myAssert = new Assertion();
//			String Expected = "7894561230";
//			String Actual = driver.findElement(By.id("com.google.android.calculator:id/formula")).getText();
//			myAssert.assertEquals(Actual, Expected);
//		}
		

	
	@AfterTest
	public void myAfterTest() {
	}}
