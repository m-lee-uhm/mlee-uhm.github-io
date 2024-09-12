package edu.ics211.h03;

import java.util.Random;

/**
 * Homework 3
 * 
 * @author Lee, Michael; esb
 * @assignment Homework 3
 * @date February 3, 2023
 * @bugs None
 */
public class RandomProgrammer implements Programmer {
	// Variables
	final static String[] operators = { "+", "-", "*", "/", "%" };
	final static String[] variableNames = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j" };
	final static String[] methodNames = { "method0", "method1", "method2", "method3", "method4", "method5", "method6",
			"method7", "method8", "method9" };

	@Override
	public Assignment makeAssignment() {
		Random rand = new Random();
		// Pick a random variable name for the to-be generated Assignment
		int randomVariableName = rand.nextInt(10);
		// Create Assignment to return
		Assignment assignmentToReturn = null;
		try {
			assignmentToReturn = new Assignment(variableNames[randomVariableName], makeExpression());
		} catch (InvalidStatementException e) {
			System.out.print("\nThere was an error creating a random Assignment\n");
		}
		return assignmentToReturn;
	}

	@Override
	public MethodCall makeMethodCall() {
		Random rand = new Random();
		// Pick a random method name for the to-be generated MethodCall
		int randomMethodName = rand.nextInt(10);
		// Create MethodCall to return
		MethodCall methodToReturn = null;
		try {
			methodToReturn = new MethodCall(methodNames[randomMethodName], makeParameter());
		} catch (InvalidStatementException e) {
			System.out.print("\nThere was an error creating a random MethodCall\n");
		}
		return methodToReturn;
	}

	@Override
	public WhileLoop makeWhileLoop() {
		Random rand = new Random();
		// Create WhileLoop to return
		WhileLoop whileLoopToReturn = null;
		// WhileLoop expression
		String[] whileLoopExpression = new String[3];
		int randomVariableName = rand.nextInt(10);
		int randomNumber = rand.nextInt(10);
		whileLoopExpression[0] = variableNames[randomVariableName];
		whileLoopExpression[1] = ">";
		whileLoopExpression[2] = "" + randomNumber;
		// WhileLoop body
		int randomStatements = rand.nextInt(1, 10);
		Statement[] whileLoopBody = new Statement[randomStatements];
		for (int i = 0; i < randomStatements; i++) {
			whileLoopBody[i] = makeBasicStatement();
		}
		// Constructing WhileLoop
		whileLoopToReturn = new WhileLoop(whileLoopExpression, whileLoopBody);
		return whileLoopToReturn;
	}

	@Override
	public Conditional makeConditional() {
		Random rand = new Random();
		Conditional conditionalToReturn = null;
		// Conditional expression
		String[] conditionalExpression = new String[3];
		int randomVariableName = rand.nextInt(10);
		int randomNumber = rand.nextInt(10);
		conditionalExpression[0] = variableNames[randomVariableName];
		conditionalExpression[1] = ">";
		conditionalExpression[2] = "" + randomNumber;
		// Conditional thenPart
		int randomStatementsThen = rand.nextInt(1, 10);
		Statement[] thenBody = new Statement[randomStatementsThen];
		for (int i = 0; i < randomStatementsThen; i++) {
			thenBody[i] = makeBasicStatement();
		}
		// Conditional elsePart
		int randomStatementsElse = rand.nextInt(1, 10);
		Statement[] elseBody = new Statement[randomStatementsElse];
		for (int i = 0; i < randomStatementsElse; i++) {
			elseBody[i] = makeBasicStatement();
		}
		// Construcing Conditional
		conditionalToReturn = new Conditional(conditionalExpression, thenBody, elseBody);
		return conditionalToReturn;
	}

	@Override
	public Statement makeStatement() {
		Random rand = new Random();
		// Generates a random number from 0-3
		int selection = rand.nextInt(4);
		Statement statementToReturn = null;
		if (selection == 0) {
			statementToReturn = makeAssignment();
		} else if (selection == 1) {
			statementToReturn = makeMethodCall();
		} else if (selection == 2) {
			statementToReturn = makeWhileLoop();
		} else if (selection == 3) {
			statementToReturn = makeConditional();
		}
		return statementToReturn;
	}

