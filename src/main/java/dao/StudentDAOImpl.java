package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.annotations.common.util.impl.Log;

import entities.Student;

public class StudentDAOImpl extends HbUtil implements EntityDAO<Student, String> {

	public StudentDAOImpl(){
	}

	@Override
	public void persist(Student student) {
		getCurrentSession().save(student);
	}

	@Override
	public void update(Student student) {
		getCurrentSession().update(student);
	}

	@Override
	public Student findById(String id) {
		Student student= (Student) getCurrentSession().get(Student.class, id);
		return student;
	}

	@Override
	public void delete(Student student) {
		getCurrentSession().delete(student);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> findAll() {
		List<Student> students = (List<Student>) getCurrentSession().createQuery("from Property").list();
		return students;
	}

	@Override
	public void deleteAll() {
		List<Student> studentList = findAll();
		for (Student student : studentList) {
			delete(student);
		}
	}

	public Student findByEmail(String email) {
		Student tempStudent = null;
		try{
			tempStudent = (Student) getCurrentSession().createQuery("SELECT * FROM student WHERE email like '"+email+"'");			
		}catch (HibernateException e){
			e.printStackTrace();
		}
		return tempStudent;
	}

}


