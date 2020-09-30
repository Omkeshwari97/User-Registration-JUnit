package com.userregistration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistration 
{
    private static final String FIRST_NAME_PATTERN="^[A-Z]{1}[a-zA-z]{2,}";
    private static final String LAST_NAME_PATTERN="^[A-Z]{1}[a-zA-Z]{2,}";
    private static final String EMAIL_PATTERN="^[a-z0-9_-]+[.|+]?[a-z0-9_-]+[@][a-z0-9]{1,}[.][a-z]{2,}[.]{0,1}[a-z]*";
    
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
}
