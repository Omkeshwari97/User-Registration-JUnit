package com.userregistration;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class UserRegistrationTest {

	String result;
	
	@Test
	public void givenFirstName_WhenValid_ShouldReturnTrue() throws UserRegistrationException
	{
		UserRegistration urobj = new UserRegistration();
		result=urobj.validateFirstName("Abc");
		assertEquals("Valid",result);
		result=urobj.validateFirstName("abc");
		assertEquals("FIRST_NAME",result);
		result=urobj.validateFirstName("Abcd");
		assertEquals("Valid",result);
		result=urobj.validateFirstName("Ab1");
		assertEquals("FIRST_NAME",result);
	}

	@Test
	public void givenLastName_WhenValid_ShouldReturnTrue() throws UserRegistrationException
	{
		UserRegistration urobj = new UserRegistration();
		result=urobj.validateLastName("ABCD");
		assertEquals("Valid",result);
		result=urobj.validateLastName("123");
		assertEquals("LAST_NAME",result);
		result=urobj.validateLastName("A1d");
		assertEquals("LAST_NAME",result);
		result=urobj.validateLastName("Ab1c3");
		assertEquals("LAST_NAME",result);
	}
	
	@Test
	public void givenEmail_WhenValid_ShouldReturnTrue() throws UserRegistrationException
	{
		UserRegistration urobj = new UserRegistration();
		result=urobj.validateEmail("abc.xyz@bl.co.in");
		assertEquals("Valid",result);
		result=urobj.validateEmail("abc");
		assertEquals("EMAIL",result);
		result=urobj.validateEmail("abc.100@abc.com.au");
		assertEquals("Valid",result);
		result=urobj.validateEmail("abc@%*.com");
		assertEquals("EMAIL",result);
	}
	
	@Test
	public void givenMobileNumber_WhenValid_ShouldReturnTrue() throws UserRegistrationException
	{
		UserRegistration urobj = new UserRegistration();
		result=urobj.validateMobileNumber("91 9876543211");
		assertEquals("Valid",result);
		result=urobj.validateMobileNumber("919876543211");
		assertEquals("MOBILE_NUMBER",result);
		result=urobj.validateMobileNumber("91 98765 43211");
		assertEquals("MOBILE_NUMBER",result);
		result=urobj.validateMobileNumber("9876543210");
		assertEquals("MOBILE_NUMBER",result);
	}
	
	@Test
	public void givenPassword_WhenValid_ShouldReturnTrue() throws UserRegistrationException
	{
		UserRegistration urobj = new UserRegistration();
	
		result=urobj.validatePassword("abcd1234");
		assertEquals("PASSWORD",result);
		result=urobj.validatePassword("abcd@123");
		assertEquals("PASSWORD",result);
		result=urobj.validatePassword("123456790");
		assertEquals("PASSWORD",result);
		result=urobj.validatePassword("abc@97");
		assertEquals("PASSWORD",result);
		result=urobj.validatePassword("aBcd1234");
		assertEquals("PASSWORD",result);
		result=urobj.validatePassword("abcd@123Te");
		assertEquals("Valid",result);
		result=urobj.validatePassword("abcdEFGHo");
		assertEquals("PASSWORD",result);
		result=urobj.validatePassword("adc@WERtp@");
		assertEquals("PASSWORD",result);
		result=urobj.validatePassword("abc123f");
		assertEquals("PASSWORD",result);
		result=urobj.validatePassword("1234TEDXKL");
		assertEquals("PASSWORD",result);
	}
	
	@Test
	public void givenEmailSamples_WhenValid_ShouldReturnTrue() throws UserRegistrationException
	{
		UserRegistration urobj = new UserRegistration();
		result=urobj.validateEmail("abc.xyz@bl.co.in");
		assertEquals("Valid",result);
		result=urobj.validateEmail("abc.xyz@bl.co.in");
		assertEquals("Valid",result);
		result=urobj.validateEmail("abc@bl.co");
		assertEquals("Valid",result);
		result=urobj.validateEmail("abc@yahoo.com");
		assertEquals("Valid",result);
		result=urobj.validateEmail("abc-100@yahoo.com");
		assertEquals("Valid",result);
		result=urobj.validateEmail("abc.100@yahoo.com");
		assertEquals("Valid",result);
		result=urobj.validateEmail("abc111@abc.com");
		assertEquals("Valid",result);
		result=urobj.validateEmail("abc-100@abc.net");
		assertEquals("Valid",result);
		result=urobj.validateEmail("abc.100@abc.com.au");
		assertEquals("Valid",result);
		result=urobj.validateEmail("abc@1.com");
		assertEquals("Valid",result);
		result=urobj.validateEmail("abc@gmail.com.com");
		assertEquals("Valid",result);
		result=urobj.validateEmail("abc+100@gmail.com");
		assertEquals("Valid",result);
		result=urobj.validateEmail("abc");
		assertEquals("EMAIL",result);
		result=urobj.validateEmail("abc@.com.my");
		assertEquals("EMAIL",result);
		result=urobj.validateEmail("abc123@gmail.a");
		assertEquals("EMAIL",result);
		result=urobj.validateEmail("abc123@.com");
		assertEquals("EMAIL",result);
		result=urobj.validateEmail("abc123@.com.com");
		assertEquals("EMAIL",result);
		result=urobj.validateEmail(".abc@abc.com");
		assertEquals("EMAIL",result);
		result=urobj.validateEmail("abc()*@gmail.com");
		assertEquals("EMAIL",result);
		result=urobj.validateEmail("abc@%*.com");
		assertEquals("EMAIL",result);
		result=urobj.validateEmail("abc..2002@gmail.com");
		assertEquals("EMAIL",result);
		result=urobj.validateEmail("abc.@gmail.com");
		assertEquals("EMAIL",result);
		result=urobj.validateEmail("abc@abc@gmail.com");
		assertEquals("EMAIL",result);
		result=urobj.validateEmail("abc@gmail.com.1a");
		assertEquals("EMAIL",result);
		result=urobj.validateEmail("abc@gmail.com.aa.au");
		assertEquals("EMAIL",result);
	}
	
	@Test
	public void givenUserDetails_WhenValid_ShouldReturnHappy()
	{
		UserRegistration urobj = new UserRegistration();
	
		assertEquals("Happy",urobj.validateUserDetails("Omkeshwari", "Pilare", "omp1997@gmail.com", "91 9876543210", "ABcd@123"));
	}
	
	@Test
	public void givenUserDetails_WhenValid_ShouldReturnSad()
	{
		UserRegistration urobj = new UserRegistration();
	
		assertEquals("Sad",urobj.validateUserDetails("Omkeshwari", "Pilare", "omp1997&gmail.com", "9876543210", "ABcd123"));
	}
	
	@ParameterizedTest
	@MethodSource("provideStringsforEmail")
	public void givenEmailSamples_WhenValid_ShouldReturnTrue(String email, String result) throws UserRegistrationException
	{
		UserRegistration urobj=new UserRegistration();
		assertEquals(result,urobj.validateEmail(email));
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
	
}
