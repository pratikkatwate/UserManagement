package com.neosoft.userManagment.service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.userManagment.dao.UserRepository;
import com.neosoft.userManagment.model.User;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserService implements UserServiceInterface {

	@Autowired
	UserRepository re;
	
	@Override
	public User registerUser(User u) throws ValidationException{
		return re.save(u);
	}
	
	@Override
	public User getUser(int uid) throws NoSuchElementException{
		User u = re.findById(uid).get();
		if(u.isStatus()==true) {
			return null;
		}
		else {
			return u;
		}
		
		
	}

	@Transactional(rollbackOn = {ValidationException.class, NullPointerException.class})
	@Override
	public User editUser(User u){
		System.out.println("Before Updating \n"+u);
		try {
			User user = re.getOne(u.getUserId());
			user = u;
			User savedUser = re.save(user);
					//re.save(u);
			if(user.equals(savedUser)) {
				return savedUser;
			}else {
				throw new NullPointerException();
			}
		}catch (ValidationException e) {
			System.out.println("validation Failed Due to"+e.getMessage());
			return null;
		}
	}

	@Override
	public void hardDeleteUser(int id) {
		re.deleteById(id);
	}

	@Override
	public void softDeleteUser(int id) {
		User u = re.findById(id).get();
		u.setStatus(true);
		re.save(u);
	}

	@Override
	public List<User> sortUsers() {
		List<User> ulist = re.findAll().stream().filter(u -> u.isStatus() == false ).collect(Collectors.toList());
		Comparator<User> sortByDob =(p1, p2) -> p1.getDob().compareTo(p2.getDob()); 
		
		Comparator<User> sortByDoj =(p1, p2) -> p1.getDoj().compareTo(p2.getDoj()); 
		
		ulist = ulist.stream()
		.sorted(sortByDob
				.thenComparing(sortByDoj))
				.collect(Collectors.toList());
//		.forEach(
//				user->
//				System.out.println(user)
//				);		
		System.out.println(ulist);
		
		return ulist;
	}

	@Override
	public User findUserByNameSurnamePincode(Map<String,String> searchParam) {
		System.out.println("finding user by name surname and pincode");
		User u =  re.findByNameAndSurnameAndPincode(searchParam.get("name"),searchParam.get("surname"),searchParam.get("pincode"));
		System.out.println(searchParam.get("name")+" "+searchParam.get("surname")+" "+searchParam.get("pincode"));
		System.out.println(u);
		return u;
	}

	@Override
	public List<User> getAllUsers() {
		return re.findAll();
	}

	public UserService() {
		// TODO Auto-generated constructor stub
	}
}
