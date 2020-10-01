package com.userregistration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserRegistrationTest {

	boolean result;
	
	/*
	@Test
	public void givenFirstName_WhenValid_ShouldReturnTrue()
	{
		UserRegistration urobj = new UserRegistration();
		result=urobj.validateFirstName("Abc");
		assertEquals(true,result);
		result=urobj.validateFirstName("abc");
		assertEquals(false,result);
		result=urobj.validateFirstName("Abcd");
		assertEquals(true,result);
		result=urobj.validateFirstName("Ab1");
		assertEquals(false,result);
	}*/

	/*
	@Test
	public void givenLastName_WhenValid_ShouldReturnTrue()
	{
		UserRegistration urobj = new UserRegistration();
		result=urobj.validateLastName("ABCD");
		assertEquals(true,result);
		result=urobj.validateLastName("123");
		assertEquals(false,result);
		result=urobj.validateLastName("A1d");
		assertEquals(false,result);
		result=urobj.validateLastName("Ab1c3");
		assertEquals(false,result);
	}*/
	
	/*
	@Test
	public void givenEmail_WhenValid_ShouldReturnTrue()
	{
		UserRegistration urobj = new UserRegistration();
		result=urobj.validateEmail("abc.xyz@bl.co.in");
		assertEquals(true,result);
		result=urobj.validateEmail("abc");
		assertEquals(false,result);
		result=urobj.validateEmail("abc.100@abc.com.au");
		assertEquals(true,result);
		result=urobj.validateEmail("abc@%*.com");
		assertEquals(false,result);
	}*/
	
	/*
	@Test
	public void givenMobileNumber_WhenValid_ShouldReturnTrue()
	{
		UserRegistration urobj = new UserRegistration();
		result=urobj.validateMobileNumber("91 9876543211");
		assertEquals(true,result);
		result=urobj.validateMobileNumber("919876543211");
		assertEquals(false,result);
		result=urobj.validateMobileNumber("91 98765 43211");
		assertEquals(false,result);
		result=urobj.validateMobileNumber("9876543210");
		assertEquals(false,result);
	}*/
	
	@Test
	public void givenPassword_WhenValid_ShouldReturnTrue()
	{
		UserRegistration urobj = new UserRegistration();
	
		result=urobj.validatePassword("abcd1234");
		assertEquals(false,result);
		result=urobj.validatePassword("abcd@123");
		assertEquals(false,result);
		result=urobj.validatePassword("123456790");
		assertEquals(false,result);
		result=urobj.validatePassword("abc@97");
		assertEquals(false,result);
		result=urobj.validatePassword("aBcd1234");
		assertEquals(false,result);
		result=urobj.validatePassword("abcd@123Te");
		assertEquals(true,result);
		result=urobj.validatePassword("abcdEFGHo");
		assertEquals(false,result);
		result=urobj.validatePassword("adc@WERtp_");
		assertEquals(false,result);
		result=urobj.validatePassword("abc123f");
		assertEquals(false,result);
		result=urobj.validatePassword("1234TEDXKL");
		assertEquals(false,result);
	}
	
	
}
