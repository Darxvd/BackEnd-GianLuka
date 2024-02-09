package com.gianluka.source.service;

import java.util.List;

import com.gianluka.source.entity.Person;
public interface PersonService {
	public List<Person>listPerson();
	public List<Person>listfindAllActive();
	public List<Person>listfindAllInactive();
	public Person register(Person objPerson);
	public Person update(Person objPerson);
	public Person findByIdPerson(int idPerson);
	public void delete(Person objPerson);
	public List<Person> listPersonByNameActive(String nombre);
	public List<Person> listPersonByNameInactive(String nombre);
	public List<Person> listPersonByTypeActive(int id);
	public List<Person> listPersonByTypeInactive(int id);
}
