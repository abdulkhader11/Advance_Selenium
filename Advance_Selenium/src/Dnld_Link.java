import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Dnld_Link {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
			
		
		driver.navigate().to("https://chromedriver.storage.googleapis.com/index.html?path=2.44/");
		Thread.sleep(4000);

		driver.findElement(By.linkText("chromedriver_win32.zip")).click();
		
	}

}
