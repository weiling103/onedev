package com.pmease.commons.product;

import java.io.File;
import java.util.Properties;

import com.pmease.commons.bootstrap.Bootstrap;
import com.pmease.commons.hibernate.Hibernate;
import com.pmease.commons.loader.AbstractPlugin;
import com.pmease.commons.loader.AbstractPluginModule;
import com.pmease.commons.tapestry.Tapestry;
import com.pmease.commons.util.FileUtils;

public class PluginModule extends AbstractPluginModule {

	@Override
	protected void configure() {
		super.configure();
		
		Properties hibernateProps = FileUtils.loadProperties(
				new File(Bootstrap.installDir, "conf/hibernate.properties")); 
		bind(Properties.class).annotatedWith(Hibernate.class).toInstance(hibernateProps);
		bind(Package.class).annotatedWith(Tapestry.class).toInstance(Plugin.class.getPackage());
	}

	@Override
	protected Class<? extends AbstractPlugin> getPluginClass() {
		return Plugin.class;
	}

}
