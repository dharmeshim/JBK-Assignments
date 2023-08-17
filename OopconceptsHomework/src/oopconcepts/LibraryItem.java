package oopconcepts;

public class LibraryItem {

	private String title;
	private int itemID;

	public LibraryItem(String title, int itemID) {
		this.title = title;
		this.itemID = itemID;
	}

	public void displayInfo() {
		System.out.println("Item ID is " + getItemID() + ", title : " + getTitle() + ".");
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

}
