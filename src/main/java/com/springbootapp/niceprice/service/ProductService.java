package com.springbootapp.niceprice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootapp.niceprice.dto.ProductDTO;
import com.springbootapp.niceprice.entity.Product;
import com.springbootapp.niceprice.exception.ProductAlreadyExistsException;
import com.springbootapp.niceprice.mapper.ProductMapper;
import com.springbootapp.niceprice.repo.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	ProductRepo productRepo;

	public List<ProductDTO> fetchAllProducts() {
		
		List<Product>  ProductList = productRepo.findAll();
		return ProductList.stream().map(ProductMapper.INSTANCE::mapProducttoProductDTO).collect(Collectors.toList());
	}
	
	public ProductDTO createProduct(ProductDTO productDTO) {

		Product addedProduct = ProductMapper.INSTANCE.mapProductDTOtoProduct(productDTO);
		Product checkedProduct = productRepo.findFirstByProductId(addedProduct.getProductId()).orElse(null);
		
		if(checkedProduct != null){
	        throw new ProductAlreadyExistsException("Product already exists with the given Product ID.");
	    }
        return ProductMapper.INSTANCE.mapProducttoProductDTO(productRepo.save(addedProduct));
	}


	
	
	
}
