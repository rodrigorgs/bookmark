package br.gov.frameworkdemoiselle.sample.bookmark.security;

import br.gov.frameworkdemoiselle.security.Authenticator;
import br.gov.frameworkdemoiselle.security.User;

public class MeuAuthenticator implements Authenticator { 
	private static final long serialVersionUID = 1L;

	@Override 
    public boolean authenticate() { 
        // Escreva aqui seu codigo de autenticacao 
        return true; 
    } 

    @Override 
    public User getUser() { 
        // Escreva aqui seu codigo para retornar o usuario logado 
        return null; 
    } 

    @Override 
    public void unAuthenticate() { 
        // Escreva aqui seu codigo de desautenticacao 
    } 
}