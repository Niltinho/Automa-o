package suporte;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
	private static WebDriver driver;
	
	private DriverFactory() {}
	
	public static WebDriver getDriver() {
		if(driver==null) {
			driver = Inicializar.createChrome();
		}
		return driver;
	}
	
	public static void killDriver() {
		if(driver!=null) {
			driver.quit();
			driver = null;
		}
	}
	
}
