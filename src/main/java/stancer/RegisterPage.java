package stancer;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import service.StudentService;
import entities.Student;

@ManagedBean
@ViewScoped
public class RegisterPage {
	
	private StudentService studentService;
	private Student student;
	
	@PostConstruct
	public void init() {
		student = new Student();
		studentService = new StudentService();
	}
	
	public void persistNewStudent(){
		studentService.persist(student);
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
}
