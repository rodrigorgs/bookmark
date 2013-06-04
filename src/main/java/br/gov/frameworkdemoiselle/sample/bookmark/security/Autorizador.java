package br.gov.frameworkdemoiselle.sample.bookmark.security;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.security.Authorizer;
import br.gov.frameworkdemoiselle.security.SecurityContext;

public class Autorizador implements Authorizer {
	private static final long serialVersionUID = 1L;

	@Inject
	private SecurityContext context;
	
	@Override
	public boolean hasRole(String role) {
		if (context.getUser().getId() != null && context.getUser().getId().equals("root") && role.equals("root"))
			return true;
		return false;
	}

	@Override
	public boolean hasPermission(String resource, String operation) {
		// TODO Auto-generated method stub
		return false;
	}

}
