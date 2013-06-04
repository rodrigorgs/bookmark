package br.gov.frameworkdemoiselle.sample.bookmark.view;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.sample.bookmark.business.BookmarkBC;
import br.gov.frameworkdemoiselle.sample.bookmark.domain.Bookmark;
import br.gov.frameworkdemoiselle.sample.bookmark.security.Credenciais;
import br.gov.frameworkdemoiselle.security.RequiredRole;
import br.gov.frameworkdemoiselle.security.SecurityContext;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@NextView("./bookmark_edit.xhtml")
@PreviousView("./bookmark_list.xhtml")
public class BookmarkListMB extends AbstractListPageBean<Bookmark, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private BookmarkBC bc;

	@Inject
	private SecurityContext securityContext;
	
	@Override
	@RequiredRole("miserê")
	protected List<Bookmark> handleResultList() {
		if (!securityContext.hasRole("miserê2"))
			throw new SecurityException("Não tem papel miserê2");
		return this.bc.findAll();
	}

	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);

			if (delete) {
				bc.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

	
	@Inject
	private Credenciais credenciais;
	
	public void autentica() {
		credenciais.setLogin("teste");
		credenciais.setSenha("qwe");
		securityContext.login();
	}
}
