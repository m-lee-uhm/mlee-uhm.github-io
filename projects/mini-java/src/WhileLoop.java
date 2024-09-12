package edu.ics211.h03;

/**
 * Homework 3
 * 
 * @author Lee, Michael
 * @assignment Homework 3
 * @date February 3, 2023
 * @bugs None
 */
public class WhileLoop extends CompoundStatement {

	@Override
	public int numberOfParts() {
		return 1;
	}

	/** 
	 * HOMEWORK 2
	 * 
	 * Constructor for WhileLoop, will check if the parameter is in the expected
	 * format. If the parameter is formated correctly, the constructor will assign
	 * it to the tokens variable.
	 * 
	 * @param tokenValues Array containing the values of each token
	 * @throws InvalidStatementException If there is an error in the formating of
	 *                                   the array
	 */
	public WhileLoop(String[] tokenValues) throws InvalidStatementException {
		/** Determines if the array if formatted correctly based on else if ladder below*/
		boolean expectedFormat = true;
		
		// First token must be "else"
		if (!"while".equals(tokenValues[0])) {
			expectedFormat = false;
			throw new InvalidStatementException("The first token is not \"while\"");
		} // Second token must be "("
		else if (!"(".equals(tokenValues[1])) {
			expectedFormat = false;
			throw new InvalidStatementException("The second token is not \"(\"");
		}
		
		// If all of the above is true, expectedFormat remains as true
		if (expectedFormat) {
			tokens = tokenValues;
		}
	}
	
	/**
	 * HOMEWORK 3
	 * 
	 * Constructor for WhileLoop
	 * 
	 * @param condition Array that contains what we want to check
	 * @param loopBody Array that contains what we want to loop while the condition is true
	 */
	public WhileLoop(String[] condition, Statement[] loopBody) {
		/** Create a new array that is large enough to hold all elements*/
		Object[] myTokens = new Object[condition.length + loopBody.length + 5];
		myTokens[0] = "while";
		myTokens[1] = "(";
		// Appends condition to array
		for (int i = 0; i < condition.length; i++) {
			myTokens[i + 2] = condition[i];
		}
		myTokens[condition.length + 2] = ")";
		myTokens[condition.length + 3] = "{";
		// Appends loopBody to array
		for (int i = 0; i < loopBody.length; i++) {
			myTokens[condition.length + 4 + i] = loopBody[i];
		}
		myTokens[myTokens.length - 1] = "}";
		tokens = myTokens;
	}
}
