package oopconcepts;

public class DVD extends LibraryItem {

	private double duration;

	public DVD(String title, int itemID, double duration) {
		super(title, itemID);
		this.duration = duration;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	@Override
	public void displayInfo() {
		System.out.println(
				"Item ID is " + getItemID() + ", DVD title : " + getTitle() + " has " + getDuration() + " duration.");
	}

}
