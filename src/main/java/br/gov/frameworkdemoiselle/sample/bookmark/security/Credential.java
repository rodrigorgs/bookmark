package br.gov.frameworkdemoiselle.sample.bookmark.security;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@SessionScoped
public class Credential implements Serializable { 
	private static final long serialVersionUID = 1L;

	private String login; 

    private String senha;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	} 
}