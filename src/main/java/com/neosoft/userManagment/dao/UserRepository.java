package com.neosoft.userManagment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.neosoft.userManagment.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query(value ="Select * from user_table u "
			+ "inner join Address a on u.address_id=a.address_id"
			+ " where u.name = :name AND u.surname = :surname AND a.pincode = :pincode",
			nativeQuery=true)
	public User findByNameAndSurnameAndPincode(@Param("name") String name,@Param("surname") String surname,@Param("pincode") String pincode);
	
//	@Query(value ="Select * from user_table u where u.name = :name AND u.surname = :surname",
//			nativeQuery = true)
//	public User findUserByUnandSn(@Param("name")String name,@Param("surname")String surname);
//	
//	public User findUserByNameAndSurname(String name,String surname);
//	
	
}
