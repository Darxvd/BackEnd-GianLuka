package com.gianluka.source.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gianluka.source.entity.Department;
import com.gianluka.source.service.DepartamentService;

@RestController
@RequestMapping("/department")
public class DepartamentController {

	@Autowired
	private DepartamentService serviceDepartment;
	
	@GetMapping("/list-department/{pais}")
	public List<Department> listDepartament(@PathVariable int pais){
		return serviceDepartment.listDepartment(pais);
	}
	
}
