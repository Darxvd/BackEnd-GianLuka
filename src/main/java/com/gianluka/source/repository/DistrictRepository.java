package com.gianluka.source.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.gianluka.source.entity.District;

public interface DistrictRepository extends JpaRepository<District, Integer>{

	@Query(value = "SELECT d.id_distrito, d.des_distrito, p.id_provincia FROM tb_provincia p INNER JOIN tb_distrito d ON d.id_provincia = p.id_provincia WHERE p.id_provincia = :provincia", nativeQuery = true)
	List<District> findDistict(@Param("provincia") int provincia);

}
