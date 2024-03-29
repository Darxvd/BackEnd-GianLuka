package com.gianluka.source.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gianluka.source.entity.Person;
import com.gianluka.source.service.PersonService;

@RestController
@CrossOrigin
@RequestMapping("/person")
public class PersonController {
	
	private final PersonService servicePerson;
	
	public PersonController(PersonService servicePerson) {
		this.servicePerson = servicePerson;
	}

	
	@GetMapping("/list-all")
	public ResponseEntity<List<Person>> listPerson(){
		return new ResponseEntity<>(servicePerson.listPerson(), HttpStatus.OK);
	}
	
	@GetMapping("/list-active")
	public ResponseEntity<List<Person>> listAllActive(){
		return new ResponseEntity<>(servicePerson.listfindAllActive(), HttpStatus.OK);
	}
	
	@GetMapping("/list-inactive")
	public ResponseEntity<List<Person>> listAllInactive(){
		return new ResponseEntity<>(servicePerson.listfindAllInactive(), HttpStatus.OK);
	}
	
	@GetMapping("/list-by-type-active/{id}")
	public ResponseEntity<List<Person>> listByTypeActive(@PathVariable int id) {
	    return new ResponseEntity<>(servicePerson.listPersonByTypeActive(id), HttpStatus.OK);
	}
	
	@GetMapping("/list-by-type-inactive/{id}")
	public ResponseEntity<List<Person>> listByTypeInactive(@PathVariable int id) {
	    return new ResponseEntity<>(servicePerson.listPersonByTypeInactive(id), HttpStatus.OK);
	}

	@GetMapping("/find/{idPerson}")
	public ResponseEntity<Person> findByIdPerson(@PathVariable("idPerson") int idPerson) {
	    if (idPerson > 0) {
	        Person foundPerson = servicePerson.findByIdPerson(idPerson);
	        
	        if (foundPerson != null) {
	            return new ResponseEntity<>(foundPerson, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    } else {
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }
	}

	
	@PostMapping("/register")
	public ResponseEntity<Person> register(@RequestBody Person person) {
		person.setActivoPersona("A");
	    return new ResponseEntity<>(servicePerson.register(person), HttpStatus.CREATED);
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Person> updatePerson(@PathVariable("id") int idPerson, @RequestBody Person updatedPerson) {
	    Person existingPerson = servicePerson.findByIdPerson(idPerson);

	    if (existingPerson != null) {
	        existingPerson.setNomPersona(updatedPerson.getNomPersona());
	        existingPerson.setAplPersona(updatedPerson.getAplPersona());
	        existingPerson.setDniPersona(updatedPerson.getDniPersona());
	        existingPerson.setCorreoPersona(updatedPerson.getCorreoPersona());
	        existingPerson.setFnaciPersona(updatedPerson.getFnaciPersona());
	        existingPerson.setCeluPersona(updatedPerson.getCeluPersona());
	        existingPerson.setIdSexo(updatedPerson.getIdSexo());
	        existingPerson.setIdTipo(updatedPerson.getIdTipo());

	        Person updatedPersonResult = servicePerson.update(existingPerson);
	        return new ResponseEntity<>(updatedPersonResult, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<List<Person>> deletePerson(@PathVariable int id) {
	    Person person = servicePerson.findByIdPerson(id);
	    if (person != null) {
	        person.setActivoPersona("I");
	        servicePerson.update(person);
	        List<Person> activePersons = servicePerson.listfindAllActive();
	        return new ResponseEntity<>(activePersons, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}

	
	@DeleteMapping("/delete/definit/{id}")
	public ResponseEntity<List<Person>> deleteDefinit(@PathVariable int id) {
	    Person person = servicePerson.findByIdPerson(id);
	    if (person == null) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	    servicePerson.delete(person);
	    List<Person> updatedPersonList = servicePerson.listfindAllInactive();

	    return new ResponseEntity<>(updatedPersonList, HttpStatus.OK);
	}

	
	@GetMapping("/list-by-name-active/{nombre}")
	public ResponseEntity<List<Person>> findByNameActive(@PathVariable("nombre") String nombre) {
	    List<Person> persons = servicePerson.listPersonByNameActive(nombre);
	    return new ResponseEntity<>(persons, HttpStatus.OK);
	}	
	
	@GetMapping("/list-by-name-inactive/{nombre}")
	public ResponseEntity<List<Person>> findByNameInactive(@PathVariable("nombre") String nombre) {
	    List<Person> persons = servicePerson.listPersonByNameInactive(nombre);
	    return new ResponseEntity<>(persons, HttpStatus.OK);
	}	
	
	@PutMapping("/activate/{id}")
	public ResponseEntity<Person> activatePerson(@PathVariable("id") int id) {
	    Person existingPerson = servicePerson.findByIdPerson(id);

	    if (existingPerson != null) {
	        existingPerson.setActivoPersona("A");
	        Person activatedPerson = servicePerson.update(existingPerson);
	        return new ResponseEntity<>(activatedPerson, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}