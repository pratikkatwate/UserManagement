package com.neosoft.userManagment.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.userManagment.model.User;
import com.neosoft.userManagment.service.UserServiceInterface;

@CrossOrigin("*")
@RestController
@RequestMapping("/usercontroller")
public class UserController {
	
	@Autowired(required= true)
	UserServiceInterface userService;
	
	@GetMapping("/")
	public String hello() throws ParseException {
		
		return "******** WELCOME TO USER CONTROLLER ********";
		
	}
	
	@PostMapping("/registerUser")
	public ResponseEntity<Object> registereUser(@RequestBody User user) {
		try {
			if(user==null) {
				throw new NullPointerException(); 
			}
			return new ResponseEntity<>(userService.registerUser(user),HttpStatus.CREATED);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/getUser/{id}")
	public ResponseEntity<Object>  getUser(@PathVariable int id) {
		try {
			User user = userService.getUser(id);
			if(user==null) {
				throw new NullPointerException(); 
			}
			else {
				return new ResponseEntity<>(user,HttpStatus.OK);
			}
		} catch (NullPointerException | NoSuchElementException e) {
			return new ResponseEntity<>("User Does Not Exists",HttpStatus.NOT_FOUND);
		}

	}
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllUsers(){
		try {
			List<User> ulist = userService.getAllUsers();
			if(ulist==null) {
				throw new NullPointerException(); 
			}
			return new ResponseEntity<List<User>>(ulist,HttpStatus.OK);
			
		} catch (NullPointerException e) {
			return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/editUser")
	public ResponseEntity<Object> editUser(@RequestBody User u){
		try {
			User user = userService.editUser(u);
			if(user==null) {
				throw new NullPointerException(); 
			}
			return new ResponseEntity<>(user,HttpStatus.OK);
			
		}catch (NullPointerException e) {
			return new ResponseEntity<>("User Not Found!",HttpStatus.NOT_FOUND);
		}catch (ValidationException  e1) {
			return new ResponseEntity<>("Validation Failed!"+e1.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/hardDeleteUser/{id}")
	public ResponseEntity<Object> hardDeleteUser(@PathVariable int id ) {
		try {
			userService.hardDeleteUser(id);	
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return  new ResponseEntity<>("User Does Not Exists",HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/softDeleteUser/{id}")
	public ResponseEntity<Object> softDeleteUser(@PathVariable int id ) {
		try {
			userService.softDeleteUser(id);	
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return  new ResponseEntity<>("User Does Not Exists",HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping("/sortUsers")
	public ResponseEntity<Object> sortUsers(){
		try {
			List<User> ulist = userService.sortUsers();	
			return new ResponseEntity<>(ulist, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return  new ResponseEntity<>("User Does Not Exists",HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/findUser")
	public ResponseEntity<Object> findUserByNameSurnamePincode(@RequestBody Map<String,String> searchParam){
		//System.out.println(searchParam.get("name")+" "+searchParam.get("surname")+" "+searchParam.get("pincode"));
		try {
			User u = userService.findUserByNameSurnamePincode(searchParam);
			if(u==null) {
				throw new NullPointerException(); 
			}
			return new ResponseEntity<>(u,HttpStatus.OK);
			
		} catch (NullPointerException e) {
			return new ResponseEntity<>("User Does Not Exists",HttpStatus.NOT_FOUND);
		}

	}

}

