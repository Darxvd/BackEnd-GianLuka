package com.gianluka.source.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gianluka.source.dtos.LoginDto;
import com.gianluka.source.entity.User;
import com.gianluka.source.exception.UsuarioNoEncontradoException;
import com.gianluka.source.service.UserService;

@RestController
@RequestMapping("/login")
public class UserController {
	
	@Autowired
	private UserService serviceUser;
	
	@GetMapping("/list-all")
	public List<User> listUser(){
		return serviceUser.listUser();
	}
	
	@GetMapping("/list-active")
	public List<User> listAllActive(){
		return serviceUser.listfindAllActive();
	}
	
	@GetMapping("/list-inactive")
	public List<User> listAllInactive(){
		return serviceUser.listfindAllInactive();
	}
	
	@PostMapping("/login")
	@ResponseBody
	public ResponseEntity<?> login(@RequestBody LoginDto loginRequest) {
	    try {
	        // Lógica de inicio de sesión
	        String usuUsuario = loginRequest.getUsuUsuario();
	        String claUsuario = loginRequest.getClaUsuario();
	        String activoUsuario = "A";

	        User usuario = serviceUser.findByUsuUsuarioAndClaUsuarioAndActivoUsuario(usuUsuario, claUsuario, activoUsuario);

	        // Usuario encontrado, devuelve el usuario
	        return ResponseEntity.ok(usuario);
	    } catch (UsuarioNoEncontradoException e) {
	        // Usuario no encontrado, devuelve un código de estado 404 (Not Found)
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	    } catch (Exception ex) {
	        // Otros errores, maneja de acuerdo a tus necesidades
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error desconocido");
	    }
	}
	
	@GetMapping("/find/{idUser}")
	public User findByIdUser(@PathVariable("idUser") int idUser) {
		return serviceUser.findByIdUser(idUser);
	}
	
	@PostMapping("/register")
	@ResponseBody
	public User register(@RequestBody User user) {
		user.setActivoUsuario("A");
		return serviceUser.register(user);
	}
	
	@PutMapping("/update/{id}")
	@ResponseBody
	public User update(@PathVariable("id") int idUser, @RequestBody User user) {
		User tmpuser = serviceUser.findByIdUser(idUser);
		tmpuser.setClaUsuario(user.getClaUsuario());
		return serviceUser.update(tmpuser);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		User user = serviceUser.findByIdUser(id);
		user.setActivoUsuario("I");
		serviceUser.update(user);
	}
	
	@DeleteMapping("/delete/definit/{id}")
	public void deleteDefinit(@PathVariable int id) {
		User user = serviceUser.findByIdUser(id);
		serviceUser.delete(user);
	}

	private String generateUser(User user) {
	    String nomPersona = user.getObjPerson().getNomPersona();
	    String aplPersona = user.getObjPerson().getAplPersona();
	    
	    // Verificar si nomPersona o aplPersona son null y asignar cadenas vacías en ese caso
	    nomPersona = (nomPersona != null) ? nomPersona : "";
	    aplPersona = (aplPersona != null) ? aplPersona : "";
	    
	    String usuario = nomPersona.substring(0, Math.min(nomPersona.length(), 3))
	            + aplPersona.substring(0, Math.min(aplPersona.length(), 3));
	    return usuario.toLowerCase();
	}

	
	private String generatePassword() {
		String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder claveAleatoria = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(caracteres.length());
            claveAleatoria.append(caracteres.charAt(index));
        }
        return claveAleatoria.toString();
	}
	
}
