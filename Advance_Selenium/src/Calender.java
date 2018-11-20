import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Calender {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
			
		
		driver.navigate().to("https://www.freecrm.com");
		Thread.sleep(4000);
		
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("naveenk");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("test@123");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Thread.sleep(4000);
		
		
		//Calender
		driver.findElement(By.xpath("/html[1]/body[1]/table[1]/tbody[1]/tr[3]/td[1]/div[1]/div[1]/ul[1]/li[2]/a[1]")).click();
		
		
		
		
		
	}
	
	

}
