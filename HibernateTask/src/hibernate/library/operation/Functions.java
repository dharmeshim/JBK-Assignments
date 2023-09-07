package hibernate.library.operation;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import hibernate.library.common.hibernateConfig;
import hibernate.library.entity.Library;

public class Functions {

	public void addBook() {

		SessionFactory sf = hibernateConfig.getSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();

		Library book = new Library(1003, "fire of wings", "abdul kalam", 2005);

		session.save(book);

		tr.commit();
		session.close();
		System.out.println("book added");

	}

	public void searchByYear(int startYear, int endYear) {

		SessionFactory sf = hibernateConfig.getSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();

		Criteria criteria = session.createCriteria(Library.class);
		criteria.add(Restrictions.between("pubyear", startYear, endYear));

		List<Library> list = criteria.list();
		for (Library book : list) {
			System.out.println(book);
		}

		tr.commit();
		session.close();

	}

	public void searchByAuthor(String author) {

		SessionFactory sf = hibernateConfig.getSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();

		Criteria criteria = session.createCriteria(Library.class);
		criteria.add(Restrictions.eq("author", author));

		List<Library> list = criteria.list();
		for (Library book : list) {
			System.out.println(book);
		}

		tr.commit();
		session.close();

	}

	public void searchByTitle(String title) {

		SessionFactory sf = hibernateConfig.getSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();

		Criteria criteria = session.createCriteria(Library.class);
		criteria.add(Restrictions.like("title", "%" + title + "%"));

		List<Library> list = criteria.list();
		for (Library book : list) {
			System.out.println(book);
		}

		tr.commit();
		session.close();
	}

	public void searchByIsbn(int isbn) {

		SessionFactory sf = hibernateConfig.getSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();

		Criteria criteria = session.createCriteria(Library.class);
		criteria.add(Restrictions.eq("isbn", isbn));

		List<Library> list = criteria.list();
		for (Library book : list) {
			System.out.println(book);
		}

		tr.commit();
		session.close();
	}

	public void allBooks() {

		SessionFactory sf = hibernateConfig.getSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();

		Criteria criteria = session.createCriteria(Library.class);
		criteria.setProjection(Projections.property("title"));

		List<String> list = criteria.list();
		for (String book : list) {
			System.out.println(book);
		}

		tr.commit();
		session.close();
	}
	
	public void updateBook(int Isbn, String title, String author, int pubyear) {

		SessionFactory sf = hibernateConfig.getSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();

		Library book = new Library(Isbn, title, author, pubyear);

		session.saveOrUpdate(book);

		tr.commit();
		session.close();
		System.out.println("book updated");

	}
	
	public void deleteBook(int isbn) {

		SessionFactory sf = hibernateConfig.getSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();

		Library book = new Library();
		book.setIsbn(isbn);

		session.delete(book);

		tr.commit();
		session.close();
		System.out.println("book deleted");

	}
	
	
}
