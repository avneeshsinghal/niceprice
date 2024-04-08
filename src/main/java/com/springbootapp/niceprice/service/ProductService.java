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
	
	static ProductRepo productRepo;
	
	ProductService(ProductRepo productRepo){
		ProductService.productRepo  = productRepo;
	}

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
	
	public static ProductDTO fetchProductById(String productId) {

		Product checkedProduct = productRepo.findFirstByProductId(productId).orElse(null);
		
		if(checkedProduct == null){
	        throw new ProductAlreadyExistsException("Product does not exists with the given Product ID.");
	    }
        return ProductMapper.INSTANCE.mapProducttoProductDTO(checkedProduct);
	}
	
	public List<ProductDTO> createBulkProducts(List<ProductDTO> productDTOList){
		
//		Product addedProduct = ProductMapper.INSTANCE.mapProductDTOtoProduct(productDTOList);
//		Product checkedProduct = productRepo.findFirstByProductId(addedProduct.getProductId()).orElse(null);
//		Stream productStream = productDTOList.stream().map(ProductMapper.INSTANCE::mapProductDTOtoProduct);
//		Long repeatingCount = .filter(product->productRepo.existsByProductId(product.getProductId())).count();
		
		
//		if(checkedProduct != null){
//	        throw new ProductAlreadyExistsException("Product already exists with the given Product ID.");
//	    }
		List<Product> productList = productDTOList.stream().map(ProductMapper.INSTANCE::mapProductDTOtoProduct).collect(Collectors.toList());
		
        return productRepo.saveAll(productList).stream().map(ProductMapper.INSTANCE::mapProducttoProductDTO).collect(Collectors.toList());
	}


	
	
	
}
