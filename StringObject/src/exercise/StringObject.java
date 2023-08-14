package exercise;

public class StringObject {
	void m1(String str) {
		System.out.println("in string");
	}

	void m1(Object str) {
		System.out.println("in object");
	}

	public static void main(String[] args) {
		StringObject obj = new StringObject();
		obj.m1((Object) null);
	}
}
