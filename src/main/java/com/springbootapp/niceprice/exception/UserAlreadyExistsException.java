package com.springbootapp.niceprice.exception;

public class UserAlreadyExistsException extends Exception {
	
	public UserAlreadyExistsException(String message){
        super(message);
    }

}
