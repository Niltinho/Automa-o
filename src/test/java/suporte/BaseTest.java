package suporte;

import java.io.File;

import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;

public class BaseTest {
	
	@Rule
	public TestName testName = new TestName();
	
	@After
	public void finaliza() {
				
		String arquivoPrint = "target" + File.separator +"print" + File.separator + testName.getMethodName() + Generator.dataHoraParaArquivo() + ".png";
		Screnshot.tirar(DriverFactory.getDriver(), arquivoPrint);
		
		if(Propriedades.FECHAR_BROWSER) {
		DriverFactory.killDriver();
		}
		
	}

}
