package com.gianluka.source.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.gianluka.source.entity.Type;

public interface TypeRepository extends JpaRepository<Type, Integer>{
	
	Type findById(int idType);
	
	@Query(value = "SELECT * FROM tb_tipo WHERE activo_tipo = 'A'", nativeQuery = true)
    Optional<List<Type>> findAllActive();
	
	@Query(value = "SELECT * FROM tb_tipo WHERE activo_tipo = 'I'", nativeQuery = true)
    Optional<List<Type>> findAllInactive();
}
