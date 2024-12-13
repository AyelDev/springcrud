package com.ayeldev.springcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ayeldev.springcrud.model.User;
import com.ayeldev.springcrud.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// display list of employees
	@GetMapping("/")
	public String vieHomePage(Model model) {
		model.addAttribute("listUsers", userService.getAllUsers());
		return "index";
	}
	
	@GetMapping("/showNewUserForm")
	public String showNewUserForm(Model model) {
		//create model attribute to bind form data
		User user = new User();
		model.addAttribute("user", user);
		return "new_user";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User user) {
		// save user to database
		userService.saveUser(user);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
		
		//get user from service
		User user = userService.getUserId(id);
		
		//set employee as a model attribute to pre-populate the form
		model.addAttribute("user", user);
		
		return "update_user";
	}
	
	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable(value= "id") long id) {
		//call delete user method
		this.userService.deleteUserById(id);
		return "redirect:/";
	}
	
}
