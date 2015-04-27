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
	private boolean studentExistFlag = false;
	
	@PostConstruct
	public void init() {
		student = new Student();
		studentService = new StudentService();
	}
	
	public void persistNewStudent(){
		if(! studentService.isStudentMember(student.getEmail())){
			studentExistFlag = false;
			studentService.persist(student);			
		}else{
			studentExistFlag = true;
		}
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public boolean isStudentExistFlag() {
		return studentExistFlag;
	}

	public void setStudentExistFlag(boolean studentExistFlag) {
		this.studentExistFlag = studentExistFlag;
	}

}
