

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Navigate_Methods {

	    public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
			
		
		driver.navigate().to("https://google.com");
		Thread.sleep(4000);
				
			driver.findElement(By.xpath(".//*[@id='tsf']/div[2]/div/div[3]/center/input[1]")).click();
			Thread.sleep(4000);
				
				driver.navigate().back();
				Thread.sleep(4000);
				
					driver.navigate().forward();
					Thread.sleep(4000);
		
		 }
}