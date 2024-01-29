package com.gianluka.source.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.gianluka.source.entity.Province;

public interface ProvinceRepository extends JpaRepository<Province, Integer>{
	Province findById(int idprov);
	@Query(value = "SELECT p.id_provincia, p.des_provincia, d.id_departamento FROM tb_departamentos d INNER JOIN tb_provincia p ON p.id_departamento = d.id_departamento WHERE d.id_departamento = :provincia", nativeQuery = true)
	List<Province> findProvince(@Param("provincia") int provincia);
	
}
