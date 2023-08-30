package school;

public class Student extends Person{

    private int rollNumber;

    public Student() {

    }

    public Student(String name,int age, int rollNumber) {
        super(name, age);
        this.rollNumber = rollNumber;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Student name = "+ getName()+
                " Student age = "+getAge()+
                " rollNumber=" + rollNumber +
                '}';
    }
}
