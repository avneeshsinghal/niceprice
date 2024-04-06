package com.springbootapp.niceprice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(unique=true)
	private String userId;
	@NotBlank(message = "Name is mandatory")
	private String name;
	@NotBlank(message = "Email is mandatory")
	private String email;
	
	
}


