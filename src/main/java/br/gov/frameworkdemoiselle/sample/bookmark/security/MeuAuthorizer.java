package br.gov.frameworkdemoiselle.sample.bookmark.security;

import br.gov.frameworkdemoiselle.security.Authorizer;

public class MeuAuthorizer implements Authorizer { 
	private static final long serialVersionUID = 1L;

	@Override 
    public boolean hasRole(String role) { 
        // Escreva aqui seu codigo de verificacao do papel 
        return false; 
    } 

    @Override 
    public boolean hasPermission(String resource, String operation) { 
        // Escreva aqui seu codigo de verifica��o de permissao 
        return false; 
    } 
}