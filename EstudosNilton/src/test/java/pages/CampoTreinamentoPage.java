package pages;

import org.openqa.selenium.WebDriver;

import suporte.DSL;

public class CampoTreinamentoPage {
	
	private DSL dsl;
	
	public CampoTreinamentoPage(WebDriver driver) {
		dsl = new DSL(driver);
	}
	
	public CampoTreinamentoPage setNome(String nome) {
		dsl.escreverCampo("elementosForm:nome", nome);
		return this;

	}
	public CampoTreinamentoPage setSobreNome(String sobreNome) {
		dsl.escreverCampo("elementosForm:sobrenome", sobreNome);
		return this;
	
	}
	
	public CampoTreinamentoPage setSexoMasculino() {
		dsl.selecionarRadio("elementosForm:sexo:0");
		return this;
	}
	
	public CampoTreinamentoPage setSexoFeminino() {
		dsl.selecionarRadio("elementosForm:sexo:1");
		return this;
	}
	
	public CampoTreinamentoPage setComidaCarne() {
		dsl.selecionarCheckbox("elementosForm:comidaFavorita:0");
		return this;
	}
	
	public CampoTreinamentoPage setComidaFrango() {
		dsl.selecionarCheckbox("elementosForm:comidaFavorita:1");
		return this;
	}
	
	public CampoTreinamentoPage setComidaPizza() {
		dsl.selecionarCheckbox("elementosForm:comidaFavorita:2");
		return this;
	}
	
	public CampoTreinamentoPage setComidaVegetariano() {
		dsl.selecionarCheckbox("elementosForm:comidaFavorita:3");
		return this;
	}
	
	public CampoTreinamentoPage setEscolaridade(String... valores) {
		for(String valor: valores)
		dsl.selecionarCombo("elementosForm:escolaridade", valor);
		return this;
	}
	
	public CampoTreinamentoPage setEsporte(String... valores) {
		for(String valor: valores)
		dsl.selecionarCombo("elementosForm:esportes", valor);
		return this;
	}
}
