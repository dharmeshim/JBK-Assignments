package hibernate.library.common;

import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

import hibernate.library.entity.Library;

public final class hibernateConfig {

	private hibernateConfig() {
	}

	public static SessionFactory getSessionFactory() {

		Configuration cfg = new Configuration();
		cfg.configure("library.cfg.xml");
		cfg.addAnnotatedClass(Library.class);
		SessionFactory sf = cfg.buildSessionFactory();
		return sf;
	}

}
