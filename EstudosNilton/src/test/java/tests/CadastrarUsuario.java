package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.CampoTreinamentoPage;
import suporte.Inicializar;

public class CadastrarUsuario {
	
	private WebDriver driver;
	private CampoTreinamentoPage campoTreinamentoPage;
	private BasePage basePage;
	
	
	@BeforeClass
	public void setUp() {
		driver = Inicializar.createChrome();
		driver.get("file:///C:/Users/Nilton/eclipse-workspace/EstudosNilton/componentes.html");
		campoTreinamentoPage = new CampoTreinamentoPage(driver);
		basePage = new BasePage(driver);
	}
	
	@Test
	public void testCadastrarUsuario() {
		campoTreinamentoPage
			.setNome("Nilton")
			.setSobreNome("Lucio Correia")
			.setSexoMasculino()
			.setComidaCarne()
			.setComidaFrango()
			.setEscolaridade("Superior")
			.setEsporte("Futebol", "Corrida");
		basePage
			.capturarTextoToast();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
