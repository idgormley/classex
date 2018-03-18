package edu.metrostate.ics240.p3.idg091.calc;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;
import edu.metrostate.ics240.p3.calc.StackCalculator;

/**
 * 
 * @author Ian
 *
 */
public class Calculator implements StackCalculator {

	public final static String OPERATOR = "+-*/";
	public final static char ADD= '+' ;
	public final static char MINUS= '-' ;
	public final static char MULTIPLY= '*' ;
	public final static char DIVIDE= '/' ;


	private Stack<Double> stack;


	/**
	 * Creates a new calculator with an empty number stack
	 */
	public Calculator() {
		stack = new Stack<Double>();
	}

	/**
	 * Precondition: entry is either a double value or a recognized operator [
	 * +, -, *, /] Postcondition: if the entry is a double, the value is pushed
	 * onto the calculator's number stack. If an operator, the top two values
	 * are popped from the stack, the operation performed, and the result pushed
	 * onto the stack. Note: the second operator is popped first.
	 */
	public void enter(String entry) {
		Scanner sc = new Scanner(entry);
		if (sc.hasNextDouble()) {
			double dub = sc.nextDouble();
			push(dub);
		}

		else {
			for (char c : entry.toCharArray()) {
				if (stack.size()<2||stack.isEmpty()) {
					throw new IllegalArgumentException("Illegal expression");
				} else if (isOperator(c)) {
					double operand2 = stack.pop();
					double operand1 = stack.pop();
					
					switch (c) {
					case ADD:
						push(operand1 + operand2);
						break;
					case MINUS:
						push(operand1 - operand2);
						break;
					case MULTIPLY:
						push(operand1 * operand2);
						break;
					case DIVIDE:
						push(operand1 / operand2);
						break;
					default:
						throw new IllegalArgumentException("Non-operator character");
					}
					sc.close();
				}
			}
		}

	}

	private boolean isOperator(char c) {
		return OPERATOR.indexOf(c) >= 0;
	}

	private void push(Double next) {
		stack.push(next);
	}

	/**
	 * Precondition: number stack is not empty, otherwise throws
	 * EmptyStackException
	 * 
	 * Looks at the number at the top of this stack without removing it from the
	 * stack.
	 */
	public double peek() {
		if (stack.isEmpty()) {
			throw new EmptyStackException();
		} 
		else {
			return stack.peek();
		}
	}

	/**
	 * Precondition: number stack is not empty, otherwise throws
	 * EmptyStackException
	 * 
	 * Removes the number at the top of this stack and returns that value.
	 */
	public double pop() {
		if (this.isEmpty())
			throw new EmptyStackException();
		else {
			return stack.pop();
		}
	}

	/**
	 * Removes all numbers from this stack. The stack will be empty after this
	 * call returns boolean isEmpty Tests If the number stack of this calculator
	 * is empty
	 */
	public void clear() {
		stack.clear();
	}

	/**
	 * Returns the number of values in this calculators number stack.
	 */
	public int size() {
		return stack.size();
	}

	/**
	 * Returns true if number stack is empty.
	 */
	public boolean isEmpty() {
		return stack.isEmpty();
		}
	}

