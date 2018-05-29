package com.estoico.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estoico.model.Person;

@Service
public class PersonDAOImpl implements PersonDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void save(Person p) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(p);
		tx.commit();
		session.close();
	}

	public List<Person> list() {
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Person> personList = session.createQuery("from Person").list();
		session.close();
		return personList;
	}
	
	

}
