package tests;

	import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
	
	public class Testando{
		
		private WebDriver driver;
		ATUTestRecorder recorder;
		
		@Before
		public void setup() throws ATUTestRecorderException {
			recorder = new ATUTestRecorder("C:\\Users\\318032\\eclipse-workspace\\Automacao\\target\\recorder", "TestRecorder", false);
			recorder.start();
			
			driver = new ChromeDriver();
			driver.get("http://google.com/");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		
		@Test
		public void testando() {
			driver.findElement(By.name("q")).sendKeys("Globo Esporte", Keys.ENTER);
			String logo = driver.findElement(By.xpath("//a[@href='https://globoesporte.globo.com/']/h3")).getText();
			assertEquals("Globo Esporte", logo);
	}

				
		@After
		public void tearDown() throws ATUTestRecorderException {
			driver.quit();
			recorder.stop();
	}


}
