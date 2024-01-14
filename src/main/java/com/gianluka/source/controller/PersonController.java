package com.gianluka.source.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gianluka.source.entity.Person;
import com.gianluka.source.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService servicePerson;
	
	@GetMapping("/list-all")
	public List<Person> listPerson(){
		return servicePerson.listPerson();
	}
	
	@GetMapping("/list-active")
	public List<Person> listAllActive(){
		return servicePerson.listfindAllActive();
	}
	
	@GetMapping("/list-inactive")
	public List<Person> listAllInactive(){
		return servicePerson.listfindAllInactive();
	}
	
	@GetMapping("/find/{idPerson}")
	public Person findByIdPerson(@PathVariable("idPerson") int idPerson) {
		return servicePerson.findByIdPerson(idPerson);
	}
	
	@PostMapping("/register")
	@ResponseBody
	public Person register(@RequestBody Person person) {
		person.setActivoPersona("A");
		return servicePerson.register(person);
	}
	
	@PutMapping("/update/{id}")
	@ResponseBody
	public Person update(@PathVariable("id") int idPerson, @RequestBody Person person) {
		Person tmpperson = servicePerson.findByIdPerson(idPerson);
		tmpperson.setNomPersona(person.getNomPersona());
		tmpperson.setAplPersona(person.getAplPersona());
		tmpperson.setDniPersona(person.getDniPersona());
		tmpperson.setCorreoPersona(person.getCorreoPersona());
		tmpperson.setFnaciPersona(person.getFnaciPersona());
		tmpperson.setCeluPersona(person.getCeluPersona());
		tmpperson.setActivoPersona(person.getActivoPersona());
		tmpperson.setIdSexo(person.getIdSexo());
		tmpperson.setIdTipo(person.getIdTipo());
		return servicePerson.update(tmpperson);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		Person person = servicePerson.findByIdPerson(id);
		person.setActivoPersona("I");
		servicePerson.update(person);
	}

}