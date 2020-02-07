package suites;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import suporte.DriverFactory;
import tests.CadastrarUsuario;
import tests.CadastrarUsuarioDD;
import tests.InformacoesUsuarioPageObjectsTest;

@RunWith(Suite.class)
@SuiteClasses({
	CadastrarUsuario.class,
	CadastrarUsuarioDD.class,
	InformacoesUsuarioPageObjectsTest.class
})
public class SuiteTeste {
	@AfterClass
	public static void finaliza() {
		DriverFactory.killDriver();
	}

}
