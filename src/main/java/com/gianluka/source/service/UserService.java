package com.gianluka.source.service;

import java.util.List;

import com.gianluka.source.entity.User;

public interface UserService {
	public List<User>listUser();
	public List<User>listfindAllActive();
	public List<User>listfindAllInactive();
	public User register(User objUser);
	public User update(User objUser);
	public User findByIdUser(int idUser);
	public void delete(User objUser);
	public User findByUsuUsuarioAndClaUsuarioAndActivoUsuario(String usuUsuario, String claUsuario, String activoUsuario);
}
