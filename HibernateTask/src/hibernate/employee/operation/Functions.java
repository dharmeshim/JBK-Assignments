package hibernate.employee.operation;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import hibernate.employee.common.hibernateConfig;
import hibernate.employee.entity.Employee;
import hibernate.library.entity.Library;

public class Functions {

	public void addEmployee() {

		SessionFactory sf = hibernateConfig.getSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();

		Employee employee = new Employee();
		employee.setEmployeeID(8);
		employee.setFirstName("Berlin");
		employee.setLastName("leo");
		employee.setEmail("berlin@gmail");
		employee.setDepartment("security");
		employee.setDateOfBirth("01/01/1996");
		employee.setSalary("60000");
		

		session.save(employee);

		tr.commit();
		session.close();
		System.out.println("employee added successfully");

	}

	public void searchById(int employeeId) {

		SessionFactory sf = hibernateConfig.getSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();

		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("employeeID", employeeId));

		List<Employee> list = criteria.list();
		for (Employee employee : list) {
			System.out.println(employee);
		}

		tr.commit();
		session.close();
	}
	
	public void getallEmployees() {

		SessionFactory sf = hibernateConfig.getSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();

		Criteria criteria = session.createCriteria(Employee.class);
		criteria.setProjection(Projections.property("firstName"));

		List<String> list = criteria.list();
		for (String employee : list) {
			System.out.println(employee);
		}

		tr.commit();
		session.close();
	}
	
	public void updateEmployee(int employeeId, String firstName, String lastName, String dob, String email, String dept, String salary) {

		SessionFactory sf = hibernateConfig.getSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();

		Employee employee = new Employee(employeeId, firstName, lastName, dob, email, dept, salary);

		session.saveOrUpdate(employee);

		tr.commit();
		session.close();
		System.out.println("employee updated");

	}
	
	public void checkSalaryMoreThan30000() {

		SessionFactory sf = hibernateConfig.getSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();

		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.gt("salary", "30000"));

		List<Employee> list = criteria.list();
		for (Employee employee : list) {
			System.out.println(employee);
		}

		tr.commit();
		session.close();
	}
	
	public void getOtherThanTester() {

		SessionFactory sf = hibernateConfig.getSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();

		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.ne("department", "tester"));

		List<Employee> list = criteria.list();
		for (Employee employee : list) {
			System.out.println(employee);
		}

		tr.commit();
		session.close();
	}
	

	public void getDeveloperAndTester() {

		SessionFactory sf = hibernateConfig.getSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();

		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("department", "tester"));

		List<Employee> list = criteria.list();
		for (Employee employee : list) {
			System.out.println(employee);
		}
		criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("department", "dev"));

		list = criteria.list();
		for (Employee employee : list) {
			System.out.println(employee);
		}
		
		
		tr.commit();
		session.close();
	}
	
	public void getSalaryInDesc() {

		SessionFactory sf = hibernateConfig.getSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();

		Criteria criteria = session.createCriteria(Employee.class);
		criteria.setProjection(Projections.property("salary"));

		List<Employee> list = criteria.list();
		for (Employee employee : list) {
			System.out.println(employee);
		}

		tr.commit();
		session.close();
	}
	
	
	
}
