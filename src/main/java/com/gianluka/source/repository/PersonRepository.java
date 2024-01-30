package com.gianluka.source.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gianluka.source.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{
	
	Person findById(int idPerson);
	
	@Query(value = "SELECT * FROM tb_persona WHERE activo_persona = 'A'", nativeQuery = true)
	Optional<List<Person>> findAllActive();
	
	@Query(value = "SELECT * FROM tb_persona WHERE activo_persona = 'I'", nativeQuery = true)
	Optional<List<Person>> findAllInactive();
	
	@Query(value="select * from tb_persona where activo_persona = 'A' AND nom_persona LIKE %:nombre%", nativeQuery = true)
	List<Person> findByName(@Param("nombre") String nombre);
}
