package com.pers.limaia.bici.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;

import com.pers.limaia.bici.commons.entities.Pessoa;

public class HomePage extends TemplatePage {
	private Pessoa pessoaRegisto;
	private String valorApresentar;

	public HomePage() {
		setPessoaRegisto(new Pessoa());
		Form<Void> form = new Form<Void>("form") {
			private static final long serialVersionUID = 1L;

			protected void onSubmit() {
				setValorApresentar(getPessoaRegisto().getNome());
			}
		};

		Button gravar = new Button("gravar");
		form.add(gravar);
		
		TextField<String> nomeCampo = new TextField<>("nomeCampo", new PropertyModel<String>(pessoaRegisto, "nome"));
		form.add(nomeCampo);

		TextField<String> mostrarCampo = new TextField<>("mostrarCampo",
				new PropertyModel<String>(this, "valorApresentar"));
		mostrarCampo.setEnabled(false);
		form.add(mostrarCampo);

		add(form);
	}

	public Pessoa getPessoaRegisto() {
		return pessoaRegisto;
	}

	public void setPessoaRegisto(Pessoa pessoaRegisto) {
		this.pessoaRegisto = pessoaRegisto;
	}

	public String getValorApresentar() {
		return valorApresentar;
	}

	public void setValorApresentar(String valorApresentar) {
		this.valorApresentar = valorApresentar;
	}
}
