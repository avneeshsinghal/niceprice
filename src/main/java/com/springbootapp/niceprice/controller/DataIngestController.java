package com.springbootapp.niceprice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootapp.niceprice.dto.ProductDTO;
import com.springbootapp.niceprice.dto.ShelfDTO;
import com.springbootapp.niceprice.dto.ShelfDataIngestDTO;
import com.springbootapp.niceprice.service.ProductService;
import com.springbootapp.niceprice.service.ShelfService;
import com.springbootapp.niceprice.service.UserService;

import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequestMapping("/dataIngest")
@RestController
@Validated
public class DataIngestController {

	ProductService productService;
	UserService userService;
	ShelfService shelfService;
	
	DataIngestController(ProductService productService,ShelfService shelfService){
		this.productService = productService;
		this.shelfService = shelfService;
	}
	
	@PostMapping("/addProductList")
	public ResponseEntity<List<ProductDTO>> createProduct(@Valid @RequestBody List<ProductDTO> productDTOList){
		List<ProductDTO>  addedProductList = productService.createBulkProducts(productDTOList) ;
		return new ResponseEntity<>(addedProductList, HttpStatus.CREATED);
	}
	
	@PostMapping("/addShelfList")
	public ResponseEntity<List<ShelfDTO>> addProductstoShelf(@Valid @RequestBody List<ShelfDataIngestDTO> shelfDTOList){
		
		List<ShelfDTO>  addedProductList = shelfService.addBulkProductsToShelf(shelfDTOList) ;
		return new ResponseEntity<>(addedProductList, HttpStatus.CREATED);
	}
	
	
}
