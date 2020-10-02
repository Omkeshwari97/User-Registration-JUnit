package com.userregistration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistration 
{
    private static final String FIRST_NAME_PATTERN="^[A-Z]{1}[a-zA-z]{2,}";
    private static final String LAST_NAME_PATTERN="^[A-Z]{1}[a-zA-Z]{2,}";
    private static final String EMAIL_PATTERN="^[a-z0-9_-]+[.|+]?[a-z0-9_-]+[@][a-z0-9]{1,}[.][a-z]{2,}[.]{0,1}[a-z]*$";
    private static final String MOBILE_NUMBER_PATTERN="^[0-9]{2}[ ][0-9]{10}";
    private static final String PASSWORD_PATTERN="^(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&])[a-zA-Z0-9@$!%*?&]{8,}";
    
    public boolean validateFirstName(String fname)
    {
    	Pattern pattern=Pattern.compile(FIRST_NAME_PATTERN);
    	Matcher matcher=pattern.matcher(fname);
    	
    	return matcher.find();
    }
    
    public boolean validateLastName(String lname)
    {
    	Pattern pattern=Pattern.compile(LAST_NAME_PATTERN);
    	Matcher matcher=pattern.matcher(lname);
    	
    	return matcher.find();
    }
    
    public boolean validateEmail(String email)
    {
    	Pattern pattern=Pattern.compile(EMAIL_PATTERN);
    	Matcher matcher=pattern.matcher(email);
    	
    	return matcher.find();
    }

    public boolean validateMobileNumber(String mobileNumber)
    {
    	Pattern pattern=Pattern.compile(MOBILE_NUMBER_PATTERN);
    	Matcher matcher=pattern.matcher(mobileNumber);
    	
    	return matcher.find();
    }
    
    public boolean validatePassword(String password)
    {
    	Pattern pattern=Pattern.compile(PASSWORD_PATTERN);
    	Matcher matcher=pattern.matcher(password);
    	
    	return matcher.find();
    }
}
