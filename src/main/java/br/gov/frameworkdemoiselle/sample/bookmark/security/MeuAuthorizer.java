package br.gov.frameworkdemoiselle.sample.bookmark.security;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.security.Authorizer;

public class MeuAuthorizer implements Authorizer { 
	private static final long serialVersionUID = 1L;

	@Inject
	private Credential credenciais;
	
	@Override 
    public boolean hasRole(String role) { 
		if (credenciais.getLogin() != null && credenciais.getLogin().equals("batman"))
			return true; 
        return false; 
    } 

    @Override 
    public boolean hasPermission(String resource, String operation) { 
        // Escreva aqui seu codigo de verifica��o de permissao 
        return false; 
    } 
}