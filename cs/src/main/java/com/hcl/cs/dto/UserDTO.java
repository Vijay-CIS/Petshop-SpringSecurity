package com.hcl.cs.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.hcl.cs.model.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {

	private Long userId;
	@NotEmpty(message = "Username should not be empty")

	private String userName;
	@NotEmpty(message = "Password should not be empty")

	private String userPassword;
	@NotEmpty(message = "password should not be empty")
	private String confirmPassword;

	private List<Integer> roles = new ArrayList<>();
}
