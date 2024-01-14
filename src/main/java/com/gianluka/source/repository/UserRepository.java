package com.gianluka.source.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gianluka.source.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findById(int idUser);
	
	@Query(value = "SELECT * FROM tb_usuario WHERE activo_usuario = 'A'", nativeQuery = true)
	Optional<List<User>> findAllActive();
	
	@Query(value = "SELECT * FROM tb_usuario WHERE activo_usuario = 'I'", nativeQuery = true)
	Optional<List<User>> findAllInactive();
	
	User findByUsuUsuarioAndClaUsuarioAndActivoUsuario(String usuUsuario, String claUsuario, String activoUsuario);

}
