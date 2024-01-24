package com.gianluka.source.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gianluka.source.entity.Department;
import com.gianluka.source.repository.DepartamentRepository;
import com.gianluka.source.service.DepartamentService;

@Service
public class DepartmentServiceImple implements DepartamentService{

	@Autowired
	private DepartamentRepository departamentRepository;

	@Override
	public List<Department> listDepartment(int pais) {
		return departamentRepository.findCountry(pais);
	}
	
	
	
}
