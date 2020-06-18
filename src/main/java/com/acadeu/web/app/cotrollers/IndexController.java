package com.acadeu.web.app.cotrollers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.acadeu.web.app.services.IMensajesCrud;
import com.acadeu.web.app.services.UserServiceImpl;


@Controller
public class IndexController {

	@Autowired
	private UserServiceImpl userLogged;

	@Autowired
    private IMensajesCrud uc;
	
	
	@RequestMapping("index")
	public String index(ModelMap model, Principal principal) throws Exception {

		
		String username = userLogged.getLoggedUser().getUsername();
	
		model.put("mensajes", uc.findRecibidosByUsername(username));
		
		return "index";
	}
	

}
