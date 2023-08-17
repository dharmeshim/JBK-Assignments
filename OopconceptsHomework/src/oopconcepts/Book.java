package oopconcepts;

public class Book extends LibraryItem {

	private String author;

	public Book(String title, int itemID, String author) {
		super(title, itemID);
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public void displayInfo() {
		System.out.println(
				"Item ID is " + getItemID() + ", Book title : " + getTitle() + " by the author " + getAuthor() + ".");
	}

}
