package com.springbootapp.niceprice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootapp.niceprice.dto.ProductDTO;
import com.springbootapp.niceprice.service.ProductService;

import jakarta.validation.Valid;

@RequestMapping("/products")
@RestController
public class ProductController {
	

	ProductService productService ;
	
	
	ProductController(ProductService productService){
		this.productService = productService;
	}
	
	@GetMapping("/allProducts")
	public ResponseEntity<List<ProductDTO>> fetchAllProducts(){
		List<ProductDTO>  productList = productService.fetchAllProducts() ;
		return new ResponseEntity<>(productList, HttpStatus.OK);
		
	} 
	
	@PostMapping("/createProduct")
	public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductDTO productDTO){
		ProductDTO  product = productService.createProduct(productDTO) ;
		return new ResponseEntity<>(product, HttpStatus.CREATED);
	}
}
