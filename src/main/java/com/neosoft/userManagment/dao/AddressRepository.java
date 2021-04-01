package com.neosoft.userManagment.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.userManagment.model.Address;

public interface AddressRepository extends JpaRepository<Address,Integer>  {

		List<String> findByPincode(String pincode);
}
