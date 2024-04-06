package com.springbootapp.niceprice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(unique=true)
	
	
	private String productId;
	@NotBlank(message = "Category is mandatory")
	private String category;
	@NotBlank(message = "Brand is mandatory")
	private String brand;
	
	
}


