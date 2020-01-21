package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
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
		//driver.get("file:///C:/Users/Nilton/eclipse-workspace/EstudosNilton/componentes.html");
		driver.get("file:///C:/Users/318032/eclipse-workspace/Automacao/componentes.html");
		campoTreinamentoPage = new CampoTreinamentoPage(driver);
		basePage = new BasePage(driver);
	}
	
	@Description("Verificar que cadastro foi realizado com sucesso e as informações cadastradas estão corretas")
	@Story("Cadastrar usuário com sucesso")
	@Test
	public void testCadastrarUsuario() {
		campoTreinamentoPage
			.setNome("Nilton")
			.setSobreNome("Lucio Correia")
			.setSexoMasculino()
			.setComidaCarne()
			.setComidaFrango()
			.setEscolaridade("Superior")
			.setEsporte("Futebol", "Corrida")
			.clicarCadastrar();
		basePage
			.capturarCadastro();
		
		System.out.println(basePage.capturarCadastro());
		assertEquals("Cadastrado!\nNome: Nilton\nSobrenome: Lucio Correia\nSexo: Masculino\nComida: Carne Frango\nEscolaridade: superior\nEsportes: Futebol Corrida\nSugestoes:", basePage.capturarCadastro());
		
	}
	
	@Description("Verificar que cadastro foi realizado com sucesso e as informações cadastradas estão incorretas")
	@Story("Cadastrar usuário com sucesso")
	@Test
	public void testCadastrarUsuario2() {
		campoTreinamentoPage
			.setNome("Nilton")
			.setSobreNome("Lucio Correia")
			.setSexoMasculino()
			.setComidaCarne()
			.setComidaFrango()
			.setEscolaridade("Superior")
			.setEsporte("Futebol", "Corrida")
			.clicarCadastrar();
		basePage
			.capturarCadastro();
		
		System.out.println(basePage.capturarCadastro());
		assertEquals("Cadastrado!\nNome: Nilton\nSobrenome: Lucio Correia\nSexo: Masculino\nComida: Carne Frango\nEscolaridade: superior\nEsportes: Futebol Corrida\nSugestoes:!", basePage.capturarCadastro());
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
