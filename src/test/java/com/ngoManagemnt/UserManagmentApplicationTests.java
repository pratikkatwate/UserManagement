package com.ngoManagemnt;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.neosoft.userManagment.model.Address;
import com.neosoft.userManagment.model.User;
import com.neosoft.userManagment.service.UserServiceInterface;

@SpringBootTest
class UserManagmentApplicationTests {

	
	@Test
	void contextLoads() {
	}

}
