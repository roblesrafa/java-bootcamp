package com.pruebas.dao.imp;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pruebas.dao.StudentDAO;
import com.pruebas.model.Student;

@Repository
public class StudentDAOImp implements  StudentDAO{//no usar GenericDAO<Student>

	@Autowired
	private SessionFactory sessionFactory;

    
	@Transactional
	public boolean addEntity(Student student) {
		sessionFactory.getCurrentSession().save(student);
		return true;
		
	}

	@Transactional
	public Student getEntity(int id) {
		return (Student) sessionFactory.getCurrentSession().get(Student.class,id );
		
	}
    
	@Transactional
	public List<Student> getEntities() {
		@SuppressWarnings("unchecked")
		List<Student> students = (List<Student>) sessionFactory.getCurrentSession()
				.createCriteria(Student.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return students;
	}
    
	@Transactional
	public boolean updateEntity(Student student) {
		sessionFactory.getCurrentSession().update(student);
		return true; 
		
	}

}