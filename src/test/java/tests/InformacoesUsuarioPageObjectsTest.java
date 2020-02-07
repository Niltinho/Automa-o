package tests;

import static org.junit.Assert.assertEquals;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.LoginPage;
import suporte.BaseTest;
import suporte.DriverFactory;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InformacoesUsuarioTestData.csv")
public class InformacoesUsuarioPageObjectsTest extends BaseTest{

    @Before
    public void setUp(){
        //navegador = Web.createBrowserStack();
        DriverFactory.getDriver().get("http://www.juliodelima.com.br/taskit");
    }

    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(
            @Param(name="login")String login,
            @Param(name="senha")String senha,
            @Param(name="tipo")String tipo,
            @Param(name="contato")String contato,
            @Param(name="mensagemEsperada")String mensagemEsperada
     ){
        String textoToast = new LoginPage(DriverFactory.getDriver())
                .clickSignin()
                .fazerLogin(login, senha)
                .clicarMe()
                .clicarAbaMoreDataAboutYou()
                .clicarBotaoAddMoreDataAboutYou()
                .adicionarContato(tipo, contato)
                .capturarTextoToast();
        assertEquals(mensagemEsperada, textoToast);
        

    }
}
