package edu.ics211.h03;

/**
 * Homework 3
 * 
 * @author esb
 * @assignment Homework 3
 * @date February 3, 2023
 * @bugs None
 */
public interface Programmer {
	
	/**
	 * Creates an assignment statement
	 * @return an assignment statement
	 */
	Assignment makeAssignment();

	/**
	 * Creates a method
	 * @return a method
	 */
	MethodCall makeMethodCall();

	/**
	 * Creates an while loop
	 * @return a while loop
	 */
	WhileLoop makeWhileLoop(); // create a while loop

	/**
	 * Creates a conditional statement
	 * @return a conditional statement
	 */
	Conditional makeConditional(); // create a conditional statement

	/**
	 * Creates a statement of one of the types above
	 * @return a statement of one of the types above
	 */
	Statement makeStatement();
}
