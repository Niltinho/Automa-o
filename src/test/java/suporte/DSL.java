package suporte;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DSL {

	/////// Campo ///////////////
	
	public void escreverCampo(By by, String texto) {
		DriverFactory.getDriver().findElement(by).sendKeys(texto, Keys.ENTER);
	}

	
	public void escreverCampo(String id_campo, String texto) {
		DriverFactory.getDriver().findElement(By.id(id_campo)).clear();
		DriverFactory.getDriver().findElement(By.id(id_campo)).sendKeys(texto);
	}
	
	public void escreverCampo2(String name_campo, String texto) {
		DriverFactory.getDriver().findElement(By.name(name_campo)).sendKeys(texto);
	}
	public void limparCampo(String id_campo) {
		DriverFactory.getDriver().findElement(By.id(id_campo)).clear();
	}
	public void limparCampo2(String id_campo) {
		DriverFactory.getDriver().findElement(By.name(id_campo)).clear();
	}
	public void confirmarCampo(String id_campo) {
		DriverFactory.getDriver().findElement(By.id(id_campo)).sendKeys(Keys.ENTER);;
	}
	public String obterValorCampo(String id_campo) {
		return DriverFactory.getDriver().findElement(By.id(id_campo)).getText();
	}
	public String obterValorCampo_2(String id_campo2) {
		return DriverFactory.getDriver().findElement(By.xpath(id_campo2)).getText();
	}
	public String obterValorCampo_3(String id_campo3) {
		return DriverFactory.getDriver().findElement(By.xpath(id_campo3)).getTagName();
	}
	public String validarCampo(String validaCampo) {
		return DriverFactory.getDriver().findElement(By.xpath(validaCampo)).getText();
	}
	
	public boolean validarCampo_2(String validaCampo_2) {
		return DriverFactory.getDriver().findElement(By.xpath(validaCampo_2)).isEnabled();
	}
	
	public void escreverCampoAction(String xpath_campo, String valor){
		Actions act = new Actions(DriverFactory.getDriver());
		WebElement escreverCampo = DriverFactory.getDriver().findElement(By.xpath(xpath_campo));
		act.sendKeys(escreverCampo, valor).perform();
	}
	public void apagarCampoAction(String xpath_campo){
		Actions act = new Actions(DriverFactory.getDriver());
		WebElement apagarCampo = DriverFactory.getDriver().findElement(By.xpath(xpath_campo));
		act.sendKeys(apagarCampo, "").perform();
	}
	public void confirmarCampoAction(String xpath_campo){
		Actions act = new Actions(DriverFactory.getDriver());
		WebElement escreverCampo = DriverFactory.getDriver().findElement(By.xpath(xpath_campo));
		act.sendKeys(escreverCampo, Keys.ENTER).perform();
	}
	
	
	//////////////// Radio Button ///////////////
	public boolean validarRadio(String validaRadio) {
		return DriverFactory.getDriver().findElement(By.xpath(validaRadio)).isSelected();
	}
	
	public void selecionarRadio2(String by) {
		
	}
	
	public void selecionarRadio(String id_radio) {
		DriverFactory.getDriver().findElement(By.id(id_radio)).click();
	}
	
	
	////////////////Checkbox ///////////////
	public boolean validarCheckbox(String validaCheckbox) {
	return DriverFactory.getDriver().findElement(By.xpath(validaCheckbox)).isSelected();
	}
	
	public void selecionarCheckbox2(String by) {
	
	}
	
	public void selecionarCheckbox(String id_checkbox) {
	DriverFactory.getDriver().findElement(By.id(id_checkbox)).click();
	}
		
	
	
	//////////// Botão ////////////
	public void clicarBotao(String id_botao){
		DriverFactory.getDriver().findElement(By.id(id_botao)).click();
	}
	public void clicarBotao2(String xpath_botao){
		DriverFactory.getDriver().findElement(By.xpath(xpath_botao)).click();
	}
	public void clicarBotaoAction(String xpath_botao){
		Actions act = new Actions(DriverFactory.getDriver());
		WebElement clique = DriverFactory.getDriver().findElement(By.xpath(xpath_botao));
		act.click(clique).perform();
	}
	public void clicarBotaoAction2(String xpath_botao){
		Actions act = new Actions(DriverFactory.getDriver());
		WebElement clique = DriverFactory.getDriver().findElement(By.xpath(xpath_botao));
		act.moveToElement(clique).click().build().perform();
	}
	
	
	////////// Clicar Menu/Aba ////////////////
	public void clicarMenu(String xpath_menu){
		DriverFactory.getDriver().findElement(By.xpath(xpath_menu)).click();
	}
	public void clicarMenu2(String id_menu){
		DriverFactory.getDriver().findElement(By.id(id_menu)).click();
	}
	public void clicarMenu3(String id_menu){
		DriverFactory.getDriver().findElement(By.name(id_menu)).click();
	}
	
	
	/////// Interagir Janela //////////////
	public void trocarJanela(String id_frame) {
		WebElement fr = DriverFactory.getDriver().findElement(By.name(id_frame));
		DriverFactory.getDriver().switchTo().frame(fr);
	}
	public void trocarJanela2(String id_frame) {
		WebElement fr = DriverFactory.getDriver().findElement(By.id(id_frame));
		DriverFactory.getDriver().switchTo().frame(fr);
	}
	
	public void descerJanela() {
		JavascriptExecutor jse = (JavascriptExecutor) DriverFactory.getDriver();
		jse.executeScript("scrollBy(0,500)", "");
	}
	
	
	
	//////// Espera Explícita ///////////////
	public void esperarElementoAction(String xpath_elemento) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath_elemento)));
	}
	public void esperarElementoAction2(String xpath_elemento) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath_elemento)));
	}
	public void esperarElementoAction3(String xpath_elemento) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 50);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath_elemento)));
	}
	public void esperarElementoAction4(String xpath_elemento) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath_elemento)));
	}
	
	
	//////// Combo //////////////
	public void selecionarCombo(String id, String valor) {
		WebElement element = DriverFactory.getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}
	
	public void obterValorCombo(String id) {
		WebElement element = DriverFactory.getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.getFirstSelectedOption().getText();
	}
	
	
	/// Alert
	
	public void alertaAceitar() {
		Alert alert = DriverFactory.getDriver().switchTo().alert();
		alert.accept();
	}
	
	public String alertaObterTexto() {
		Alert alert = DriverFactory.getDriver().switchTo().alert();
		return alert.getText();
	}
	
	public String alertaObterTextoEAceitar() {
		Alert alert = DriverFactory.getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.accept();
		return valor;
		
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
