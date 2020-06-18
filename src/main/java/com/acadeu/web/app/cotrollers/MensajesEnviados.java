package com.acadeu.web.app.cotrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.acadeu.web.app.services.IMensajesCrud;
import com.acadeu.web.app.services.UserServiceImpl;

@Controller
public class MensajesEnviados {

	@Autowired
    private IMensajesCrud uc;
	
	@Autowired
	private UserServiceImpl userLogged;
	
	@RequestMapping("enviados")
	public String login(ModelMap model) throws Exception {
		

		String username = userLogged.getLoggedUser().getUsername();
		
		model.put("mensajes", uc.findEnviadosByUsername(username));
		
//		model.put("mensajes", uc.findAll());
		return "enviados";
	}
	
}
