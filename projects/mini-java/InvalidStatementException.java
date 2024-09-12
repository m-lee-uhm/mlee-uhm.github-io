package edu.ics211.h03;

/**
 * Homework 3
 * 
 * @author Lee, Michael
 * @assignment Homework 3
 * @date February 3, 2023
 * @bugs None
 */

@SuppressWarnings("serial")
public class InvalidStatementException extends Exception {
	
	/**
	 * Default error message when there is an error
	 */
	public InvalidStatementException() {
		super("An InvalidStatementException occured");
	}
	
	/**
	 * Prints out a detailed message that describes what is incorrect
	 * @param errorMessage message to send out when there is an error
	 */
	public InvalidStatementException(String errorMessage) {
		super(errorMessage);
		System.out.println(super.getMessage());
	}
}
