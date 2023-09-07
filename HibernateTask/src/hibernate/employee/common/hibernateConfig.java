package hibernate.employee.common;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import hibernate.employee.entity.Employee;

public final class hibernateConfig {

	private hibernateConfig() {
	}

	public static SessionFactory getSessionFactory() {

		Configuration cfg = new Configuration();
		cfg.configure("employee.cfg.xml");
		cfg.addAnnotatedClass(Employee.class);
		SessionFactory sf = cfg.buildSessionFactory();
		return sf;
	}

}
