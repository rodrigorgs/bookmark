package br.gov.frameworkdemoiselle.sample.bookmark.config;

import javax.servlet.ServletContext;

import org.ocpsoft.rewrite.config.Configuration;
import org.ocpsoft.rewrite.config.ConfigurationBuilder;
import org.ocpsoft.rewrite.servlet.config.HttpConfigurationProvider;
import org.ocpsoft.rewrite.servlet.config.rule.Join;

public class RewriteConfigurationProvider extends HttpConfigurationProvider {
	@Override
	public int priority() {
		return 1;
	}

	@Override
	public Configuration getConfiguration(final ServletContext context) {
		return ConfigurationBuilder.begin()
				.addRule(Join.path("/bookmarks/{id}/edit").to("/bookmark_edit.jsf"));
//						.where("id").bindsTo(PhaseBinding.to(
//								El.property("#{bookmarkEditMB.bean.id}"))
//								.after(PhaseId.RESTORE_VIEW));
	}
}
