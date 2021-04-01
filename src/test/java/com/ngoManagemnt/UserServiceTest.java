package com.ngoManagemnt;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.neosoft.userManagment.model.Address;
import com.neosoft.userManagment.model.User;
import com.neosoft.userManagment.service.UserService;

public class UserServiceTest {
	@Autowired(required = true)
	UserService userService;
	
	@Test
	public void testRegisterUser() throws ParseException {
		Assertions.assertThat(userService != null).isTrue();
		//Assertions.assert(userService != null);
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date udob = sdf1.parse("11/09/1993");
		Date dob = new Date(udob.getTime());
		java.util.Date udoj = sdf1.parse("22/08/2021");
		Date doj = new Date(udoj.getTime());
		
		
		Address addr = new Address(5,"133/B Vrindavan Colony","Navechi Wadi","Wai","412803","Maharashta","India");
		User user = new User(5,"adsdka.saskjn","hjfsa#ds","asad","asda","abc123@gmail.com","9096848182",dob,doj,"A+",false,addr);
		User regUser = userService.registerUser(user);
		assertThat(regUser).isEqualTo(user);
//		assertEquals(regUser,user);
//		assertThat(user.equals(regUser));
	}
}
