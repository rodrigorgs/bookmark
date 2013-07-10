package br.gov.frameworkdemoiselle.sample.bookmark.business;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;
import br.gov.frameworkdemoiselle.security.AuthorizationException;
import br.gov.frameworkdemoiselle.security.RequiredRole;

class Negocio {
	@Inject
	private Logger logger;
	
	@RequiredRole("super-heroi")
	public void voa() {
		logger.info("***** voa()");
	}
	
	public void correEVoa() {
		logger.info("***** correEVoa()");
		voa();
	}
}

@RunWith(DemoiselleRunner.class)
public class RequiredRoleTest {
	@Inject
	private Negocio negocio;
	
	@Test(expected = AuthorizationException.class)
	public void testeVoa() {
		negocio.voa();
	}
	
	@Test(expected = AuthorizationException.class)
	public void testeCorreEVoa() {
		negocio.correEVoa();
	}
}
