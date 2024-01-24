package com.gianluka.source.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gianluka.source.entity.Country;
import com.gianluka.source.service.CountryService;

@RestController
@RequestMapping("/country")
public class CountryController {

	@Autowired
	private CountryService serviceCountry;
	
	@GetMapping("/list-country")
	public List<Country> listCountry(){
		return serviceCountry.listCountry();
	}
	
}
