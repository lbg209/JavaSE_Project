package mylab.student.control;

import mylab.student.entity.Student;
import mylab.student.exception.InvalidGradeException;

public class StudentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Student student1 = new Student("20261117", "김민수", "컴퓨터공학과", 3);
		
			System.out.println(student1.getGrade());
			student1.setGrade(5);
			
		} catch (InvalidGradeException e) {
			System.out.println(e.getMessage());
		}
	}

}
