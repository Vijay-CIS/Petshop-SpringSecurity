package com.hcl.cs.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.cs.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserName(String userName);
  Optional <User>  findByUserNameAndUserPassword(String userName, String userPassword);
  Optional <User>  findByUserId(Long userId);


}