	/**
	 * Makes a random statement that is a basic statement
	 * 
	 * @return Returns either a random Assignment or random MethodCall
	 */
	public Statement makeBasicStatement() {
		Random rand = new Random();
		Statement statementToConstruct = null;
		// Generates true or false
		boolean toggle = rand.nextBoolean();
		if (toggle) {
			statementToConstruct = makeAssignment();
		} else {
			statementToConstruct = makeMethodCall();
		}
		return statementToConstruct;
	}

	/**
	 * Creates a random expression
	 * 
	 * @return Returns either: a random variable name, a random integer, or a random
	 *         expression
	 */
	public String[] makeExpression() {
		Random rand = new Random();
		int randomNumber = rand.nextInt(3);
		String[] expressionToReturn = null;
		if (randomNumber == 0) {
			expressionToReturn = new String[1];
			int randomElement = rand.nextInt(9);
			// Assigns one of the variableNames to the array to return
			expressionToReturn[0] = variableNames[randomElement];
		} else if (randomNumber == 1) {
			expressionToReturn = new String[1];
			int randomInteger = rand.nextInt(100);
			// Assigns a random integer to the array to return
			expressionToReturn[0] = "" + randomInteger;
		} else if (randomNumber == 2) {
			expressionToReturn = new String[3];
			boolean randomState = rand.nextBoolean();
			int randomElement = rand.nextInt(9);
			int randomInteger = rand.nextInt(100);
			int randomOperator = rand.nextInt(5);
			expressionToReturn[1] = operators[randomOperator];
			// Changes the format of expression to (varaible operator int)
			// or (int operator variable)
			if (randomState) {
				expressionToReturn[0] = variableNames[randomElement];
				expressionToReturn[2] = "" + randomInteger;
			} else {
				expressionToReturn[2] = variableNames[randomElement];
				expressionToReturn[0] = "" + randomInteger;
			}
		}
		return expressionToReturn;
	}

	/**
	 * Create a random amount of parameters from 0-3 inclusive
	 * 
	 * @return Returns a String array with parameters properly formatted
	 */
	public String[] makeParameter() {
		Random rand = new Random();
		int numberOfParameters = rand.nextInt(4);
		String[] parameter = null;
		// Else if ladder to create multiple parameters for makeMethodCall
		if (numberOfParameters == 0) {
			parameter = new String[] {};
		} else if (numberOfParameters == 1) {
			// Generate a random expression
			String[] temp1 = makeExpression();
			// Make array to appropriate size
			parameter = new String[temp1.length];
			// Assign the expression to the array
			for (int i = 0; i < temp1.length; i++) {
				parameter[i] = temp1[i];
			}
		} else if (numberOfParameters == 2) {
			// Generate two random expressions
			String[] temp1 = makeExpression();
			String[] temp2 = makeExpression();
			// Make array to appropriate size
			parameter = new String[temp1.length + temp2.length + 1];
			// Assign the first expression into the array
			for (int i = 0; i < temp1.length; i++) {
				parameter[i] = temp1[i];
			}
			parameter[temp1.length] = ",";
			// Assign the second expression into the array
			for (int i = 0; i < temp2.length; i++) {
				parameter[temp1.length + 1 + i] = temp2[i];
			}
		} else if (numberOfParameters == 3) {
			// Generate three random expressions
			String[] temp1 = makeExpression();
			String[] temp2 = makeExpression();
			String[] temp3 = makeExpression();
			// Make array to appropriate size
			parameter = new String[temp1.length + temp2.length + temp3.length + 2];
			// Assign the first expression into the array
			for (int i = 0; i < temp1.length; i++) {
				parameter[i] = temp1[i];
			}
			parameter[temp1.length] = ",";
			// Assign the second expression into the array
			for (int i = 0; i < temp2.length; i++) {
				parameter[temp1.length + 1 + i] = temp2[i];
			}
			parameter[temp1.length + temp2.length + 1] = ",";
			// Assign the third expression into the array
			for (int i = 0; i < temp3.length; i++) {
				parameter[temp1.length + temp2.length + 2 + i] = temp3[i];
			}
		}
		return parameter;
	}

	/**
	 * Main method
	 * @param args no arguments
	 */
	public static void main(String[] args) {
		RandomProgrammer cringe = new RandomProgrammer();
		try {
			Statement code = cringe.makeStatement();
			System.out.print(code);
		} catch (Exception e) {
			System.out.print(e);
			e.printStackTrace();
		}
	}
}
