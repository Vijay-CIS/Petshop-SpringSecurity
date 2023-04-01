package com.hcl.cs.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hcl.cs.model.Pet;

public interface PetRepository extends JpaRepository<Pet,Long> {
     @Query("select p from Pet p where p.user.userId=:userId")
	List<Pet> findByUserId(@Param("userId") Long userId);

	

	Optional<Pet> findByPetId(Long petId);

}
