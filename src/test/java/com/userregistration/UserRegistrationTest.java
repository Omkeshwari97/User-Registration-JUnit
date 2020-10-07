package com.userregistration;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.gen5.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class UserRegistrationTest {
	
	@ParameterizedTest
	@MethodSource("provideStringsforFirstName")
	public void givenFirstName_WhenValid_ShouldReturnTrue(String fname, String result) throws UserRegistrationException
	{
		UserRegistration urobj = new UserRegistration();
		
		assertEquals(result, urobj.validateFirstName.validate(fname));	
	}
	
	private static Stream<Arguments> provideStringsforFirstName()
	{
		return Stream.of(
				Arguments.of("Abc", "Valid"),
				Arguments.of("abc","FIRST_NAME"),
				Arguments.of("Abcd","Valid"),
				Arguments.of("Ab1", "FIRST_NAME")
				);
	}

	@ParameterizedTest
	@MethodSource("provideStringsforLastName")
	public void givenLastName_WhenValid_ShouldReturnTrue(String lname, String result) throws UserRegistrationException
	{
		UserRegistration urobj = new UserRegistration();
		assertEquals(result, urobj.validateLastName.validate(lname));
	}	
	
	private static Stream<Arguments> provideStringsforLastName() 
	{
		return Stream.of(
		Arguments.of("ABCD", "Valid"),
		Arguments.of("123", "LAST_NAME"),
		Arguments.of("A1d", "LAST_NAME"),
		Arguments.of("Ab1c3", "LAST_NAME")
		);
	}
	
	@ParameterizedTest
	@MethodSource("provideStringsforEmail")
	public void givenEmail_WhenValid_ShouldReturnTrue(String email, String result) throws UserRegistrationException 
	{
		UserRegistration urobj = new UserRegistration();
		assertEquals(result,urobj.validateEmail.validate(email));
	}
	
	private static Stream<Arguments> provideStringsforEmail()
	{
		return Stream.of(
				Arguments.of("abc@yahoo.com","Valid"),
				Arguments.of("abc-100@yahoo.com","Valid"),
				Arguments.of("abc.100@yahoo.com","Valid"),
				Arguments.of("abc111@abc.com","Valid"),
				Arguments.of("abc-100@abc.net","Valid"),
				Arguments.of("abc.100@abc.com.au","Valid"),
				Arguments.of("abc@1.com","Valid"),
				Arguments.of("abc@gmail.com.com","Valid"),
				Arguments.of("abc+100@gmail.com","Valid"),
				Arguments.of("abc","EMAIL"),
				Arguments.of("abc123@gmail.a","EMAIL"),
				Arguments.of("abc123@.com","EMAIL"),
				Arguments.of("abc123@.com.com","EMAIL"),
				Arguments.of(".abc@abc.com","EMAIL"),
				Arguments.of("abc()*@gmail.com","EMAIL"),
				Arguments.of("abc@%*.com","EMAIL"),
				Arguments.of("abc..2002@gmail.com","EMAIL"),
				Arguments.of("abc.@gmail.com","EMAIL"),
				Arguments.of("abc@abc@gmail.com","EMAIL"),
				Arguments.of("abc@gmail.com.1a","EMAIL"),
				Arguments.of("abc@gmail.com.aa.au","EMAIL")
				);
	}
	
	@ParameterizedTest
	@MethodSource("provideStringsforMobileNumber")
	public void givenMobileNumber_WhenValid_ShouldReturnTrue(String mobile, String result) throws UserRegistrationException
	{
		UserRegistration urobj = new UserRegistration();
		assertEquals(result, urobj.validateMobileNumber.validate(mobile));
	}	

	private static Stream<Arguments> provideStringsforMobileNumber()
	{
		return Stream.of(
		Arguments.of("91 9876543211", "Valid"),
		Arguments.of("919876543211", "MOBILE_NUMBER"),
		Arguments.of("91 98765 43211", "MOBILE_NUMBER"),
		Arguments.of("9876543210", "MOBILE_NUMBER")
		);
	}
	
	@ParameterizedTest
	@MethodSource("provideStringsforPassword")
	public void givenPassword_WhenValid_ShouldReturnTrue(String password, String result) throws UserRegistrationException 
	{
		UserRegistration urobj = new UserRegistration();
		assertEquals(result, urobj.validatePassword.validate(password));
	}
	
	private static Stream<Arguments> provideStringsforPassword()
	{
		return Stream.of(
		Arguments.of("abcd1234", "PASSWORD"),
		Arguments.of("abcd@123", "PASSWORD"),
		Arguments.of("123456790", "PASSWORD"),
		Arguments.of("abc@97", "PASSWORD"),
		Arguments.of("aBcd1234", "PASSWORD"),
		Arguments.of("abcd@123Te", "Valid"),
		Arguments.of("abcdEFGHo", "PASSWORD"),
		Arguments.of("adc@WERtp@", "PASSWORD"),
		Arguments.of("abc123f", "PASSWORD"),
		Arguments.of("1234TEDXKL", "PASSWORD")
		);
	}
}
