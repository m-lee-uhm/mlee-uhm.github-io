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
class MethodCallTest {

	MethodCall formattedMethodCall1;
	MethodCall formattedMethodCall2;

	@BeforeEach
	void setUp() throws Exception {
		String[] tokens = { "parameterType", ",", "parameterName"};
		formattedMethodCall1 = new MethodCall("methodName", tokens);
		formattedMethodCall2 = new MethodCall("methodName", tokens);
	}

	@Test
	@SuppressWarnings("unused")
	void test() {
		// Should be false since MethodCall is a subclass of BasicStatement
		assertFalse(formattedMethodCall1.isCompound());
		assertFalse(formattedMethodCall2.isCompound());
		// Should be true since they have the same parameter when constructed
		assertTrue(formattedMethodCall1.equals(formattedMethodCall2));
		assertTrue(formattedMethodCall2.equals(formattedMethodCall1));
		// Should be true since the first String within the String array is "methodName"
		assertTrue(formattedMethodCall1.getMethodName().equals("methodName"));
		// Should be true since toString should format it in this format
		assertTrue(formattedMethodCall1.toString().equals("methodName ( parameterType , parameterName ) ;"));
		// Should be false since it is formated correctly, so it should be assigned to
		// tokens
		assertFalse(formattedMethodCall1.equals(null));

		// Exception Checking
		boolean condition1 = true;
		// Should throw InvalidStatementExcept since first token is not a JavaIdentifier
		try {
			String[] incorrectJavaIdentifier = { "parameterType", ",", "parameterNameariable"};
			MethodCall notFormatedMethodCall1 = new MethodCall(";", incorrectJavaIdentifier);
		} catch (InvalidStatementException e) {
			condition1 = false;
		}
		assertFalse(condition1);
	}
}
