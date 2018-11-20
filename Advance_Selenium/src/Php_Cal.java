import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Php_Cal {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.navigate().to("https://www.phptravels.net/");
		Thread.sleep(4000);
		
		//Hotel
		//driver.findElement(By.xpath("/html[1]/body[1]/div[5]/section[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/a[1]/span[1]")).sendKeys("Taj Hotel");
		//driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS) ;
		
		//Check-In
		driver.findElement(By.xpath("//div[@id='dpd1']//input[@placeholder='Check in']")).click();
		driver.findElement(By.xpath("//div[9]//div[1]//table[1]//tbody[1]//tr[5]//td[3]")).click();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS) ;
		
		//Check-Out
		driver.findElement(By.xpath("//input[@placeholder='Check out']")).click();
		driver.findElement(By.xpath("//div[10]//div[1]//table[1]//tbody[1]//tr[5]//td[5]")).click();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS) ;
		driver.close();
		
		//No. of Persons
		//driver.findElement(By.xpath("//input[@id='travellersInput']")).sendKeys("2");
		//driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS) ;
				
		//Search
		//driver.findElement(By.xpath("/html[1]/body[1]/div[5]/section[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[5]/button[1]")).click();
		//driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS) ;
		
	}
}