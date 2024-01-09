package com.gianluka.source.service;

import java.util.List;
import com.gianluka.source.entity.Type;

public interface TypeService {
	public List<Type>listType();
	public List<Type>listfindAllActive();
	public List<Type>listfindAllInactive();
	public Type register(Type objType);
	public Type update(Type objType);
	public Type findByIdType(int idType);
	public void delete(Type objType);

}
