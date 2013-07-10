package br.gov.frameworkdemoiselle.sample.bookmark.view;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.security.RequiredRole;
import br.gov.frameworkdemoiselle.security.SecurityContext;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

import br.gov.frameworkdemoiselle.sample.bookmark.business.BookmarkBC;
import br.gov.frameworkdemoiselle.sample.bookmark.domain.Bookmark;

@ViewController
@NextView("./bookmark_edit.xhtml")
@PreviousView("./bookmark_list.xhtml")
//@RequiredRole({"super-heroi", "administrator"})
public class BookmarkListMB extends AbstractListPageBean<Bookmark, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private BookmarkBC bc;

	@Inject
	private Logger logger;
	
	@Inject
	private SecurityContext securityContext;
	
	@RequiredRole("super-heroi")
	public void teste() {
		System.out.println("teste 123123 ************************");
	}
	
	@Override
	protected List<Bookmark> handleResultList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@RequiredRole("super-heroi")
	public List<Bookmark> handleResultList2() {
//		if (!securityContext.hasRole("super-heroi"))
//			throw new SecurityException("Ô bróder! Você não é super-herói!");
		logger.info("**************************************** handleResultList");
		return this.bc.findAll();
	}
	
//	@RequiredRole("super-heroi")
	@Override
	public List<Bookmark> getResultList() {
		// TODO Auto-generated method stub
		return handleResultList2();
//		return super.getResultList();
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

}
