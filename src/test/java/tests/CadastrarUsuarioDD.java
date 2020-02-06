package tests;

import static org.testng.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

//import pages.BasePage;
import pages.CampoTreinamentoPage;
import suporte.DriverFactory;

@RunWith(Parameterized.class)
public class CadastrarUsuarioDD {
	
	private CampoTreinamentoPage campoTreinamentoPage;
	//private BasePage basePage;
	
	@Parameter
	public String nome;
	@Parameter(value=1)
	public String sobrenome;
	@Parameter(value=2)
	public String sexo;
	@Parameter(value=3)
	public List<String> comidas;
	@Parameter(value=4)
	public String[] escolaridade;
	@Parameter(value=5)
	public String[] esportes;
	@Parameter(value=6)
	public String msg;
	
	@Parameters
	public static Collection<Object[]> getCollection(){
		return Arrays.asList(new Object[][] {
			{"", "", "", Arrays.asList(), new String[]{}, new String[]{}, "Nome eh obrigatorio"},
			{"Nilton", "", "", Arrays.asList(), new String[]{}, new String[]{}, "Sobrenome eh obrigatorio"},
			{"Nilton", "Correia", "", Arrays.asList(), new String[]{}, new String[]{}, "Sexo eh obrigatorio"},
			{"Nilton", "Correia", "Masculino", Arrays.asList("Carne", "Vegetariano"), new String[]{}, new String[]{}, "Tem certeza que voce eh vegetariano?"},
			{"Nilton", "Correia", "Masculino", Arrays.asList("Carne"), new String[]{}, new String[]{"Karate", "O que eh esporte?"}, "Voce faz esporte ou nao?"}
		});
	}
	
	
	@Before
	public void setUp() {
		//DriverFactory.getDriver().get("file:///C:/Users/Nilton/eclipse-workspace/EstudosNilton/componentes.html");
		DriverFactory.getDriver().get("file:///C:/Users/318032/eclipse-workspace/Automacao/componentes.html");
		campoTreinamentoPage = new CampoTreinamentoPage();
		//basePage = new BasePage(driver);
	}
	
	//@Description("Verificar as regras de negócio se está validando os campos corretamente e cadastrando ou não o usuário")
	//@Story("Deve validar regra de negócio")
	@Test
	public void testCadastrarUsuario() {
		campoTreinamentoPage.setNome(nome)
							.setSobreNome(sobrenome);
		if(sexo.contains("Masculino")) campoTreinamentoPage.setSexoMasculino();
		if(sexo.contains("Feminino")) campoTreinamentoPage.setSexoFeminino();
		if(comidas.contains("Carne")) campoTreinamentoPage.setComidaCarne();
		if(comidas.contains("Frango")) campoTreinamentoPage.setComidaFrango();
		if(comidas.contains("Pizza")) campoTreinamentoPage.setComidaPizza();
		if(comidas.contains("Vegetariano")) campoTreinamentoPage.setComidaVegetariano();
		campoTreinamentoPage.setEscolaridade(escolaridade)
							.setEsporte(esportes)
							.clicarCadastrar();
		
		
		String alert = DriverFactory.getDriver().switchTo().alert().getText();
		System.out.println(alert);
		System.out.println(msg);
		assertEquals(msg, alert);
		
	}
	
	@After
	public void tearDown() {
		DriverFactory.killDriver();
	}

}
