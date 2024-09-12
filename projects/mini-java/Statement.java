package edu.ics211.h03;

/**
 * Homework 3
 * 
 * @author Lee, Michael
 * @assignment Homework 3
 * @date February 3, 2023
 * @bugs None
 */
public abstract class Statement {
	
	protected Object[] tokens;
	
	/**
	 * Checks if a statement if compound
	 * @return true if it is a CompoundStatement, false if it is a BasicStatement
	 */
	public abstract boolean isCompound();
	
	/**
	 * Create a toString that will work for all of the subclasses
	 */
	public String toString() {
		/** To create String that will become what we output */
		String output = "";
		output = output.concat((String) tokens[0]);
		// To add all other tokens to the first
		for (int i = 1; i < tokens.length; i++) {
			output = output.concat(" " + tokens[i]);
		}
		return output;
	}
	
	/**
	 * Compares two variables
	 */
	public boolean equals(Object statement) {
		if (statement == null) {
			return false;
		}
		Statement st = (Statement)statement;
		// Compares the class of parameter, and call of the object we are calling from
		if (st.getClass() != this.getClass()) {
			return false;
		}
		// Compares length of the parameter, and the length of object we are calling from
		if (!(st.tokens.length == this.tokens.length)) {
			return false;
		}
		// Iterates across each element of the array and compare them
		for (int i = 0; i < this.tokens.length; i++) {
			if (!(st.tokens[i].equals(this.tokens[i]))) {
				return false;
			}
		}
		return true;
	}
}
