package ar.com.codigomariano.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ar.com.codigomariano.domain.Usuario;
import ar.com.codigomariano.repositorios.UserRepository;
import ar.com.codigomariano.servicios.UserService;
import ar.com.codigomariano.servicios.UserServiceImp;

@Controller
public class Home {
	@Autowired
	private UserService service;

	@GetMapping("/")
	public String home() {
		
		return "home";
	}
}
