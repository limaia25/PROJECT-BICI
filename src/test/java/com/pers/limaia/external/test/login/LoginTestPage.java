package com.pers.limaia.external.test.login;

import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.util.tester.FormTester;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.pers.limaia.bici.aplication.BiciWebApplication;
import com.pers.limaia.bici.commons.entities.Pessoa;
import com.pers.limaia.bici.external.login.LoginPage;
import com.pers.limaia.bici.page.HomePage;
import com.pers.limaia.mdw.autenticacao.ConnecaoAutenticacao;

public class LoginTestPage {
	
	private WicketTester tester;

	@Before
	public void setUp()
	{
		tester = new WicketTester(new BiciWebApplication());
		
	}
	
	@Test
	public void loginPagina() {
		tester.startPage(LoginPage.class);
		tester.assertRenderedPage(LoginPage.class);
		tester.assertComponent("form", Form.class);
		tester.assertComponent("form:username", TextField.class);
		tester.assertComponent("form:submit", AjaxButton.class);

	}
	
	@Test
	public void loginPaginaComUserPass() {
		LoginPage loginPage = new LoginPage();

		
		ConnecaoAutenticacao conectAuth = Mockito.mock(ConnecaoAutenticacao.class);
		loginPage.setConecaoAuth(conectAuth);
		tester.startPage(loginPage);
		
		
		FormTester formTester = tester.newFormTester("form");
		formTester.setValue("username", "liliana.maia");
		formTester.setValue("password", "passwordQualquer");		
		formTester.submit("submit");
		
		Mockito.verify(conectAuth).login("liliana.maia","passwordQualquer");
		
	
	}

}
