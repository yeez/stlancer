package stancer;

import junit.framework.TestCase;

import service.StudentService;
import entities.Student;

/**
 * Unit test for simple App.
 */
public class DBTest extends TestCase {
 
	public void testApp() {
		
		StudentService setudentService = new StudentService();
		
		Student student = new Student();
		student.setStudentName("Yasser");
		
		setudentService.persist(student);
	}
}
