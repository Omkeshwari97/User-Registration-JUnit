package com.userregistration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.userregistration.UserRegistrationException.ExceptionType;

@FunctionalInterface
interface IValidateDetailsFunction
{
	String validate(String input) throws UserRegistrationException;
}

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
    
    IValidateDetailsFunction validateFirstName = (String fname) ->
    {
    	//String result = "";
		try 
		{
			if(validateInput(fname, FIRST_NAME_PATTERN))
			{
				return "Valid";
				//System.out.println(result);
			}
			else
			{
				throw new UserRegistrationException(UserRegistrationException.ExceptionType.FIRST_NAME,"Invalid First Name");
			}
		} 
		catch (UserRegistrationException e) 
		{
			//System.out.println(e.type.toString());
			
			 return e.type.toString();
		}
    };
    
    IValidateDetailsFunction validateLastName = (String lname) ->
    {
    	String result ="";
    	
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
    };
    
    IValidateDetailsFunction validateEmail = (String email) ->
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
    };
    
    IValidateDetailsFunction validateMobileNumber = (String mobile) ->
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
    };
    
    IValidateDetailsFunction validatePassword = (String password) ->
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
    };
}
