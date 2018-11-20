import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class DatePicker {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();

		//URL
		driver.get("https://www.phptravels.net/");
 		Thread.sleep(3000);
		
		WebElement date = driver.findElement(By.xpath("//div[@id='dpd1']//input[@placeholder='Check in']"));
		String dateVal = "27-11-2018";
			
			selectDateByJS(driver, date, dateVal);
	}

	public static void selectDateByJS(WebDriver driver, WebElement element, String dateVal){
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');", element);
}
}
