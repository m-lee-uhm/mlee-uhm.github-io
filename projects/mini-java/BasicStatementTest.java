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
class BasicStatementTest {
	BasicStatement basic;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		String[] tokens = { "a", "=", "3", ";" };
		basic = new BasicStatement(tokens);
	}

	@Test
	void test() {
		assertFalse(basic.isCompound());
	}
}