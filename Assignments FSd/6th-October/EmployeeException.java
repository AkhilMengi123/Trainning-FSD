package com.cg.eis.exception;

import java.io.IOException;

class InvalidSalaryException extends Exception
{
    public InvalidSalaryException(String s)
    {
        
        super(s);
    }
}
 
  public class EmployeeException
{
   void salaryCheck(int salary) throws InvalidSalaryException{
	if(salary < 3000){
		throw new InvalidSalaryException(" Invalid");
	}
    else 
    {
        System.out.println("Valid");
    }
   }
   
    public static void main(String args[])
    {
    	EmployeeException obj = new EmployeeException();
        try
        {
            obj.salaryCheck(25000);
        }
        catch (InvalidSalaryException ex)
        {
            System.out.println("Caught the exception");
            System.out.println(ex.getMessage());
        }
    }
}