package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Inicializar {
    public static final String USERNAME = "niltonluciocorre1";
    public static final String AUTOMATE_KEY = "AukxRPPJYhPqdqsRrHpL";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static WebDriver createChrome() {
        // Abrindo o Navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nilton\\EstudosNilton\\chromedriver\\chromedriver.exe");
       WebDriver driver = new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // (Espera Implicita)
       driver.manage().window().maximize();
       
        // Navegando para a pagina do Taskit!
        //driver.get("http://www.juliodelima.com.br/taskit");

        return driver;
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