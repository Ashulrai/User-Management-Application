package com.sample.usermanagement.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sample.usermanagement.model.User;
import com.sample.usermanagement.service.IUserService;

@Controller
public class UserController {

	@Autowired
	private IUserService userService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// Date - dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value = "/user-list", method = RequestMethod.GET)
	public String showTodos(ModelMap model) {		
		String name = getLoggedInUserName(model);
		System.out.println("Inside Controller :: getting user list for :: "+name);
		model.put("users", userService.getUsersByUser(name));
		// model.put("user", service.retrieveTodos(name));
		return "user-list";
	}

	private String getLoggedInUserName(ModelMap model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}

		return principal.toString();
	}

	@RequestMapping(value = "/add-user", method = RequestMethod.GET)
	public String showUserPage(ModelMap model) {
		model.addAttribute("user", new User());
		return "user";
	}

	@RequestMapping(value = "/delete-user", method = RequestMethod.GET)
	public String deleteUser(@RequestParam long id) {
		userService.deleteuser(id);
		// service.deleteTodo(id);
		return "redirect:/user-list";
	}

	@RequestMapping(value = "/update-user", method = RequestMethod.GET)
	public String showUpdateUserPage(@RequestParam long id, ModelMap model) {
		User user = userService.getUserById(id).get();
		model.put("user", user);
		return "user";
	}

	@RequestMapping(value = "/update-user", method = RequestMethod.POST)
	public String updateUser(ModelMap model, @Valid User user, BindingResult result) {

		if (result.hasErrors()) {
			return "user";
		}

		
		user.setUserName(getLoggedInUserName(model));
		userService.updateuser(user);
		return "redirect:/user-list";
	}

	@RequestMapping(value = "/add-user", method = RequestMethod.POST)
	public String addUser(ModelMap model, @Valid User user, BindingResult result) {
System.out.println("Adding User to DB");
		if (result.hasErrors()) {
			return "user";
		}

		user.setUserName(getLoggedInUserName(model));
		userService.saveuser(user);
		return "redirect:/user-list";
	}
}
