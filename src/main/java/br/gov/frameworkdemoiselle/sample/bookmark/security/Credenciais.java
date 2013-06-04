package br.gov.frameworkdemoiselle.sample.bookmark.security;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

@SessionScoped
public class Credenciais implements Serializable {
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
	public boolean isEmpty() {
		return this.login == null || this.senha == null;
	}
	
	public void clear() {
		this.login = null;
		this.senha = null;
	}
}
