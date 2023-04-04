package com.hcl.cs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hcl.cs.model.Pet;
import com.hcl.cs.model.User;
import com.hcl.cs.service.PetService;
import com.hcl.cs.service.UserService;

@Controller
public class OrderController {

	@Autowired
	private PetService petService;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/buyproduct/{petId}", method = RequestMethod.GET)
	public String buyProduct(@PathVariable("petId") Long petId, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return "redirect:/signin";
		}
		User owner = userService.findByUserId(user.getUserId());
		Pet pet = petService.findByPetId(petId);
		pet.setUser(owner);

		petService.buyPet(pet);
		return "redirect:/home";
	}
}
