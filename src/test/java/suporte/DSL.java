package suporte;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DSL {
	private WebDriver driver;
	
	public DSL(WebDriver driver) {
		this.driver = driver;
	}
	
	/////// Campo ///////////////
	public void escreverCampo(String id_campo, String texto) {
		driver.findElement(By.id(id_campo)).clear();
		driver.findElement(By.id(id_campo)).sendKeys(texto);
	}
	
	public void escreverCampo3(String id_campo3, String texto) {
		driver.findElement(By.name(id_campo3)).sendKeys(texto, Keys.ENTER);
	}
	
	public void escreverCampo2(String name_campo, String texto) {
		driver.findElement(By.name(name_campo)).sendKeys(texto);
	}
	public void limparCampo(String id_campo) {
		driver.findElement(By.id(id_campo)).clear();
	}
	public void limparCampo2(String id_campo) {
		driver.findElement(By.name(id_campo)).clear();
	}
	public void confirmarCampo(String id_campo) {
		driver.findElement(By.id(id_campo)).sendKeys(Keys.ENTER);;
	}
	public String obterValorCampo(String id_campo) {
		return driver.findElement(By.id(id_campo)).getText();
	}
	public String obterValorCampo_2(String id_campo2) {
		return driver.findElement(By.xpath(id_campo2)).getText();
	}
	public String obterValorCampo_3(String id_campo3) {
		return driver.findElement(By.xpath(id_campo3)).getTagName();
	}
	public String validarCampo(String validaCampo) {
		return driver.findElement(By.xpath(validaCampo)).getText();
	}
	
	public boolean validarCampo_2(String validaCampo_2) {
		return driver.findElement(By.xpath(validaCampo_2)).isEnabled();
	}
	
	public void escreverCampoAction(String xpath_campo, String valor){
		Actions act = new Actions(driver);
		WebElement escreverCampo = driver.findElement(By.xpath(xpath_campo));
		act.sendKeys(escreverCampo, valor).perform();
	}
	public void apagarCampoAction(String xpath_campo){
		Actions act = new Actions(driver);
		WebElement apagarCampo = driver.findElement(By.xpath(xpath_campo));
		act.sendKeys(apagarCampo, "").perform();
	}
	public void confirmarCampoAction(String xpath_campo){
		Actions act = new Actions(driver);
		WebElement escreverCampo = driver.findElement(By.xpath(xpath_campo));
		act.sendKeys(escreverCampo, Keys.ENTER).perform();
	}
	
	
	//////////////// Radio Button ///////////////
	public boolean validarRadio(String validaRadio) {
		return driver.findElement(By.xpath(validaRadio)).isSelected();
	}
	
	public void selecionarRadio2(String by) {
		
	}
	
	public void selecionarRadio(String id_radio) {
		driver.findElement(By.id(id_radio)).click();
	}
	
	
	////////////////Checkbox ///////////////
	public boolean validarCheckbox(String validaCheckbox) {
	return driver.findElement(By.xpath(validaCheckbox)).isSelected();
	}
	
	public void selecionarCheckbox2(String by) {
	
	}
	
	public void selecionarCheckbox(String id_checkbox) {
	driver.findElement(By.id(id_checkbox)).click();
	}
		
	
	
	//////////// Botão ////////////
	public void clicarBotao(String id_botao){
		driver.findElement(By.id(id_botao)).click();
	}
	public void clicarBotao2(String xpath_botao){
		driver.findElement(By.xpath(xpath_botao)).click();
	}
	public void clicarBotaoAction(String xpath_botao){
		Actions act = new Actions(driver);
		WebElement clique = driver.findElement(By.xpath(xpath_botao));
		act.click(clique).perform();
	}
	public void clicarBotaoAction2(String xpath_botao){
		Actions act = new Actions(driver);
		WebElement clique = driver.findElement(By.xpath(xpath_botao));
		act.moveToElement(clique).click().build().perform();
	}
	
	
	////////// Clicar Menu/Aba ////////////////
	public void clicarMenu(String xpath_menu){
		driver.findElement(By.xpath(xpath_menu)).click();
	}
	public void clicarMenu2(String id_menu){
		driver.findElement(By.id(id_menu)).click();
	}
	public void clicarMenu3(String id_menu){
		driver.findElement(By.name(id_menu)).click();
	}
	
	
	/////// Interagir Janela //////////////
	public void trocarJanela(String id_frame) {
		WebElement fr = driver.findElement(By.name(id_frame));
		driver.switchTo().frame(fr);
	}
	public void trocarJanela2(String id_frame) {
		WebElement fr = driver.findElement(By.id(id_frame));
		driver.switchTo().frame(fr);
	}
	
	public void descerJanela() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scrollBy(0,500)", "");
	}
	
	
	
	//////// Espera Explícita ///////////////
	public void esperarElementoAction(String xpath_elemento) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath_elemento)));
	}
	public void esperarElementoAction2(String xpath_elemento) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath_elemento)));
	}
	public void esperarElementoAction3(String xpath_elemento) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath_elemento)));
	}
	public void esperarElementoAction4(String xpath_elemento) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath_elemento)));
	}
	
	
	//////// Combo //////////////
	public void selecionarCombo(String id, String valor) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}
	
	public void obterValorCombo(String id) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		combo.getFirstSelectedOption().getText();
	}
	
	
	
	//// Prática a não usar ////
	public void esperaElemento() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
