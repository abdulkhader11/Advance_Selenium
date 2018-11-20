

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowHandle {

	@Test
	public void HandleWindow() {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://www.naukri.com");


		String parent=driver.getWindowHandle();
		// This will return the number of windows opened by Webdriver and will return Set of Strings
		Set<String>s1=driver.getWindowHandles();
		// Now we will iterate using Iterator
		Iterator<String>I1=s1.iterator();

		while(I1.hasNext())
		{
			String child_window=I1.next();

			// Here we will compare if parent window is not equal to child window then we will close

			if(!parent.equals(child_window))
			{
				driver.switchTo().window(child_window);

				System.out.println(driver.switchTo().window(child_window).getTitle());

				driver.close();

				driver.switchTo().window(parent);	
			}
		}
	}
}