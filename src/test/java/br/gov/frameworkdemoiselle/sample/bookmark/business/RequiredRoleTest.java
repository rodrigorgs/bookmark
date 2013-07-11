package br.gov.frameworkdemoiselle.sample.bookmark.business;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;
import br.gov.frameworkdemoiselle.security.Authenticator;
import br.gov.frameworkdemoiselle.security.Authorizer;
import br.gov.frameworkdemoiselle.security.NotLoggedInException;
import br.gov.frameworkdemoiselle.security.RequiredRole;
import br.gov.frameworkdemoiselle.security.User;

class Autenticador implements Authenticator {
	@Override
	public boolean authenticate() {
		return true;
	}

	@Override
	public void unAuthenticate() {
	}

	@Override
	public User getUser() {
		return null;
	}
}

class Autorizador implements Authorizer {
	@Override
	public boolean hasRole(String role) {
		return false;
	}
	@Override
	public boolean hasPermission(String resource, String operation) {
		return false;
	}
}

@RequiredRole("super-heroi")
class Negocio {
	@Inject
	private Logger logger;
	
	@PostConstruct
	public void postConstruct() {
		logger.info("***** postConstrucT() " + this);
	}
	
	@RequiredRole("super-heroi")
	public void voa() {
		logger.info("***** voa() " + this);
	}
	
	public void correEVoa() {
		logger.info("***** correEVoa() " + this);
		voa();
	}
}

@RunWith(DemoiselleRunner.class)
public class RequiredRoleTest {
	@Inject
	private Negocio negocio;
	
	@Test(expected = NotLoggedInException.class)
	public void testeVoa() {
		negocio.voa();
	}
	
	@Test(expected = NotLoggedInException.class)
	public void testeCorreEVoa() {
		negocio.correEVoa();
	}
}
