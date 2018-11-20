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
		
		driver.findElement(By.xpath("//div[@id='dpd1']//input[@placeholder='Check in']")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Check out']")).click();
		
		  
		
		
		
		
		
		
	}
}