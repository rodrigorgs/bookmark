package br.gov.frameworkdemoiselle.sample.bookmark.business;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.lifecycle.Startup;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;

import br.gov.frameworkdemoiselle.sample.bookmark.domain.Bookmark;
import br.gov.frameworkdemoiselle.sample.bookmark.persistence.BookmarkDAO;
import br.gov.frameworkdemoiselle.security.RequiredRole;

@BusinessController
public class BookmarkBC extends DelegateCrud<Bookmark, Long, BookmarkDAO> {
	
	private static final long serialVersionUID = 1L;
	
//	@RequiredRole("super-heroi")
	@Override
	public List<Bookmark> findAll() {
		return getDelegate().findAll();
	}
	
	@Inject
	private Logger logger;
	
	
	@RequiredRole("super-heroi")
	public void teste() {
		logger.info("teste() ************************");
		teste2();
	}
	
	
	public void teste2() {
		logger.info("teste2() ************************");
	}
	
	@Startup
	@Transactional
	public void load() {
		if (findAll().isEmpty()) {
			insert(new Bookmark("Demoiselle Portal", "http://www.frameworkdemoiselle.gov.br"));
			insert(new Bookmark("Demoiselle SourceForge", "http://sf.net/projects/demoiselle"));
			insert(new Bookmark("Twitter", "http://twitter.frameworkdemoiselle.gov.br"));
			insert(new Bookmark("Blog", "http://blog.frameworkdemoiselle.gov.br"));
			insert(new Bookmark("Wiki", "http://wiki.frameworkdemoiselle.gov.br"));
			insert(new Bookmark("Bug Tracking", "http://tracker.frameworkdemoiselle.gov.br"));
			insert(new Bookmark("Forum", "http://forum.frameworkdemoiselle.gov.br"));
			insert(new Bookmark("SVN", "http://svn.frameworkdemoiselle.gov.br"));
			insert(new Bookmark("Maven", "http://repository.frameworkdemoiselle.gov.br"));
			insert(new Bookmark("Downloads", "http://download.frameworkdemoiselle.gov.br"));
		}
	}
	
}
