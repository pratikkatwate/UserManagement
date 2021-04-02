package com.ngoManagemnt;

import org.springframework.boot.test.context.SpringBootTest;

import com.neosoft.userManagment.UserManagmentApplication;

@SpringBootTest(classes = { UserManagmentApplication.class})
class UserManagmentApplicationTests {
/*
	@Test
	void contextLoads() {
	}
	
	@MockBean
	UserRepository ur;
	UserService userService = new UserService(ur);
	
	@Test
	public void testRegisterUser() throws ParseException {
		
		if(userService != null && ur != null) {
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date udob = sdf1.parse("11/09/1993");
		Date dob = new Date(udob.getTime());
		java.util.Date udoj = sdf1.parse("22/08/2021");
		Date doj = new Date(udoj.getTime());
		
		Address addr = new Address(5,"133/B Vrindavan Colony","Navechi Wadi","Wai","412803","Maharashta","India");
		User user = new User(5,"adsdka.saskjn","hjfsa#ds","asad","asda","abc123@gmail.com","9096848182",dob,doj,"A+",false,addr);
		Mockito.when(ur.findById(5)).thenReturn(Optional.of(user));
		User regUser = userService.registerUser(user);
		assertThat(regUser).isNotNull();
		}
		else {
			throw new TestAbortedException("User Service bean is null");
		}
	}
	
	@Test
	public void testGetUser() {	
		User user = userService.getUser(2);
		System.out.println(user);
		assertThat(user.isStatus()).isEqualTo(false);
	}
*/
}
