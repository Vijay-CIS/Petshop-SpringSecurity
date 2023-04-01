package com.hcl.cs.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.cs.model.Pet;
import com.hcl.cs.model.User;
import com.hcl.cs.repository.PetRepository;

@Service
public class PetServiceImpl implements PetService{
     
	@Autowired
	private PetRepository petRepository;

	@Override
	public List<Pet> fetchAllPet() {
		List<Pet> list =petRepository.findAll();
		return list;
	}

	@Override
	public void savePet(Pet pet) {
		pet.setAvailable(true);
		petRepository.save(pet);
		
	}

	@Override
	public List<Pet> fetchAllPet(Long userId) {
		List<Pet> list =petRepository.findByUserId(userId);
		return list;
		
	}

	@Override
	public Pet findByPetId(Long petId) {
		Pet pet = petRepository.findByPetId(petId).orElse(null);
		if(pet==null) {
			throw new RuntimeException("Invalid Pet ID");
		}
		return pet;
	}

	@Override
	public void updatePet(Pet pet) {
		petRepository.save(pet);
		
	}
	
	public void buyPet(Pet pet) {
		pet.setAvailable(false);
		petRepository.save(pet);
		
	}
	
	

}
