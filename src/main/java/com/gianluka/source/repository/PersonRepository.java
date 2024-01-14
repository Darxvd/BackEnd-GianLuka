package com.gianluka.source.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gianluka.source.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{
	
	Person findById(int idPerson);
	
	@Query(value = "SELECT * FROM tb_persona WHERE activo_persona = 'A'", nativeQuery = true)
	Optional<List<Person>> findAllActive();
	
	@Query(value = "SELECT * FROM tb_persona WHERE activo_persona = 'I'", nativeQuery = true)
	Optional<List<Person>> findAllInactive();
}
