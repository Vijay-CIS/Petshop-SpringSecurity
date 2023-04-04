package com.hcl.cs.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hcl.cs.dto.UserDTO;
import com.hcl.cs.model.Role;
import com.hcl.cs.model.User;
import com.hcl.cs.repository.RoleRepository;
import com.hcl.cs.service.UserService;
import com.hcl.cs.validator.UserValidator;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserValidator userValidator;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("userForm", new UserDTO());

		return "register";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@ModelAttribute("userForm") UserDTO userForm, BindingResult bindingResult, Model model) {
		userValidator.validate(userForm, bindingResult);
		if (bindingResult.hasErrors()) {
			return "register";
		}
		System.out.println(userForm.getRoles());
		User user = new User();
		user.setUserName(userForm.getUserName());
		user.setUserPassword(userForm.getUserPassword());
		List<Role> roles = new ArrayList<>();
		for (Integer roleId : userForm.getRoles()) {
			Role role = roleRepository.findById(roleId).orElse(null);
			if (role != null) {
				roles.add(role);
			}
		}
		user.setRoles(roles);

		userService.save(user);
		return "redirect:/home";
	}

	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		System.out.println("login get");
		if (error != null)
			model.addAttribute("error", "Your Username and Password is Invalid");
		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");
		model.addAttribute("userForm", new User());
		return "login";
	}

	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String login(@ModelAttribute("userForm") User userForm, HttpSession session, Model model) {
		try {
			// System.out.println("userForm:"+ userForm);
			User user = userService.findByUsernameAndPassword(userForm.getUserName(), userForm.getUserPassword());
			// System.out.println("user" + user);

			session.setAttribute("user", user);
			return "redirect:/home";
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			e.printStackTrace();
			return "login";
		}

	}

	@GetMapping("/viewProfile")
	public String viewProfile(Model model, HttpSession session) {
		// User user = new User();
		User user = (User) session.getAttribute("user");

		if (user == null) {
			return "redirect:/signin";
		}
		User userDetail = userService.findByUserId(user.getUserId());
		userDetail.setUserPassword("");

		model.addAttribute("profileForm", userDetail);
		return "profile";
	}

	@RequestMapping(value = "/updateProfile", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute("profileForm") User userForm, BindingResult bindingResult, Model model) {
		System.out.println("Update user Started -post");
		userService.save(userForm);
		System.out.println("update Profile Completed -post");
		return "redirect:/viewProfile";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		System.out.println("logout");
		session.invalidate();
		return "redirect:/signin";
	}

}
