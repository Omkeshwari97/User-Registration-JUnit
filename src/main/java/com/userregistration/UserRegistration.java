package com.userregistration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.userregistration.UserRegistrationException.ExceptionType;

public class UserRegistration
{
    private static final String FIRST_NAME_PATTERN = "^[A-Z]{1}[a-zA-z]{2,}";
    private static final String LAST_NAME_PATTERN = "^[A-Z]{1}[a-zA-Z]{2,}";
    private static final String EMAIL_PATTERN = "^[a-z0-9_-]+[.|+]?[a-z0-9_-]+[@][a-z0-9]{1,}[.][a-z]{2,}[.]{0,1}[a-z]*$";
    private static final String MOBILE_NUMBER_PATTERN = "^[0-9]{2}[ ][0-9]{10}";
    private static final String PASSWORD_PATTERN = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&])[a-zA-Z0-9@$!%*?&]{8,}";
    
    public static boolean validateInput(String input, String expression)
    {
    	Pattern pattern = Pattern.compile(expression);
    	Matcher matcher = pattern.matcher(input);
    	return matcher.find();
    }
    
    public String validateFirstName(String fname) throws UserRegistrationException
    {
    	String result = "";
    	
    	try 
    	{
			if(validateInput(fname, FIRST_NAME_PATTERN))
			{
				result = "Valid";
			}
			else
			{
				throw new UserRegistrationException(UserRegistrationException.ExceptionType.FIRST_NAME,"Invalid First Name");
			}
		}
    	catch (UserRegistrationException e) 
    	{
    		return e.type.toString();
		}
    	
		return result;
    }
    
    public String validateLastName(String lname) throws UserRegistrationException
    {
    	String result = "";
    	
    	try 
    	{
			if(validateInput(lname, LAST_NAME_PATTERN))
			{
				result = "Valid";
			}
			else
			{
				throw new UserRegistrationException(UserRegistrationException.ExceptionType.LAST_NAME,"Invalid Last Name");
			}
		}
    	catch (UserRegistrationException e) 
    	{
    		return e.type.toString();
		}
    	
		return result;
    }
    
    public String validateEmail(String email) throws UserRegistrationException
    {
    	String result = "";
    	
    	try 
    	{
			if(validateInput(email, EMAIL_PATTERN))
			{
				result = "Valid";
			}
			else
			{
				throw new UserRegistrationException(UserRegistrationException.ExceptionType.EMAIL,"Invalid Email");
			}
		}
    	catch (UserRegistrationException e) 
    	{
    		return e.type.toString();
		}
    	
		return result;
    }
    
    public String validateMobileNumber(String mobile) throws UserRegistrationException
    {
    	String result = "";
    	
    	try 
    	{
			if(validateInput(mobile, MOBILE_NUMBER_PATTERN))
			{
				result = "Valid";
			}
			else
			{
				throw new UserRegistrationException(UserRegistrationException.ExceptionType.MOBILE_NUMBER,"Invalid Mobile Number");
			}
		}
    	catch (UserRegistrationException e) 
    	{
    		return e.type.toString();
		}
    	
		return result;
    }
    
    public String validatePassword(String password) throws UserRegistrationException
    {
    	String result = "";
    	
    	try 
    	{
			if(validateInput(password,PASSWORD_PATTERN))
			{
				result = "Valid";
			}
			else
			{
				throw new UserRegistrationException(UserRegistrationException.ExceptionType.PASSWORD,"Invalid Password");
			}
		}
    	catch (UserRegistrationException e) 
    	{
    		return e.type.toString();
		}
    	
		return result;
    }
    
        
    public String validateUserDetails(String fname, String lname, String email, String mobile, String password)
    {  	
    	String fname_result;
		String lname_result;
		String email_result;
		String mobile_result;
		String password_result;
		String result = "";
		try 
		{
			fname_result = validateFirstName(fname);
			lname_result = validateLastName(lname);
			email_result = validateEmail(email);
			mobile_result = validateMobileNumber(mobile);
			password_result = validatePassword(password);
			
	    	if(fname_result.equals("Valid") && lname_result.equals("Valid") && email_result.equals("Valid") && mobile_result.equals("Valid") && password_result.equals("Valid"))
	    	{
	    		result = "Happy";
	    	}
	    	else
	    	{
	    		result = "Sad";
	    	}
		} 
		catch (UserRegistrationException e) 
		{
			return e.type.toString();
		}

		return result;
    }
}
