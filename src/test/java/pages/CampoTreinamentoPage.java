package pages;

import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;
import suporte.DSL;

public class CampoTreinamentoPage {
	
	private DSL dsl;
	
	public CampoTreinamentoPage(WebDriver driver) {
		dsl = new DSL(driver);
	}
	
	@Step("Informar o primeiro nome do usuário")
	public CampoTreinamentoPage setNome(String nome) {
		dsl.escreverCampo("elementosForm:nome", nome);
		return this;

	}
	
	@Step("Informar o sobrenome do usuário")
	public CampoTreinamentoPage setSobreNome(String sobreNome) {
		dsl.escreverCampo("elementosForm:sobrenome", sobreNome);
		return this;
	
	}
	
	@Step("Selecionar o sexo Masculino")
	public CampoTreinamentoPage setSexoMasculino() {
		dsl.selecionarRadio("elementosForm:sexo:0");
		return this;
	}
	
	@Step("Selecionar o sexo Feminino")
	public CampoTreinamentoPage setSexoFeminino() {
		dsl.selecionarRadio("elementosForm:sexo:1");
		return this;
	}
	
	@Step("Selecionar a comida carne")
	public CampoTreinamentoPage setComidaCarne() {
		dsl.selecionarCheckbox("elementosForm:comidaFavorita:0");
		return this;
	}
	
	@Step("Selecionar a comida frango")
	public CampoTreinamentoPage setComidaFrango() {
		dsl.selecionarCheckbox("elementosForm:comidaFavorita:1");
		return this;
	}
	
	@Step("Selecionar a comida pizza")
	public CampoTreinamentoPage setComidaPizza() {
		dsl.selecionarCheckbox("elementosForm:comidaFavorita:2");
		return this;
	}
	
	@Step("Selecionar a comida vegetariano")
	public CampoTreinamentoPage setComidaVegetariano() {
		dsl.selecionarCheckbox("elementosForm:comidaFavorita:3");
		return this;
	}
	
	@Step("Selecionar a comida carne")
	public CampoTreinamentoPage setEscolaridade(String... valores) {
		for(String valor: valores)
		dsl.selecionarCombo("elementosForm:escolaridade", valor);
		return this;
	}
	
	@Step("Selecionar os esportes favoritos")
	public CampoTreinamentoPage setEsporte(String... valores) {
		for(String valor: valores)
		dsl.selecionarCombo("elementosForm:esportes", valor);
		return this;
	}
	
	@Step("Clicar no botão Cadastrar")
	public CampoTreinamentoPage clicarCadastrar() {
		dsl.clicarBotao("elementosForm:cadastrar");
		return this;
	}
}
