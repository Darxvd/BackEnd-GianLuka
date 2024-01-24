package com.gianluka.source.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gianluka.source.entity.District;
import com.gianluka.source.repository.DistrictRepository;
import com.gianluka.source.service.DistrictService;

@Service
public class DistrictServiceImple implements DistrictService{

	@Autowired
	private DistrictRepository districtRepository;
	
	@Override
	public List<District> listDistrict(int provincia) {
		return districtRepository.findDistict(provincia);
	}

}
