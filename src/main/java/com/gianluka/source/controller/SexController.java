package com.gianluka.source.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gianluka.source.entity.Sex;
import com.gianluka.source.service.SexService;

@RestController
@RequestMapping("/sex")
public class SexController {

	@Autowired
	private SexService serviceSex;
	
	@GetMapping("/list")
	public List<Sex> listSex(){
		return serviceSex.listSex();
	}
}
