package hibernate.library.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Library {
	
	@Id
	private int isbn;
	
	private String title;
	
	private String author;
	
	private int pubyear;
	
	
	public Library() {
		
	}
	

	public Library(int isbn, String titile, String author, int pubyear) {
		super();
		this.isbn = isbn;
		this.title = titile;
		this.author = author;
		this.pubyear = pubyear;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitile() {
		return title;
	}

	public void setTitile(String titile) {
		this.title = titile;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPubyear() {
		return pubyear;
	}

	public void setPubyear(int pubyear) {
		this.pubyear = pubyear;
	}

	@Override
	public String toString() {
		return "Library [isbn=" + isbn + ", titile=" + title + ", author=" + author + ", pubyear=" + pubyear + "]";
	}
	
	
	
	

}
