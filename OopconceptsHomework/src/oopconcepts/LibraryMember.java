package oopconcepts;

public abstract class LibraryMember implements Reservable {

	private int memberID;
	private String name;

	public abstract void borrowItem(LibraryItem item);

	public void reserveItem(LibraryItem item) {
		System.out.println("Item : " + item.getTitle() + " , itemID : " + item.getItemID() + " is reserved.");

	}

}
