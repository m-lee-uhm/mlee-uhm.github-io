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
class WhileLoopTest {

	WhileLoop formattedWhileLoop1;
	WhileLoop formattedWhileLoop2;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		String[] condition = {"x", ">", "0"};
		String[] treeTokens = {"super", "+", "cool"};
		String[] methodTokens = {"hello", ",", "tree", "+", "treeLength"};
		Statement[] loopCode = {new Assignment("trees", treeTokens), new MethodCall("methodToLoop", methodTokens)};
		formattedWhileLoop1 = new WhileLoop(condition, loopCode);
		formattedWhileLoop2 = new WhileLoop(condition, loopCode);
	}
	
	@Test
	void test() {
		// Should be true since WhileLoop is a subclass of CompoundStatement
		assertTrue(formattedWhileLoop1.isCompound());
		assertTrue(formattedWhileLoop2.isCompound());
		// Should be true since they have the same parameter wwhen constructed
		assertTrue(formattedWhileLoop1.equals(formattedWhileLoop2));
		assertTrue(formattedWhileLoop2.equals(formattedWhileLoop1));
		// Should be true since toString should format it in this format
		assertTrue(formattedWhileLoop1.toString().equals("while ( x > 0 ) { "
													   + "trees = super + cool ; "
													   + "methodToLoop ( hello , tree + treeLength ) ; }"));
		// Should be false since it is formatted correctly, so it should be assigned to tokens
		assertFalse(formattedWhileLoop1.equals(null));	
	}
}
	