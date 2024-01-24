package com.gianluka.source.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.gianluka.source.entity.Department;

public interface DepartamentRepository extends JpaRepository<Department, Integer> {
	Department findById(int iddepa);
	
	@Query(value = "SELECT d.id_departamento, d.des_departamento, d.id_pais FROM tb_pais p INNER JOIN tb_departamentos d ON d.id_pais = p.id_pais WHERE p.id_pais = :pais", nativeQuery = true)
	List<Department> findCountry(@Param("pais") int pais);

}
