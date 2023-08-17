package oopconcepts;

public class StudentMember extends LibraryMember {

	private int studentID;

	public StudentMember(int studentID) {
		this.studentID = studentID;

	}

	@Override
	public void borrowItem(LibraryItem item) {
		System.out.println("Student ID : " + studentID + " borrowed a item : " + item.getTitle() + " , itemID : "
				+ item.getItemID() + ".");

	}

}
