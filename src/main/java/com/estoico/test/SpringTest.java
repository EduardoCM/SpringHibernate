package com.estoico.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.estoico.dao.PersonDAO;
import com.estoico.model.Person;

public class SpringTest {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

		PersonDAO personDAO = (PersonDAO) context.getBean("personDAOImpl");

		Person person = new Person();
		person.setName("Eduardo");
		person.setCountry("Brazil");

		personDAO.save(person);
		System.out.println("Person::" + person);

		List<Person> list = personDAO.list();

		for (Person person2 : list) {
			System.out.println("Person List:: " + person2);
		}

		context.close();
		
	}
}