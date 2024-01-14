package com.gianluka.source.service.imple;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gianluka.source.entity.Type;
import com.gianluka.source.repository.TypeRepository;
import com.gianluka.source.service.TypeService;

@Service
public class TypeServiceImple implements TypeService{
	
	@Autowired
	private TypeRepository typeRepository;

	@Override
	public List<Type> listType() {
		return typeRepository.findAll();
	}

	@Override
	public List<Type> listfindAllActive() {
		return typeRepository.findAllActive().get();
	}
	
	@Override
	public List<Type> listfindAllInactive() {
		return typeRepository.findAllInactive().get();
	}
	
	@Override
	public Type findByIdType(int idType) {
		return typeRepository.findById(idType);
	}
	
	@Override
	public Type register(Type objType) {
		return typeRepository.save(objType);
	}

	@Override
	public Type update(Type objType) {
		return typeRepository.save(objType);
	}


	@Override
	public void delete(Type objType) {
		typeRepository.delete(objType);
	}

	

}
