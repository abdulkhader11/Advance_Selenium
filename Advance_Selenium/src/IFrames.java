
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

	public class IFrames {
			
		public static void main(String[] args) throws InterruptedException {
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
	
	//URL
	driver.get("http://www.dezlearn.com/testingpage/");
	
//Code for IFrame
		driver.switchTo().frame("contact-iframe");
		Thread.sleep(3000);
	
//Menu bar
		driver.findElement(By.className("mob-icon-menu")).click();
		Thread.sleep(3000);
	
//select items from (Selenium) menu bar
		driver.findElement(By.xpath(".//*[@id='mobmenuleft']/li[2]/a")).click();
		Thread.sleep(3000);
	
//Switch to parent window
		driver.switchTo().parentFrame();
		Thread.sleep(3000);
	
//Switch  to another window
		driver.switchTo().frame("do-it-iframe");
	
//Add search element in box
		driver.findElement(By.xpath(".//*[@id='main']/section/div/form/label/input")).sendKeys("W3 School.com");
		driver.findElement(By.xpath(".//*[@id='main']/section/div/form/input")).click();
		Thread.sleep(3000);
	
//Switch to parent window
		driver.switchTo().parentFrame();
		driver.findElement(By.xpath("//a[@id='popup']")).click();
		Thread.sleep(3000);
		driver.quit();
	
	}
}
