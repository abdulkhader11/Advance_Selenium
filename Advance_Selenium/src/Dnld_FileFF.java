import java.io.File;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Dnld_FileFF {

	
	WebDriver driver;
	File folder; 
	
	@BeforeMethod
	public void setup(){
	
		//88889-99898-909090-98988-09909
			folder = new File(UUID.randomUUID().toString());
			folder.mkdir();
			
			//Firefox 
			
			System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
			driver.manage().window().maximize();
			
			
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("browser.download.dir", folder.getAbsolutePath());
			profile.setPreference("browser.download.folderList", 2);
			profile.setPreference("browser.helperApps.neverAsk.neverAsk.saveToDisk", "image/jpeg, application/pdf, application/octet-stream");
			profile.setPreference("pdfjs.disabled", true);
			
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(ChromeOptions.CAPABILITY, profile);
			
			driver = new FirefoxDriver((Capabilities) profile);
			
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