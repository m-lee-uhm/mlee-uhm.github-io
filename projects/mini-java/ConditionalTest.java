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
class ConditionalTest {

	Conditional formattedConditional1;
	Conditional formattedConditional2;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		String[] booleanCondition = {"x", "<", "3"};
		String[] numberTokens = {"1", "+", "2", "+", "3"};
		String[] methodTokens = {"hi", ",", "4", "+", "5"};
		Statement[] thenCode = {new Assignment("number", numberTokens), new MethodCall("methodName", methodTokens)};
		Statement[] elseCode = {new Assignment("number", numberTokens), new MethodCall("methodName", methodTokens)};
		formattedConditional1 = new Conditional(booleanCondition, thenCode, elseCode);
		formattedConditional2 = new Conditional(booleanCondition, thenCode, elseCode);

	}

	@Test
	void test() {
		// Should be true becaue Conditional is a subclass of CompoundStatement
		assertTrue(formattedConditional1.isCompound());
		assertTrue(formattedConditional2.isCompound());
		// Should be true since they had the same parameter when constructed
		assertTrue(formattedConditional1.equals(formattedConditional2));
		assertTrue(formattedConditional2.equals(formattedConditional1));
		// Should be true since toString should format it in this format
		assertTrue(formattedConditional1.toString().equals("if ( x < 3 ) { "
															+ "number = 1 + 2 + 3 ; "
															+ "methodName ( hi , 4 + 5 ) ; "
															+ "} else { "
															+ "number = 1 + 2 + 3 ; "
															+ "methodName ( hi , 4 + 5 ) ; "
															+ "}"));
		// Should be false since it is formatted correctly, so it should be assigned to tokens
		assertFalse(formattedConditional1.equals(null));
		// Should be two since it is defined
		assertTrue(formattedConditional1.numberOfParts() == 2);
	}
}