package com.gianluka.source.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gianluka.source.dtos.LoginDto;
import com.gianluka.source.entity.User;
import com.gianluka.source.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService serviceUser;
	
	@GetMapping("/list-all")
	public List<User> listUser(){
		return serviceUser.listUser();
	}
	
	@PostMapping("/login")
	@ResponseBody
	public User login(@RequestBody LoginDto loginRequest) {
	    String usuUsuario = loginRequest.getUsuUsuario();
	    String claUsuario = loginRequest.getClaUsuario();
	    String activoUsuario = "A";

	    User usuario = serviceUser.findByUsuUsuarioAndClaUsuarioAndActivoUsuario(usuUsuario, claUsuario, activoUsuario);
	    return usuario;
	}



	
}
