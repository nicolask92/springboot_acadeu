package com.acadeu.web.app.cotrollers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.acadeu.web.app.entity.User;
import com.acadeu.web.app.exception.CustomeFieldValidationException;
import com.acadeu.web.app.repository.RoleRepository;
import com.acadeu.web.app.repository.UserRepository;
import com.acadeu.web.app.services.UserService;

@Controller
public class UserController {

	private final String TAB_LIST = "listTab";

	@Autowired
	UserService userService;

	@Autowired
	RoleRepository roleRepository;



	private void baseAttributerForUserForm(Model model, User user, String activeTab) {
		model.addAttribute("userForm", user);
		model.addAttribute("userList", userService.getAllUsers());
		model.addAttribute("roles", roleRepository.findAll());
		model.addAttribute(activeTab, "active");
	}

	@GetMapping("/usuarios")
	public String userForm(Model model) {
		baseAttributerForUserForm(model, new User(), TAB_LIST);
		return "usuarios";
	}


}
