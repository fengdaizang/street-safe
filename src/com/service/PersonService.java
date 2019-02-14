package com.service;

import java.util.ArrayList;

import com.entity.Person;

public interface PersonService {
	public ArrayList<Person> getAllPerson();
	public int addPerson(Person person);
	public int updatePerson(Person person);
	public int deletePerson(String sno,String dno);
}
