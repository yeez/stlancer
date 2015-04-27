package service;

import java.util.List;

import dao.StudentDAOImpl;
import entities.Student;

public class StudentService {
	
	private static StudentDAOImpl studentDaoImpl;

	public StudentService() {
		studentDaoImpl = new StudentDAOImpl();
	}

	public void persist(Student student) {
		studentDaoImpl.openCurrentSessionWithTransaction();
		studentDaoImpl.persist(student);
		studentDaoImpl.closeCurrentSessionWithTransaction();
	}

	public void update(Student student) {
		studentDaoImpl.openCurrentSessionWithTransaction();
		studentDaoImpl.update(student);
		studentDaoImpl.closeCurrentSessionWithTransaction();
	}

	public Student findById(String id) {
		studentDaoImpl.openCurrentSession();
		Student student= studentDaoImpl.findById(id);
		studentDaoImpl.closeCurrentSession();
		return student;
	}

	public void delete(String id) {
		studentDaoImpl.openCurrentSessionWithTransaction();
		Student student= studentDaoImpl.findById(id);
		studentDaoImpl.delete(student);
		studentDaoImpl.closeCurrentSessionWithTransaction();
	}

	public List<Student> findAll() {
		studentDaoImpl.openCurrentSession();
		List<Student> students= studentDaoImpl.findAll();
		studentDaoImpl.closeCurrentSession();
		return students;
	}

	public void deleteAll() {
		studentDaoImpl.openCurrentSessionWithTransaction();
		studentDaoImpl.deleteAll();
		studentDaoImpl.closeCurrentSessionWithTransaction();
	}

	public StudentDAOImpl getStudentDaoImpl() {
		return studentDaoImpl;
	}
	
	public boolean isStudentMember(String email){
		if(studentDaoImpl.findByEmail(email) == null){
			return false;
		}else{
			return true;
		}
	}
	
}
