package com.springbootapp.niceprice.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO extends BaseEntityDTO {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotNull(message = "ProductID is mandatory")
	@NotBlank(message = "ProductID is mandatory")
	private String productId;
	private String category;
	private String brand;
	
	
}


