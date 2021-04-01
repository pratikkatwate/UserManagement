package com.neosoft.userManagment.service;

import java.util.List;
import java.util.Map;

import com.neosoft.userManagment.model.User;

public interface UserServiceInterface {
	
	public User registerUser(User u);
	public User getUser(int uid);
	public User editUser(User u);
	public void hardDeleteUser(int id);
	public void softDeleteUser(int id);
	public List<User> sortUsers();
	public User findUserByNameSurnamePincode(Map<String, String> searchParam);
	public List<User> getAllUsers();
	 
}
