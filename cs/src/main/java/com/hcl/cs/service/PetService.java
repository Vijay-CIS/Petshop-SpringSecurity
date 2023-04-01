package com.hcl.cs.service;

import java.util.List;
import com.hcl.cs.model.Pet;

public interface PetService {
	 void savePet(Pet pet);
     List<Pet> fetchAllPet();
	List<Pet> fetchAllPet(Long userId);
	Pet findByPetId(Long petId);
	void updatePet(Pet pet);
	void buyPet(Pet pet);

}
