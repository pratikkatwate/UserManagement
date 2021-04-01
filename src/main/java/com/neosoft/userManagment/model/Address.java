package com.neosoft.userManagment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Address {
	
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;
	
	@Length(max = 128, message = "Size cannot exceed 128 chars")
	@NotEmpty(message = "Please Enter Address")
	private String addressLine1;
	
	@Length(max = 128, message = "Size cannot exceed 128 chars")
	@NotEmpty(message = "Please Enter Pincode")
	private String addressLine2;
	
	@Pattern(regexp = "[a-zA-Z]+")
	@NotEmpty(message = "Please Enter City")
	private String city;
	
	@Pattern(regexp ="[0-9]{6}")
	@Size(min = 6,max = 6, message = "Enter Valid Pin Code")
	@NotEmpty(message = "Please Enter Pincode")
	private String pincode;
	
	@Pattern(regexp = "[a-zA-Z]+")
	@NotEmpty(message = "Please Enter State")
	private String state;
	
	@Pattern(regexp = "[a-zA-Z]+")
	@NotEmpty(message = "Please Enter Country")
	private String country;
}
