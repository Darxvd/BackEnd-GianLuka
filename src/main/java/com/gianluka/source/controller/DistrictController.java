package com.gianluka.source.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gianluka.source.entity.District;
import com.gianluka.source.service.DistrictService;

@RestController
@RequestMapping("/district")
public class DistrictController {

	@Autowired
	private DistrictService serviceDistrict;
	
	@GetMapping("/list-district/{provincia}")
	public List<District> listDistrict(@PathVariable int provincia){
		return serviceDistrict.listDistrict(provincia);
	}
}
