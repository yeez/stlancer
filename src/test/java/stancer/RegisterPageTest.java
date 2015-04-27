package stancer;

import junit.framework.TestCase;

import org.junit.Test;

import entities.Student;

public class RegisterPageTest extends TestCase{

	@Test
	public void testPersistNewStudent() {
		
		RegisterPage registerPage = new RegisterPage();
		
		Student s1 = new Student();
		
		s1.setEmail("aaaaaaa");
		s1.setName("aaaaaaaaaaa");
		s1.setPassword("aaaaaaaaaa");
		
		registerPage.setStudent(s1);
		registerPage.persistNewStudent();
	}

}
