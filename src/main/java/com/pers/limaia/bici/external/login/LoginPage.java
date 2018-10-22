package com.pers.limaia.bici.external.login;


import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;

import com.pers.limaia.bici.commons.entities.Pessoa;
import com.pers.limaia.bici.page.TemplatePage;
import com.pers.limaia.mdw.autenticacao.ConnecaoAutenticacao;

public class LoginPage extends TemplatePage{
	
	private static final long serialVersionUID = 1L;
	
	private Pessoa pessoa;
	private String palavraPasse;
	private String utilizador;
	
	private ConnecaoAutenticacao conectAuth;

	private TextField username;
	private PasswordTextField password;
	private Form formLogin;

	private AjaxButton submit;

	public LoginPage() {
		criarForm();
		add(formLogin);
	}

	private void criarForm() {
		formLogin = new Form("form");
		username= new TextField("username",new PropertyModel<Pessoa>(this, "utilizador"));
		password = new PasswordTextField("password",new PropertyModel<String>(this, "palavraPasse"));
		submit = new AjaxButton("submit") {
			private static final long serialVersionUID = 1L;

			protected void onSubmit(AjaxRequestTarget target){
				conectAuth.login(utilizador, palavraPasse);
			}
		};
		
		formLogin.add(username, password,submit);
		
	}

	public void setConecaoAuth(ConnecaoAutenticacao conectAuth) {
		this.conectAuth = conectAuth;		
	}



}
