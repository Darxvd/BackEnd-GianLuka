package com.gianluka.source.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gianluka.source.entity.Person;

public interface PersonRepository extends JpaRepository<Person, String>{

}
