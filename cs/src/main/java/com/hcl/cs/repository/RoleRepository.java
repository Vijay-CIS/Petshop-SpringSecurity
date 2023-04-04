package com.hcl.cs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.cs.model.Role;
import com.hcl.cs.model.User;

public interface  RoleRepository extends JpaRepository<Role,Integer>  {

}
