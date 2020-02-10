package suporte;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Inicializar {
    public static final String USERNAME = "niltonluciocorre1";
    public static final String AUTOMATE_KEY = "AukxRPPJYhPqdqsRrHpL";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static WebDriver createChrome() {
        // Abrindo o Navegador
       DriverFactory.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // (Espera Implicita)
       DriverFactory.getDriver().manage().window().maximize();
       
        // Navegando para a pagina do Taskit!
        //driver.get("http://www.juliodelima.com.br/taskit");

        return DriverFactory.getDriver();
    }

    public static WebDriver createBrowserStack(){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "62.0");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1280x800");

        WebDriver navegador = null;

        try {
            navegador = new RemoteWebDriver(new URL(URL), caps);
            navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // (Espera Implicita)

            // Navegando para a pagina do Taskit!
            navegador.get("http://www.juliodelima.com.br/taskit");

        } catch (MalformedURLException e) {
            System.out.println("Houveram problemas na conexao com a URL " + e.getMessage());
        }

        return navegador;

    }
}