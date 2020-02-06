package suporte;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

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

}
