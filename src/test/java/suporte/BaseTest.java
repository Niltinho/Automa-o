package suporte;

import org.junit.After;
import org.openqa.selenium.WebDriver;

public class BaseTest {
	
	WebDriver driver;
	
	@After
	public void tearDown() {
		driver.quit();
		
	}

}