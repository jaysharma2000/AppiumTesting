import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class VehicleClaimAppTest {
	
	public static void main(String[] args) {
		
	try {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi Note 8 Pro");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		capabilities.setCapability("appPackage", "com.example.vehicleinsuranceclaimapp");
		capabilities.setCapability("appActivity", ".MainActivity");
		
		AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement beginButtonElement = driver.findElement(By.id("beginButton"));
		
		beginButtonElement.click();
		
		WebElement firstTitle = driver.findElement(By.xpath("//android.widget.TextView[@text='Welcome Back!']"));
		
		if(firstTitle.getText().equals("Welcome Back!")) {
			System.out.println("Successfully navigated to Login Page");
		}
		
		WebElement registerButtonElement = driver.findElement(By.id("registerBtn"));
		registerButtonElement.click();
		
		WebElement registerTitle = driver.findElement(By.xpath("//android.widget.TextView[@text='Register']"));
		
		if(registerTitle.getText().equals("Register")) {
			System.out.println("Successfully navigated to Register Page");
		}
		
		WebElement registerUsernameField = driver.findElement(By.xpath("//android.widget.EditText[@hint='enter the username']"));
		WebElement registerEmailField = driver.findElement(By.xpath("//android.widget.EditText[@hint='enter your email']"));
		WebElement registerPasswordField = driver.findElement(By.xpath("//android.widget.EditText[@hint='enter your password']"));
		WebElement createAccountElement = driver.findElement(By.id("registerButton"));
		
		registerUsernameField.sendKeys("jaysharma");
		registerEmailField.sendKeys("jaysharma@gmail.com");
		registerPasswordField.sendKeys("12345");
		createAccountElement.click();
		
		System.out.println("Registration Successfull!");
		
		WebElement loginUsernameField = driver.findElement(By.xpath("//android.widget.EditText[@hint='Username']"));
		WebElement loginPasswordField = driver.findElement(By.xpath("//android.widget.EditText[@hint='Password']"));
		WebElement loginButtonElement = driver.findElement(By.id("loginButton"));
		
		loginUsernameField.sendKeys("jaysharma");
		loginPasswordField.sendKeys("12345");
		
		loginButtonElement.click();
		
		WebElement startClaimButtonElement = driver.findElement(By.id("startClaim"));
		
		if(startClaimButtonElement.isDisplayed()) {
			System.out.println("Login successfull!");
			System.out.println("Navigated to the dashboard page");
		}
		
		
		WebElement yourPoliciesButtonElement = driver.findElement(By.id("myPolicies"));
		
		yourPoliciesButtonElement.click();
		
		WebElement addPolicyTextElement = driver.findElement(By.xpath("//android.widget.TextView[@text='Add Policy']"));
		
		if(addPolicyTextElement.isDisplayed()) {
			System.out.println("Navigated to add policy page");
		}
		
		WebElement vehicleTypeFieldElement = driver.findElement(By.xpath("//android.widget.EditText[@hint='Vehicle Type']"));
		WebElement vehicleNumberFieldElement = driver.findElement(By.xpath("//android.widget.EditText[@hint='Vehicle Number']"));
		WebElement savePolicyElement  = driver.findElement(By.id("savePolicyButton"));
		
		vehicleTypeFieldElement.sendKeys("Four Wheeler");
		vehicleNumberFieldElement.sendKeys("MADH2523K");
		savePolicyElement.click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	     WebElement addedPolicy = driver.findElement(By.id("tvVehicleNumber"));
	     
	     if(addedPolicy.isDisplayed()) {
	    	 System.out.println("Added Vehicle Number: " + addedPolicy.getText());
	    	 System.out.println("Policy added successfully");
	     }else {
	    	 System.out.println("Policy not found in RecyclerView!");
	     }
	     
	     driver.navigate().back();
	     System.out.println("back navigation to dashboard page completed.");
	     
	        
		
		driver.quit();
		
	}catch(Exception e) {
		e.printStackTrace();
   }
	
  }
}




