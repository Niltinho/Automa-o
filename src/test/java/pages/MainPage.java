package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    protected WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public String capturarTextoToast(){
        WebElement mensagemPop = driver.findElement(By.id("toast-container"));
        return mensagemPop.getText();
    }
    
    public String capturarCadastro() {
    	WebElement mensagemCadastro = driver.findElement(By.id("resultado"));
    	return mensagemCadastro.getText();
    }
}
