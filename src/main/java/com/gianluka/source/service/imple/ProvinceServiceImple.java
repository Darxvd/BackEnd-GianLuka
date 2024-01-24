package com.gianluka.source.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gianluka.source.entity.Province;
import com.gianluka.source.repository.ProvinceRepository;
import com.gianluka.source.service.ProvinceService;

@Service
public class ProvinceServiceImple implements ProvinceService{

	@Autowired
	private ProvinceRepository provinceRepository;

	@Override
	public List<Province> listProvince(int province) {
		return provinceRepository.findProvince(province);
	}

}
