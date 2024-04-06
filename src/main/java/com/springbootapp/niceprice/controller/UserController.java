package com.springbootapp.niceprice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootapp.niceprice.dto.UserDTO;
import com.springbootapp.niceprice.service.UserService;

@RequestMapping("/user")
@RestController
public class UserController {
	
UserService userService ;
	
	
	UserController(UserService userService){
		this.userService = userService;
	}
	
	@GetMapping("/allUsers")
	public ResponseEntity<List<UserDTO>> fetchAllUsers(){
		List<UserDTO>  userList = userService.fetchAllUsers() ;
		return new ResponseEntity<>(userList, HttpStatus.OK);
		
	} 
	
//	@PostMapping("/createUser")
//	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
//		UserDTO  user = userService.createUser(userDTO) ;
//		return new ResponseEntity<>(user, HttpStatus.CREATED);
//	}

}
