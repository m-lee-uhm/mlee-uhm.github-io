package edu.ics211.h03;

/**
 * Homework 3
 * 
 * @author Lee, Michael
 * @assignment Homework 3
 * @date February 3, 2023
 * @bugs None
 */
public abstract class CompoundStatement extends Statement {

	@Override
	public boolean isCompound() {
		return true;
	}
	
	/**
	 * Number of parts in a compound statement.
	 * @return If the statement is a WhileLoop return 1, if the statement is a Conditional return 2.
	 */
	public abstract int numberOfParts();
}
