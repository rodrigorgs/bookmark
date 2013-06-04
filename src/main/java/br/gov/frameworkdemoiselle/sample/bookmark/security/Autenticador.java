package br.gov.frameworkdemoiselle.sample.bookmark.security;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.security.Authenticator;
import br.gov.frameworkdemoiselle.security.User;

public class Autenticador implements Authenticator {
	private static final long serialVersionUID = 1L;

	@Inject
	private Credenciais credenciais;
	
	@Override
	public boolean authenticate() {
		return true;
	}

	@Override
	public void unAuthenticate() {
		credenciais.clear();
	}

	@Override
	public User getUser() {
		return new User() {
			
			@Override
			public void setAttribute(Object key, Object value) {
			}
			
			@Override
			public String getId() {
				return credenciais.getLogin();
			}
			
			@Override
			public Object getAttribute(Object key) {
				return null;
			}
		};
	}

}
