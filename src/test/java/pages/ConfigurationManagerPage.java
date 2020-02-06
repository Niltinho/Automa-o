package pages;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import suporte.DSL;
import suporte.Generator;
import suporte.Propriedades;
import suporte.Screnshot;



@Epic("Inserindo Taxas de Serviços")
@Feature("Inserindo Taxas de Serviços")
@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "Massa_de_Dados_Servicos_teste.csv")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)


public class ConfigurationManagerPage extends Propriedades{
	private WebDriver driver;
	private DSL dsl;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/318032/Desktop/Nilton/Teste/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		driver = new ChromeDriver(options);
		driver.get("http://10.112.68.136:8180/cm-gui/pt.ptinovacao.cm.CM/index.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		dsl = new DSL();
	}

	@Test
	@Story("Usuário adiciona taxa de serviço")
	@Description("Usuário adiciona taxa de serviço com sucesso")
	public void incluirServicos(@Param(name="id") String id, @Param(name="nome") String nome, @Param(name="descricao") String descricao,
								@Param(name="planoTarifario") String planoTarifario,@Param(name="planoTarifarioId") String planoTarifarioId, 
								@Param(name="valor") String valor
								)
	{
		dsl.escreverCampo2("j_username", "m2m");
		dsl.escreverCampo2("j_password", "m2m");
		dsl.clicarBotao2("//input[@value='login']");
		dsl.clicarBotao("x-auto-88");
		dsl.clicarMenu2("x-auto-248");
		dsl.clicarMenu("//div[@class='x-grid3-row  ']//td[1]/div[text()='41201']");
		dsl.clicarMenu("//button[@style='position: relative; width: 77px;']");
		dsl.escreverCampo2("IdentifiableModelexternalID", id);
		dsl.limparCampo2("IdentifiableModelname");
		dsl.limparCampo2("IdentifiableModeldescription");
		dsl.escreverCampo2("IdentifiableModelname", nome);
		dsl.escreverCampo2("IdentifiableModeldescription", descricao);
		dsl.clicarMenu3("ServiceModelserviceAssignSP");
		dsl.apagarCampoAction("//div[@class=' x-small-editor x-toolbar x-toolbar-layout-ct ']//td[@class='x-toolbar-cell']/input[@style='width: 40px; margin-right: 0px;']");
		dsl.escreverCampoAction("//div[@class=' x-small-editor x-toolbar x-toolbar-layout-ct ']//td[@class='x-toolbar-cell']/input[@style='width: 40px; margin-right: 0px;']", "30");
		dsl.confirmarCampoAction("//div[@class=' x-small-editor x-toolbar x-toolbar-layout-ct ']//td[@class='x-toolbar-cell']/input[@style='width: 40px; margin-right: 0px;']");
		dsl.clicarBotaoAction("//div[@class=' x-window']//table[@class='x-grid3-row-table']//div[text()='"+ planoTarifarioId +"']");
		dsl.clicarBotaoAction("//div[@class=' x-window']//button[text()='Associar']");
		dsl.clicarBotao2("//div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']//table[@class='x-btn  x-btn-text-icon ']//button[text()='Editar']");
		dsl.apagarCampoAction("//textarea[@name='DefaultAditionalParametersModeldefaultAditionalParametersDefaultValueFree']");
		dsl.escreverCampoAction("//textarea[@name='DefaultAditionalParametersModeldefaultAditionalParametersDefaultValueFree']", valor);
		dsl.clicarBotaoAction("//div[@class='x-window-bbar']//button[text()='Associar']");
		dsl.clicarBotao2("//div[@class=' x-small-editor x-toolbar wizard-toolbar-panel x-border-panel x-toolbar-layout-ct']//button[text()='seguinte']");
		dsl.esperarElementoAction4("//div[@class='x-window-bbar']//button[text()='Associar']");
		dsl.clicarBotao2("//div[@class=' x-small-editor x-toolbar wizard-toolbar-panel x-border-panel x-toolbar-layout-ct']//button[text()='seguinte']");
		dsl.clicarBotaoAction("//div[@class=' x-window']//button[text()='Sim']");
		dsl.esperaElemento();
		dsl.clicarBotao2("//fieldset[10]/div/fieldset[2]/div/div/div[2]/div[1]/div/table/tbody/tr/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[2]/em/button");
		dsl.apagarCampoAction("//textarea[@name='DefaultAditionalParametersModeldefaultAditionalParametersDefaultValueFree']");
		dsl.escreverCampoAction("//textarea[@name='DefaultAditionalParametersModeldefaultAditionalParametersDefaultValueFree']", valor);
		dsl.clicarBotaoAction("//div[@class=' x-window']//button[text()='Associar']");
		dsl.clicarBotao2("//div[@class=' x-small-editor x-toolbar wizard-toolbar-panel x-border-panel x-toolbar-layout-ct']//button[text()='concluir']");
		dsl.esperarElementoAction2("//span[text()='Nome']");
		if("41201".equalsIgnoreCase(dsl.validarCampo("//div[text()='41201']"))) {
			String arquivoPrint = File.separator +"Users" + File.separator +"318032"+ File.separator + "Desktop" + File.separator + "Nilton" + File.separator + "Teste"+ File.separator +"print"+ File.separator  + id +"_CM_" + Generator.dataHoraParaArquivo() + ".png";
			Screnshot.tirar(driver, arquivoPrint);
		}
		else {
			String arquivoPrint = File.separator +"Users" + File.separator +"318032"+ File.separator + "Desktop" + File.separator + "Nilton" + File.separator + "Teste"+ File.separator +"print"+ File.separator  + id + "_CM_ERROR_" + Generator.dataHoraParaArquivo() + ".png";
			Screnshot.tirar(driver, arquivoPrint);
		}
		assertEquals("41201", dsl.validarCampo("//div[text()='41201']"));
	}

	@After
	public void tearDown() {
		
		if(Propriedades.FECHAR_BROWSER) {
			driver.quit();
		}
	}
}
