package br.gov.frameworkdemoiselle.sample.bookmark.view;

import javax.inject.Inject;

import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.sample.bookmark.domain.Bookmark;
import br.gov.frameworkdemoiselle.sample.bookmark.security.Credential;
import br.gov.frameworkdemoiselle.security.SecurityContext;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.template.AbstractPageBean;

@ViewController
@NextView("/index.xhtml")
@PreviousView("/index.xhtml")
public class LoginMB extends AbstractPageBean {

	@Inject
	private Credential credential;
	
	@Inject
	private SecurityContext securityContext;
	
	@Inject
	private Logger logger;
	
	public String login() {
		logger.info("********* login");
		credential.setLogin("robin");
		credential.setSenha("batman");
		securityContext.login();
		return getNextView();
	}
	
}
