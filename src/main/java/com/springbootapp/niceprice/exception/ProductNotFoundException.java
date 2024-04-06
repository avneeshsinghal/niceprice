package com.springbootapp.niceprice.exception;

public class ProductNotFoundException extends RuntimeException {
	
	public ProductNotFoundException(String message){
        super(message);
    }

}
