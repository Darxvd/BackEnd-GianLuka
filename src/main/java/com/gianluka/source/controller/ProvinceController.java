package com.gianluka.source.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gianluka.source.entity.Province;
import com.gianluka.source.service.ProvinceService;

@RestController
@RequestMapping("/province")
public class ProvinceController {

	@Autowired
	private ProvinceService serviceProvince;
	
	@GetMapping("/list-province/{provincia}")
	public List<Province> listProvince(@PathVariable int provincia){
		return serviceProvince.listProvince(provincia);
	}
	
}
