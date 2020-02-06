package allureReports;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import suporte.DSL;
import suporte.Propriedades;


public class Tests extends Propriedades {
	
	private WebDriver driver;
	private DSL dsl;
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Nilton\\\\EstudosNilton\\\\chromedriver\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://google.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		dsl = new DSL();
	}
	
	@Test(priority=1)
	@Story("Usuário adiciona taxa de serviço")
	@Description("Usuário adiciona taxa de serviço com sucesso")
	public void testando() {
		dsl.escreverCampo("q", "Globo Esporte");
		//driver.findElement(By.name("q")).sendKeys("Globo Esporte", Keys.ENTER);
		String logo = driver.findElement(By.xpath("//a[@href='https://globoesporte.globo.com/']/h3")).getText();
		assertEquals("Globo Esporte", logo);
}

	@Test(priority=2)
	@Story("Usuário adiciona taxa de serviço")
	@Description("Usuário adiciona taxa de serviço com sucesso")
	public void testando2() {
		driver.findElement(By.name("q")).sendKeys("Globo Esporte", Keys.ENTER);
		String logo = driver.findElement(By.xpath("//a[@href='https://globoesporte.globo.com/']/h3")).getText();
		assertEquals("Globo Esporte1", logo);
		
		
	System.out.println(logo);
	///Testando mudança
}
	
	@AfterClass
	public void tearDown() {
		if(Propriedades.FECHAR_BROWSER) {
			driver.quit();
		}
	}

}
