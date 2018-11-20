import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Dnld_File {

	
	WebDriver driver;
	File folder; 
	
	@BeforeMethod
	public void setup(){
	
		//88889-99898-909090-98988-09909
			folder = new File(UUID.randomUUID().toString());
			folder.mkdir();
			
			//chrome
			
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_settings.popups", 0);
			prefs.put("download.default_directory", folder.getAbsolutePath());
			
			options.setExperimentalOption("prefs", prefs);
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			
			
			driver = new ChromeDriver(cap);
			driver.manage().window().maximize();
		
			
}
	
	@Test
	public void downloadFileTest() throws InterruptedException{
		
		driver.get("http://the-internet.herokuapp.com/download");
		driver.findElement(By.linkText("some-file.txt")).click();
	
		Thread.sleep(3000);
		File listOfFiles[] = folder.listFiles();
		
		//make sure the directory is not empty
		Assert.assertTrue(listOfFiles.length>0);
		
		for(File file:listOfFiles){
			
			//make sure that downloaded file is not empty
			Assert.assertTrue(file.length()>0);
		
		}
		
	}
	
	
	
	
	
	
	
	
 	@AfterMethod
	public void tearDown(){
	
		driver.quit();
		for(File file : folder.listFiles()){
			file.delete();
		}
		folder.delete(); 
	
	}
	
}