package edu.ics211.h03;

/**
 * Homework 3
 * 
 * @author Lee, Michael
 * @assignment Homework 3
 * @date February 3, 2023
 * @bugs None
 */
public class Conditional extends CompoundStatement {

	@Override
	public int numberOfParts() {
		return 2;
	}

	/**
	 * HOMEWORK 2
	 * 
	 * Constructor for Conditional, will check if the parameter is in the expected
	 * format. If the parameter is formated correctly, the constructor will assign
	 * it to the tokens variable.
	 * 
	 * @param tokenValues Array containing the values of each token
	 * @throws InvalidStatementException If there is an error in the formating of
	 *                                   the array
	 */
	public Conditional(String[] tokenValues) throws InvalidStatementException {
		/** Determines if the parameter is formatted correctly based on else if ladder below */
		boolean expectedFormat = true;

		// First token must be "if"
		if (!"if".equals(tokenValues[0])) {
			expectedFormat = false;
			throw new InvalidStatementException("The first token is not \"if\"");
		} // Second token must be "("
		else if (!"(".equals(tokenValues[1])) {
			expectedFormat = false;
			throw new InvalidStatementException("The second token is not \"(\"");
		} // Token "else" must appear within the array
		else if (!elseFinder(tokenValues)) {
			expectedFormat = false;
			throw new InvalidStatementException("The token \"else\" is not within "
					+ "the array of tokens");
		} // Last token must be "}"
		else if (!"}".equals(tokenValues[tokenValues.length - 1])) {
			expectedFormat = false;
			throw new InvalidStatementException("The last token is not \"}\"");
		}
		
		// If all of the above is true, expectedFormat remains as true
		if (expectedFormat) {
			tokens = tokenValues;
		}
	}
	/**
	 * HOMEWORK 3
	 * 
	 * Constructor for Conditional class
	 * 
	 * @param condition Array that contains what we want to check
	 * @param thenPart Array that contains what we want to run if the condition is true
	 * @param elsePart Array that contains what we want to run if the condition is false
	 */
	public Conditional(String[] condition, Statement[] thenPart, Statement[] elsePart) {
		/** Makes an array that is large enough to hold all the elements needed*/
		Object[] myTokens = new Object[condition.length + thenPart.length + elsePart.length + 8];
		myTokens[0] = "if";
		myTokens[1] = "(";
		// Appends condition to the array
		for (int i = 0; i < condition.length; i++) {
			myTokens[i+2] = condition[i];
		}
		myTokens[condition.length + 2] = ")";
		myTokens[condition.length + 3] = "{";
		// Appends thenPart to the current array
		for (int i = 0; i < thenPart.length; i++) {
			myTokens[i + condition.length + 4] = thenPart[i];
		}
		myTokens[condition.length + thenPart.length + 4] = "}";
		myTokens[condition.length + thenPart.length + 5] = "else";
		myTokens[condition.length + thenPart.length + 6] = "{";
		// Appends elsePart to the current array
		for (int i = 0; i < elsePart.length; i++) {
			myTokens[i + condition.length + thenPart.length + 7] = elsePart[i];
		}
		myTokens[condition.length + thenPart.length + elsePart.length + 7] = "}";
		tokens = myTokens;
		
	}

	/**
	 * Checks if somewhere in the array contains the word "else"
	 * 
	 * @param a Array put in constructor for the conditional class
	 * @return True, if the word "else" is within the array. Will return false
	 *         otherwise
	 */
	public boolean elseFinder(String[] a) {
		boolean elseExists = false;
		// Scans through the array
		for (int i = 0; i < a.length; i++) {
			//Checks if each token is the word "else"
			if ("else".equals(a[i])) {
				elseExists = true;
			}
		}
		return elseExists;
	}
}
