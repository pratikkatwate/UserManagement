package com.ngoManagemnt;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.opentest4j.TestAbortedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.neosoft.userManagment.UserManagmentApplication;
import com.neosoft.userManagment.dao.UserRepository;
import com.neosoft.userManagment.model.Address;
import com.neosoft.userManagment.model.User;
import com.neosoft.userManagment.service.UserService;

@AutoConfigureMockMvc
@SpringBootTest(classes = { UserManagmentApplication.class})
public class UserServiceTest {
	
	@Autowired
	UserService userService;
	
	UserRepository re = Mockito.mock(UserRepository.class);
	
	@Test
	public void testRegisterUser() throws ParseException {
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date udob = sdf1.parse("11/09/1993");
		Date dob = new Date(udob.getTime());
		java.util.Date udoj = sdf1.parse("22/08/2021");
		Date doj = new Date(udoj.getTime());
		
		Address addr = new Address(5,"133/B Vrindavan Colony","Navechi Wadi","Wai","412803","Maharashta","India");
		User user = new User(5,"adsdka.saskjn","hjfsa#ds","asad","asda","abc123@gmail.com","9096848182",dob,doj,"A+",false,addr);
		Mockito.when(re.findById(5)).thenReturn(Optional.of(user));
		User regUser = userService.registerUser(user);
		assertThat(regUser).isNotNull();

	}
	
	@Test
	public void testGetUser() {	
		User user = userService.getUser(3);
		System.out.println(user);
		assertThat(user.isStatus()).isEqualTo(false);
	}
	
}
