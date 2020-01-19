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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import suporte.Generator;
import suporte.Screnshot;
import suporte.Inicializar;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InformacoesUsuarioTest.csv")



public class informacoesUsuarioTest {
   private WebDriver driver;

   @Rule
   public TestName test = new TestName();

    @Before
    public void setUp (){

        driver = Inicializar.createChrome();
        // Clicar no link que possui o texto "Sign in"
        driver.findElement(By.linkText("Sign in")).click();

        // Identificando o formulário Login com id "signinbox"
        WebElement formularioSignInBox = driver.findElement(By.id("signinbox"));

        // Digitar no campo com name "login" que está dentro do formulário de id "signinbox" o texto "julio0001"
        formularioSignInBox.findElement(By.name("login")).sendKeys("julio0001");

        // Digitar no campo com name "password" que está dentro do formulário de id "signinbox" o texto "123456"
        formularioSignInBox.findElement(By.name("password")).sendKeys("123456");

        //Clicar no link com o texto "SIGN IN"
        driver.findElement(By.linkText("SIGN IN")).click();

        // Validar que dentro do elemento com class "me" está o texto "Hi, Julio"
        //WebElement me = navegador.findElement(By.className("me"));
        //String textoNoElementoMe = me.getText();
        //assertEquals("Hi, Julio", textoNoElementoMe);

        // Clicar em um link que possui a class "me"
        driver.findElement(By.className("me")).click();

        // Clicar em um link que possui o texto "MORE DATA ABOUT YOU"
        driver.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
   }
    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(@Param(name="tipo")String tipo, @Param(name="contato")String contato, @Param(name="mensagem")String mensagemEsperada){
        // Clicar no botão através do seu xpath //button[@data-target="addmoredata"]
        driver.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

        // Identificar a popup onde está o formulário de id "addmoredata"
        WebElement popupAddMoreData = driver.findElement(By.id("addmoredata"));

        // Na combo de name "type" escolher a opção "Phone"
        WebElement campoType = popupAddMoreData.findElement(By.name("type"));
        new Select(campoType).selectByVisibleText(tipo);

        // No campo de name "contact", digitar "+551144445555"
        popupAddMoreData.findElement(By.name("contact")).sendKeys(contato);

        // Clicar no link de text "SAVE" que está na popup
        popupAddMoreData.findElement(By.linkText("SAVE")).click();

        // Na mensagem de id "toast-container" validar que o text é "Your contact has been added!"
        WebElement mensagemPop = driver.findElement(By.id("toast-container"));
        String mensagem = mensagemPop.getText();
        assertEquals(mensagemEsperada, mensagem);
        }

   @Test
   public void removerUmContatoDeUmUsuario (){
        // Clicar no elemento pelo seu xpath //span[text()='+551144445555']/following-sibling::a (remover número)
       driver.findElement(By.xpath("//span[text()=\"+551144445555\"]/following-sibling::a")).click();

       // Confirmar a janela javascript
       driver.switchTo().alert().accept();

       // Validar a mensagem apresenta foi "Rest in peace, dear phone!"
       WebElement mensagemPop = driver.findElement(By.id("toast-container"));
       String mensagem = mensagemPop.getText();
       assertEquals("Rest in peace, dear phone!", mensagem);

       // Tirar um print da tela
       String screenShotArquivo = "C:\\Users\\Nilton\\evidencias\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
       Screnshot.tirar(driver, screenShotArquivo);

       // Aguardar até 10 segundos para que a janela desapareça (Espera Explícita)
       WebDriverWait aguardar = new WebDriverWait(driver, 10);
       aguardar.until(ExpectedConditions.stalenessOf(mensagemPop));

       // Clicar no link com o texto "Logout"
       driver.findElement(By.linkText("Logout")).click();

   }

   @After
   public void tearDown (){
       // Fechar o navegador
       driver.quit();
   }

}
