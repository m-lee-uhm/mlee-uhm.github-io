
package edu.ics211.h03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Homework 3
 * 
 * @author Lee, Michael; esb
 * @assignment Homework 3
 * @date February 3, 2023
 * @bugs None
 */
class AssignmentTest {
	Assignment formattedAssignment1;
	Assignment formattedAssignment2;
	Assignment notFormattedAssignment2;
	Assignment notFormattedAssignment3;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		String[] tokens = { "1", "+", "1"};
		formattedAssignment1 = new Assignment("number", tokens);
		formattedAssignment2 = new Assignment("number", tokens);
	}

	@Test
	@SuppressWarnings("unused")
	void test() {
		// Should be false because Assignment is a subclass of BasicStatement
		assertFalse(formattedAssignment1.isCompound());
		assertFalse(formattedAssignment2.isCompound());
		// Should be true since they had the same parameter when constructed
		assertTrue(formattedAssignment1.equals(formattedAssignment2));
		assertTrue(formattedAssignment2.equals(formattedAssignment1));
		// Should be true since the first String within the string array is "number"
		assertTrue(formattedAssignment1.getVariable().equals("number"));
		// Should be true since toString should format it in this format
		assertTrue(formattedAssignment1.toString().equals("number = 1 + 1 ;"));
		// Should be false since it is formatted correctly, so it should be assigned to tokens
		assertFalse(formattedAssignment1.equals(null));

		// Exception Checking
		boolean condition1 = true;
		// Should throw InvalidStatementException since variable is not a JavaIdentifier
		try {
			String[] incorrectJavaIdentifier = { "1", "+", "1",};
			Assignment notFormattedAssignment1 = new Assignment(";", incorrectJavaIdentifier);
		} catch (InvalidStatementException e) {
			condition1 = false;
		}
		assertFalse(condition1);
	}
}