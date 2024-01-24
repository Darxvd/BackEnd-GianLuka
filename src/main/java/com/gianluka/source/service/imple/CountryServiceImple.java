package com.gianluka.source.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gianluka.source.entity.Country;
import com.gianluka.source.repository.CountryRepository;
import com.gianluka.source.service.CountryService;

@Service
public class CountryServiceImple implements CountryService {

	@Autowired
	private CountryRepository countryRepository;
	
	@Override
	public List<Country> listCountry() {
		return countryRepository.findAll();
	}

}
