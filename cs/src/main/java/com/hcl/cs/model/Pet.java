package com.hcl.cs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pet")
public class Pet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PETID")
	private Long petId;
	@NotEmpty
	@Column(name = "PETNAME")
	private String petName;
	@NotNull
	@Column(name = "PETAGE")
	private Integer petAge;
	@NotEmpty
	@Column(name = "PETPLACE")
	private String petPlace;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PETOWNERID")
	private User user;
	@Column(name = "available")
	private boolean available;

}
