

//Problem Statement - 1
//        Implement a program in Java that manages employee records using the
//        Collection Framework. The program should allow users to perform various
//        operations related to employee records, such as adding employees, viewing
//        their details, and searching for employees based on their ID. Use suitable data
//        structures from the Collection Framework to store and manage employee
//        records.
package employeesystem;

 class Employee {
    private int ID;
    private String name;
    private double salary;
    private int age;
    public Employee(){

    }
     public Employee(int ID, String name, double salary, int age) {
        this.ID = ID;
        this.name = name;
        this.salary = salary;
        this.age = age;
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}