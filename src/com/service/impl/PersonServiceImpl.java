package com.service.impl;

import java.util.ArrayList;

import com.dao.PersonDao;
import com.entity.Person;
import com.service.PersonService;

public class PersonServiceImpl implements PersonService {
	
	private static PersonDao personDao=new PersonDao();

	@Override
	public ArrayList<Person> getAllPerson() {
		return personDao.getAllDshop();
	}

	@Override
	public int addPerson(Person person) {
		return personDao.addPerson(person);
	}

	@Override
	public int updatePerson(Person person) {
		return personDao.updatePerson(person);
	}

	@Override
	public int deletePerson(String sno, String dno) {
		return personDao.deletePerson(sno, dno);
	}

}
