package com.acadeu.web.app.cotrollers;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.acadeu.web.app.entity.Mensajes;
import com.acadeu.web.app.services.IMensajesCrud;
import com.acadeu.web.app.services.UserService;
import com.acadeu.web.app.services.UserServiceImpl;

@Controller
public class NuevoMensaje {
	
	@Autowired
	private UserServiceImpl userLogged;

	@Autowired
	private IMensajesCrud uc;
	
	@Autowired
	private UserService userService;

	@RequestMapping("/nuevo_mensaje")
	public String nuevoMensaje(ModelMap mensaje) {
		
		mensaje.put("mensaje", new Mensajes());
		mensaje.put("usuarios", userService.getAllUsers());
		return "nuevo-mensaje";
	}
	
	@RequestMapping("/responder")
	public String responder(ModelMap mensaje, @RequestParam("usuario") String usuario, @RequestParam String asunto) {
		
		asunto = "Re: " + asunto;
		mensaje.put("asunto", asunto);
		mensaje.put("destinatario", usuario);
		mensaje.put("mensaje", new Mensajes());
		mensaje.put("usuarios", userService.getAllUsers());
		return "nuevo-mensaje";
	}

	

	@PostMapping("/enviar")
	public String mensajeEnviado(@Valid Mensajes mensaje, BindingResult bindingResult, ModelMap mp) throws Exception {
		mp.put("mensaje", new Mensajes());
		Date d = new Date();
		mensaje.setDesde(userLogged.getLoggedUser().getUsername());
		mensaje.setCreateAt(d);
		if (bindingResult.hasErrors()) {
			mp.put("usuarios", uc.findAll());
			return "/nuevo-mensaje";
		} else {
			uc.save(mensaje);
			mp.put("usuario", mensaje);
			return "enviados";
		}
	}

}
