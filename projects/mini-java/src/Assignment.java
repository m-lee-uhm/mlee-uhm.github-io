package edu.ics211.h03;

/**
 * Homework 3
 * 
 * @author Lee, Michael
 * @assignment Homework 3
 * @date February 3, 2023
 * @bugs None
 */
public class Assignment extends BasicStatement {

	/**
	 * HOMEWORK 2
	 * 
	 * Constructor for Assignment, will check if the parameter is in the expected
	 * format. If the parameter is formated correctly, the constructor will assign
	 * it to the tokens variable.
	 * 
	 * @param tokenValues Array containing the values of each token
	 * @throws InvalidStatementException If there is an error in the formatting of
	 *                                   the array
	 */
	public Assignment(String[] tokenValues) throws InvalidStatementException {
		/** Determines if the parameter is formatted correctly based on else if ladder below */
		boolean expectedFormat = true;

		// First token is a Java identifier
		if (!super.javaIdentifierChecker(tokenValues[0])) {
			expectedFormat = false;
			throw new InvalidStatementException("The first token is not a Java identifier.");
		} // Second token must be "="
		else if (!"=".equals(tokenValues[1])) {
			expectedFormat = false;
			throw new InvalidStatementException("\"=\" is expected as the second token.");
		} // Last token must be ";"
		else if (!";".equals(tokenValues[tokenValues.length - 1])) {
			expectedFormat = false;
			throw new InvalidStatementException("\";\" is expected as the last token.");
		}

		// If all of the above is true, expectedFormat remains as true
		if (expectedFormat) {
			tokens = tokenValues;
		}
	}

	/**
	 * HOMEWORK 3
	 * 
	 * Constructor for Assignment, will check if the parameter is in the expected
	 * format. If the parameter is formated correctly, the constructor will assign
	 * it to the tokens variable.
	 * 
	 * @param variable   Is the name of the variable
	 * @param expression is what we are assigning to the variable
	 * @throws InvalidStatementException If there is an error in the formatting of
	 *                                   the array
	 */
	public Assignment(String variable, String[] expression) throws InvalidStatementException {
		/** Determines if the parameters are formatted correctly using the else-if ladder */
		boolean expectedFormat = true;
		/** Create a String array that is three larger than expression to insert variable,
		 *  "=", and ";" */
		String[] myTokens = new String[expression.length + 3];
		// Check if String is a Java identifier
		if (!super.javaIdentifierChecker(variable)) {
			expectedFormat = false;
			throw new InvalidStatementException("Variable is not a Java Identifier.");
		} 
		// Creates a new String array that contains all the necessary elements
		if (expectedFormat) {
			// Assign appropriate elements to String array
			myTokens[0] = variable;
			myTokens[1] = "=";
			for (int i = 0; i < expression.length; i++) {
				myTokens[i + 2] = expression[i];
			}
			myTokens[myTokens.length - 1] = ";";
			// Assign myTokens to tokens variable
			tokens = myTokens;
		}
	}

	/**
	 * Used to retrieve the variable inputed
	 * 
	 * @return The variable name
	 */
	public String getVariable() {
		return (String) tokens[0];
	}
}
