package tests;

import static org.junit.Assert.assertEquals;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import suporte.DriverFactory;
import suporte.Generator;
import suporte.Screnshot;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InformacoesUsuarioTest.csv")
public class informacoesUsuarioTest {

   @Rule
   public TestName test = new TestName();

    @Before
    public void setUp (){

        // Clicar no link que possui o texto "Sign in"
        DriverFactory.getDriver().findElement(By.linkText("Sign in")).click();

        // Identificando o formulário Login com id "signinbox"
        WebElement formularioSignInBox = DriverFactory.getDriver().findElement(By.id("signinbox"));

        // Digitar no campo com name "login" que está dentro do formulário de id "signinbox" o texto "julio0001"
        formularioSignInBox.findElement(By.name("login")).sendKeys("julio0001");

        // Digitar no campo com name "password" que está dentro do formulário de id "signinbox" o texto "123456"
        formularioSignInBox.findElement(By.name("password")).sendKeys("123456");

        //Clicar no link com o texto "SIGN IN"
        DriverFactory.getDriver().findElement(By.linkText("SIGN IN")).click();

        // Validar que dentro do elemento com class "me" está o texto "Hi, Julio"
        //WebElement me = navegador.findElement(By.className("me"));
        //String textoNoElementoMe = me.getText();
        //assertEquals("Hi, Julio", textoNoElementoMe);

        // Clicar em um link que possui a class "me"
        DriverFactory.getDriver().findElement(By.className("me")).click();

        // Clicar em um link que possui o texto "MORE DATA ABOUT YOU"
        DriverFactory.getDriver().findElement(By.linkText("MORE DATA ABOUT YOU")).click();
   }
    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(@Param(name="tipo")String tipo, @Param(name="contato")String contato, @Param(name="mensagem")String mensagemEsperada){
        // Clicar no botão através do seu xpath //button[@data-target="addmoredata"]
    	DriverFactory.getDriver().findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

        // Identificar a popup onde está o formulário de id "addmoredata"
        WebElement popupAddMoreData = DriverFactory.getDriver().findElement(By.id("addmoredata"));

        // Na combo de name "type" escolher a opção "Phone"
        WebElement campoType = popupAddMoreData.findElement(By.name("type"));
        new Select(campoType).selectByVisibleText(tipo);

        // No campo de name "contact", digitar "+551144445555"
        popupAddMoreData.findElement(By.name("contact")).sendKeys(contato);

        // Clicar no link de text "SAVE" que está na popup
        popupAddMoreData.findElement(By.linkText("SAVE")).click();

        // Na mensagem de id "toast-container" validar que o text é "Your contact has been added!"
        WebElement mensagemPop = DriverFactory.getDriver().findElement(By.id("toast-container"));
        String mensagem = mensagemPop.getText();
        assertEquals(mensagemEsperada, mensagem);
        }

   @Test
   public void removerUmContatoDeUmUsuario (){
        // Clicar no elemento pelo seu xpath //span[text()='+551144445555']/following-sibling::a (remover número)
	   DriverFactory.getDriver().findElement(By.xpath("//span[text()=\"+551144445555\"]/following-sibling::a")).click();

       // Confirmar a janela javascript
	   DriverFactory.getDriver().switchTo().alert().accept();

       // Validar a mensagem apresenta foi "Rest in peace, dear phone!"
       WebElement mensagemPop = DriverFactory.getDriver().findElement(By.id("toast-container"));
       String mensagem = mensagemPop.getText();
       assertEquals("Rest in peace, dear phone!", mensagem);

       // Tirar um print da tela
       String screenShotArquivo = "C:\\Users\\Nilton\\evidencias\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
       Screnshot.tirar(DriverFactory.getDriver(), screenShotArquivo);

       // Aguardar até 10 segundos para que a janela desapareça (Espera Explícita)
       WebDriverWait aguardar = new WebDriverWait(DriverFactory.getDriver(), 10);
       aguardar.until(ExpectedConditions.stalenessOf(mensagemPop));

       // Clicar no link com o texto "Logout"
       DriverFactory.getDriver().findElement(By.linkText("Logout")).click();

   }

   @After
   public void tearDown (){
       // Fechar o navegador
       DriverFactory.killDriver();
   }

}
