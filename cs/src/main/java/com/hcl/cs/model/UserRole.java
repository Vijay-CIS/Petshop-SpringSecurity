package com.hcl.cs.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USER_ROLE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USERROLEID")
	private Integer id;

	@OneToOne
	@JoinColumn(name = "ROLEID")
	private User user;

	@OneToOne
	@JoinColumn(name = "USERID")
	private Role role;

}
