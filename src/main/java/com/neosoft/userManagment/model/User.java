package com.neosoft.userManagment.model;

import java.sql.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.aspectj.weaver.bcel.BcelAccessForInlineMunger;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "UserTable")
public class User {
	
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Pattern(regexp = "^[a-zA-Z0-9]([._](?![._-])|[a-zA-Z0-9]){2,14}[a-zA-Z0-9]$",message = "Please Enter Valid Username")
	@Size(min =6 , max =15, message = "Username must be 6 to 15 characters long")
	@NotEmpty(message = "Please enter username")
	private String userName;
	
	@Size(min =6 , max =20, message = "Password must be 6 to 20 characters long")
	@NotEmpty(message = "Please enter Password")
	private String password;
	
	@Pattern(regexp = "[a-zA-Z]+")
	@NotEmpty
	private String name;
	
	@Pattern(regexp = "[a-zA-Z]+")
	@NotEmpty
	private String surname;
	
	@Email
	@NotEmpty
	private String emailId;
	
	@Length(min=10,max=10,message = "Enter 10-digit mobile number")
	@NotEmpty
	private String contactNumber;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date dob;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date doj;
	
	@Pattern(regexp = "^(A|B|AB|O)[+-]$", message = "Enter valid Blood Group {A+,A-,B+,B-,AB+,AB-,O+,O-}")
	private String bloodGroup;
	
	@Value("false")
	private boolean status;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="addressId")
	Address address;

}
