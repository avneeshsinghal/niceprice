package com.springbootapp.niceprice.exception;

public class ProductAlreadyExistsException extends RuntimeException {
	
	public ProductAlreadyExistsException(String message){
        super(message);
    }

}
