package com.userregistration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserRegistrationTest {

	boolean result;
	
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
	}

}
