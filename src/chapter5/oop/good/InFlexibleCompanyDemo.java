package chapter5.oop.good;

public class InFlexibleCompanyDemo {
    public static void main(String[] args) {

    	Employee mereClerk1 = new MereClerk("철수", 100);
    	Employee mereClerk2 = new MereClerk("영희", 200);

    	Employee manager = new Manager("홍길동", 300, "인사부");
    	Manager manager2 = new Manager("아무개", 500, "개발부");
    	
    	System.out.println(manager.getName() + " " + manager.getSalary());
    	Manager m = (Manager) manager;
    	m.getDepartment();
    	
    	System.out.println(manager2.getName() + " " + manager2.getSalary() + " " + manager2.getDepartment());
    	System.out.println("");
		/*
		 * MereClerk mereClerk1 = new MereClerk("철수", 100);
		 * MereClerk mereClerk2 = newMereClerk("영희", 100); 
		 * Manager manager = new Manager("홍길동", 200);
		 */

    	Employee[] emps = new Employee[3];
    	emps[0] = new MereClerk("철수", 2000);
    	emps[1] = new MereClerk("영희", 3000);
    	emps[2] = new Manager("민수", 4000, "인사부");

        
    	for (Employee employee : emps) {
    		System.out.println("현재 연봉입니다.");
    		
    		if (employee instanceof Manager) {
    			System.out.print("부서명 = " + ((Manager) employee).getDepartment() + "관리자");	
    		}
    		
    		System.out.println(employee.getName() + "의 연봉은 " + employee.getSalary() + "만원 입니다.");
            System.out.println("");
            
            System.out.println("올린 후의 월급입니다.");
            employee.manageSalary(10);
            System.out.println(employee.getName() + "의 연봉은 " + employee.getSalary() + "만원 입니다.");
            System.out.println("");
    	}
    	
    	
   }
}

