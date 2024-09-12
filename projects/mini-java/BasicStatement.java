package edu.ics211.h03;

/**
 * Homework 3
 * 
 * @author Lee, Michael
 * @assignment Homework 3
 * @date February 3, 2023
 * @bugs None
 */
public class BasicStatement extends Statement {
	
	@Override
	public boolean isCompound() {
		return false;
	}
	
	/**
	 * Initiates the variable
	 */
	public BasicStatement() {
	}
	
	/**
	 * Constructor for BasicStatement, will check if parameters are in expected format
	 * 
	 * @param tokenValues Array containing the values of each token
	 */
	public BasicStatement(String[] tokenValues) {
		tokens = tokenValues;
	}
	
	/**
	 * Checks if the characters, besides the first, are Java Identifier Parts, and
	 * if the first character is a Java Identifier Start
	 * 
	 * @param str First token
	 * @return True if all parts of the token are Java Identifier Parts besides the
	 *         first, else returns false
	 */
	protected boolean javaIdentifierChecker(String str) {
		/** First character of the string */
		char firstCharacter = str.charAt(0);
		/** Removes the first character of the string to check */
		String partToCheck = str.substring(1);
		/** Breaks the substring into an array of characters */
		char[] charArray = partToCheck.toCharArray();
		/**
		 * Toggles true/false depending on if the array of characters are Java
		 * Identifier Parts
		 */
		boolean status = true;

		// Checks if the first character of the parameter is a Java Identifier Start
		if (!Character.isJavaIdentifierStart(firstCharacter)) {
			status = false;
			return status;
		}
		// Iterate across character array to check if each character is part of Java
		// Identifer Part
		for (int i = 0; i < charArray.length; i++) {
			// Checks if the character is a Java Identifier Part
			if (!Character.isJavaIdentifierPart(charArray[i])) {
				status = false;
				return status;
			}
		}
		return status;
	}
}
