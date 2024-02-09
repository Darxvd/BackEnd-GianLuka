package com.gianluka.source.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gianluka.source.entity.User;
import com.gianluka.source.exception.UsuarioNoEncontradoException;
import com.gianluka.source.repository.UserRepository;
import com.gianluka.source.service.UserService;

import io.micrometer.common.util.StringUtils;

@Service
public class UserServiceImple implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> listUser() {
		return userRepository.findAll();
	}

	@Override
	public List<User> listfindAllActive() {
		return userRepository.findAllActive().get();
	}

	@Override
	public List<User> listfindAllInactive() {
		return userRepository.findAllInactive().get();
	}

	@Override
	public User findByIdUser(int idUser) {
		return userRepository.findById(idUser);
	}

	@Override
	public User register(User objUser) {
		return userRepository.save(objUser);
	}

	@Override
	public User update(User objUser) {
		return userRepository.save(objUser);
	}

	@Override
	public void delete(User objUser) {
		userRepository.delete(objUser);
	}

	@Override
	public User findByUsuUsuarioAndClaUsuarioAndActivoUsuario(String usuUsuario, String claUsuario,
			String activoUsuario) {
	    // Validaciones
	    if (StringUtils.isEmpty(usuUsuario) || StringUtils.isEmpty(claUsuario)) {
	        throw new IllegalArgumentException("Nombre de usuario y contraseña son requeridos");
	    }

	    // Buscar usuario en la base de datos
	    User usuario = userRepository.findByUsuUsuarioAndClaUsuarioAndActivoUsuario(usuUsuario, claUsuario, activoUsuario);

	    // Validar si el usuario no existe
	    if (usuario == null) {
	        throw new UsuarioNoEncontradoException("Usuario no encontrado");
	    }

	    return usuario;
	}
	

}
