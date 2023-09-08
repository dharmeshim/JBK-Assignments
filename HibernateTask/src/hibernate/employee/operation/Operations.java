package hibernate.employee.operation;

public class Operations {
	public static void main(String[] args) {

		Functions funtions = new Functions();

		funtions.addEmployee();
		
		funtions.searchById(5);
		
		funtions.getallEmployees();
//		
//		funtions.updateEmployee(5, "oliver", "twist", "05/05/2000", "oliver@gmail", "content", "5678");
//
		funtions.checkSalaryMoreThan30000();
////		
		funtions.getOtherThanTester();
////		
		funtions.getDeveloperAndTester();
////		
		funtions.getSalaryInDesc();
//		
	}

}
