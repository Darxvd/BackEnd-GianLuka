package com.gianluka.source.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gianluka.source.entity.Person;
import com.gianluka.source.repository.PersonRepository;
import com.gianluka.source.service.PersonService;

@Service
public class PersonServiceImple implements PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	@Override
	public List<Person> listPerson() {
		return personRepository.findAll();
	}

	@Override
	public List<Person> listfindAllActive() {
		return personRepository.findAllActive().get();
	}
	
	@Override
	public List<Person> listfindAllInactive() {
		return personRepository.findAllInactive().get();
	}
	
	@Override
	public Person findByIdPerson(int idPerson) {
		return personRepository.findById(idPerson);
	}
	
	@Override
	public Person register(Person objPerson) {
		return personRepository.save(objPerson);
	}

	@Override
	public Person update(Person objPerson) {
		return personRepository.save(objPerson);
	}


	@Override
	public void delete(Person objPerson) {
		personRepository.delete(objPerson);
	}

	@Override
	public List<Person> listPersonByName(String nombre) {
		return personRepository.findByName(nombre);
	}


}
