package br.gov.frameworkdemoiselle.sample.bookmark.security;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.security.Authenticator;
import br.gov.frameworkdemoiselle.security.User;

public class MeuAuthenticator implements Authenticator { 
	private static final long serialVersionUID = 1L;

	@Inject
	private Credential credential;
	
	@Override 
    public boolean authenticate() { 
        // Escreva aqui seu codigo de autenticacao 
        return true; 
    } 

    @Override 
    public User getUser() {
    	return new User() {
			
			@Override
			public void setAttribute(Object key, Object value) {
			}
			
			@Override
			public String getId() {
				return credential.getLogin();
			}
			
			@Override
			public Object getAttribute(Object key) {
				// TODO Auto-generated method stub
				return null;
			}
		};
    } 

    @Override 
    public void unAuthenticate() { 
        // Escreva aqui seu codigo de desautenticacao 
    } 
}