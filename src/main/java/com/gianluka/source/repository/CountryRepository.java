package com.gianluka.source.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gianluka.source.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {
	
}
