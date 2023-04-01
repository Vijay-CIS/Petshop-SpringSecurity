package com.hcl.cs.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;



import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="USERID")
	private Long userId;
    @NotEmpty(message = "Username should not be empty")
    @Column(name="USERNAME")
	private String userName;
    @NotEmpty(message = "Password should not be empty")
    @Column(name="USERPASSWORD")
	private String userPassword;
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Pet> pets = new ArrayList <>();
	
	 @OneToMany(cascade = CascadeType.ALL)
	 @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "USERID"), inverseJoinColumns = @JoinColumn(name = "ROLEID"))
    private List<Role> roles = new ArrayList<>() ;	
	 
}
