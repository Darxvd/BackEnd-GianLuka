package com.gianluka.source.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gianluka.source.entity.Type;
import com.gianluka.source.service.TypeService;

@RestController
@RequestMapping("/type")
public class TypeController {
	
	@Autowired
	private TypeService serviceType;
	
	@GetMapping("/list-all")
	public List<Type> listType(){
		return serviceType.listType();
	}
	
	@GetMapping("/list-active")
	public List<Type> listAllActive(){
		return serviceType.listfindAllActive();
	}
	
	@GetMapping("/list-inactive")
	public List<Type> listAllInactive(){
		return serviceType.listfindAllInactive();
	}
	
	@GetMapping("/find/{idType}")
	public Type finByIdType(@PathVariable("idType") int idType) {
		return serviceType.findByIdType(idType);
	}
	
	@PostMapping("/register")
	@ResponseBody
	public Type register(@RequestBody Type type) {
		type.setActivoTipo("A");
		return serviceType.register(type);
	}
	
	@PutMapping("/update/{id}")
	@ResponseBody
	public Type update(@PathVariable("id") int idType, @RequestBody Type type) {
	    Type tmptype = serviceType.findByIdType(idType);
	    tmptype.setNomTipo(type.getNomTipo());
	    tmptype.setDesTipo(type.getDesTipo());
	    tmptype.setActivoTipo(type.getActivoTipo());
	    return serviceType.update(tmptype);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		Type type = serviceType.findByIdType(id);
		type.setActivoTipo("I");
		serviceType.update(type);
	}
}
