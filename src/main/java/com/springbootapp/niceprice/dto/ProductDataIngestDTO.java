package com.springbootapp.niceprice.dto;

import java.util.HashSet;
import java.util.Set;

import com.springbootapp.niceprice.entity.BaseEntity;
import com.springbootapp.niceprice.entity.Product;
import com.springbootapp.niceprice.entity.Shelf;
import com.springbootapp.niceprice.entity.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDataIngestDTO extends BaseEntity {

	@Column(unique=true)
	@NotBlank(message = "productId is mandatory")
	private String productId;
	
	private Double relevancyScore;
	
	
	
}
