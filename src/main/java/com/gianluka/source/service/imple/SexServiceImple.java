package com.gianluka.source.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gianluka.source.entity.Sex;
import com.gianluka.source.repository.SexRepository;
import com.gianluka.source.service.SexService;

@Service
public class SexServiceImple implements SexService{

	@Autowired
	private SexRepository sexRepository;
	
	@Override
	public List<Sex> listSex() {
		return sexRepository.findAll();
	}
}
