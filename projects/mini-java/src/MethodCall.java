package edu.ics211.h03;

/**
 * Homework 3
 * 
 * @author Lee, Michael
 * @assignment Homework 3
 * @date February 3, 2023
 * @bugs None
 */
public class MethodCall extends BasicStatement {

	/**
	 * HOMEWORK 2
	 * 
	 * Constructor for MethodCall, will check if the parameter is in the expected
	 * format. If the parameter is formated correctly, the constructor will assign
	 * it to the tokens variable.
	 * 
	 * @param tokenValues Array containing the values of each token
	 * @throws InvalidStatementException If there is an error in the formating of
	 *                                   the array
	 */
	public MethodCall(String[] tokenValues) throws InvalidStatementException {
		/** Determines if the parameter is formatted correctly based on else if ladder below */
		boolean expectedFormat = true;

		// First token is a java identifier
		if (!super.javaIdentifierChecker(tokenValues[0])) {
			expectedFormat = false;
			throw new InvalidStatementException("The first token is not a Java identifier.");
		} // Second token must be "("
		else if (!"(".equals(tokenValues[1])) {
			expectedFormat = false;
			throw new InvalidStatementException("\"(\" is expected as the second token.");
		} // Second to last token must be ")"
		else if (!")".equals(tokenValues[tokenValues.length - 2])) {
			expectedFormat = false;
			throw new InvalidStatementException("\")\" is expected as the second to last token.");
		} // Last token must be ";"
		else if (!";".equals(tokenValues[tokenValues.length - 1])) {
			expectedFormat = false;
			throw new InvalidStatementException("\";\" is expceted as the last token");
		}
		
		// If all the above is true, expectedFormat remains as true
		if (expectedFormat) {
			tokens = tokenValues;
		}
	}
	
	/**
	 * HOMEWORK 3
	 * 
	 * @param method name of the method
	 * @param parameters parameters that we want to put in for the method 
	 * @throws InvalidStatementException If there is an error in the formating of
	 *                                   the array
	 */
	public MethodCall(String method, String[] parameters) throws InvalidStatementException {
		/** Determines if the parameter is formatted correctly */
		boolean expectedFormat = true;
		/** Create new array that is three larger to hold "(", ")", and "{" */
		String[] myTokens = new String[parameters.length + 4];
		// Method is a Java Identifier
		if (!super.javaIdentifierChecker(method)) {
			expectedFormat = false;
			throw new InvalidStatementException("Method is not a Java Identifier");
		}
		
		if (expectedFormat) {
			myTokens[0] = method;
			myTokens[1] = "(";
			// Add the 
			for (int i = 0; i < parameters.length; i++) {
				myTokens[i + 2] = parameters[i];
			}
			myTokens[myTokens.length - 2] = ")";
			myTokens[myTokens.length - 1] = ";";
			tokens = myTokens;
		}
	}

	/**
	 * Used to retrieve the method name
	 * 
	 * @return the method name
	 */
	public String getMethodName() {
		return (String) tokens[0];
	}
}
