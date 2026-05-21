package ar.com.codigomariano.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ar.com.codigomariano.domain.Usuario;
import ar.com.codigomariano.forms.UserForm;
import ar.com.codigomariano.servicios.UserService;
import ar.com.codigomariano.servicios.UserServiceImp;

@Controller
public class UserAdminController {
	private static final String FORM_ATTRIBUTE="form";
	private static final String PATH_PAGES_URL="/admin/users";
	private static final String PATH_CONTEXT_URL="/adm/users";

	@Autowired
	private UserService servicio;
	
	@GetMapping(value=PATH_CONTEXT_URL)
	public String init() {
		return PATH_PAGES_URL+"/list";
	}
	
	@GetMapping(value=PATH_CONTEXT_URL+"/edit")
	public String edit(Model model) {
		model.addAttribute(FORM_ATTRIBUTE,new UserForm());
		return PATH_PAGES_URL+"/form";
	}
	@PostMapping(value=PATH_CONTEXT_URL+"/save")
	public String save(@ModelAttribute(name = FORM_ATTRIBUTE) UserForm formulario) {
		String email=formulario.getEmail();
		Usuario usuario=new Usuario(email);
		System.out.println(usuario);
		this.servicio.guardarUsuario(usuario);
		
		return "redirect:"+PATH_CONTEXT_URL;
	}
	
	
}
