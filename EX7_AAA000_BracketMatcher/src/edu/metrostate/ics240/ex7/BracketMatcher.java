package edu.metrostate.ics240.ex7;

import java.util.Stack;

public class BracketMatcher {

	// important that close delim order matches open delims
	public final static String OPEN_DELIMS = "({[<";
	public final static String CLOSE_DELIMS = ")}]>";

	/**
	 * 
	 * @param pattern
	 *            string of characters, cannot be null
	 * @return
	 */
	public static boolean isValid(String pattern) {
		Stack<Character> openDelims = new Stack<>();

		boolean validated = true;
		for (char c : pattern.toCharArray()) {
			if (isOpenDelim(c)) {
				openDelims.push(c);
			} else if (isCloseDelim(c)) {
				if (openDelims.isEmpty() || !isMatch(openDelims.pop(), c)) {
					validated = false;
					break;
				}
			}
		}

		return (validated && openDelims.isEmpty());
	}

	private static boolean isMatch(Character openDelim, char closeDelim) {
		return OPEN_DELIMS.indexOf(openDelim) == CLOSE_DELIMS.indexOf(closeDelim);
	}

	private static boolean isOpenDelim(char c) {
		return OPEN_DELIMS.indexOf(c) >= 0;
	}

	private static boolean isCloseDelim(char c) {
		return CLOSE_DELIMS.indexOf(c) >= 0;
	}

}
