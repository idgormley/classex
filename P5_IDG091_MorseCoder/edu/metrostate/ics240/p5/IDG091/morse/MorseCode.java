package edu.metrostate.ics240.p5.IDG091.morse;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import edu.metrostate.ics240.p5.morse.TreeNode;

public class MorseCode {
	/**
	 * Translates the given text of ASCII Latin Characters to its morse code
	 * equivalent. The encoding places a space after each character; a space in
	 * the text is represented as a SLASH ('/') character. The text can be in
	 * mixed case.
	 * 
	 * @param text
	 *            Text to be encoded
	 * @return Text in morse code
	 * 
	 * @throws IllegalArgumentException
	 *             If text has an unrecognized character.
	 * @throws NullPointerException
	 *             If text string is null.
	 */
	public static String encode(String text) {
		Map<Character, String> map = getEncodingMap();
		text = text.toUpperCase();
		StringBuilder encoded = new StringBuilder();
		if (text != null) {
			char[] charaters = text.toCharArray();
			for (char i : charaters) {
				if (map.containsKey(i))
					encoded.append(map.get(i) + " ");
				else if (i == ' ') {
					encoded.setLength(encoded.length() - 1);
					encoded.append("/");
				} else
					throw new IllegalArgumentException(encoded + "Unrecognised character:" + i);
			}
		} else
			throw new NullPointerException();
		encoded.setLength(encoded.length() - 1);
		return encoded.toString();
	}

	/**
	 * 
	 * @return Returns the mapping of encodings from each character to its morse
	 *         code representation.
	 */
	public static Map<Character, String> getEncodingMap() {
		Map<Character, String> map = new HashMap<Character, String>();
		final String filePath = "/data/morseCode.txt";
		final InputStream inputFile = MorseCode.class.getResourceAsStream(filePath);
		final Scanner input = new Scanner(inputFile);
		while (input.hasNextLine()) {
			String characterString = input.next();
			Character character = characterString.charAt(0);
			String string = input.next();
			map.put(character, string);
		}
		input.close();
		return map;
	}

	/**
	 * Decodes a Morse code string to UPPER CASE ASCII Characters.
	 * 
	 * @param code
	 *            Morse code to be decoded
	 * @return Uncoded text string
	 * 
	 * @throws IllegalArgumentException
	 *             If code contains an unrecognized string.
	 * @throws NullPointerException
	 *             If code string is null.
	 */
	public static String decode(String code) {
		StringBuilder validMorse = new StringBuilder();
		final String filePath = "/data/morseCode.txt";
		final InputStream inputFile = MorseCode.class.getResourceAsStream(filePath);
		final Scanner input = new Scanner(inputFile);
		while (input.hasNextLine()) {
			input.next();
			String string = input.next();
			validMorse.append(string + " ");
		}
		input.close();
		StringBuilder decode = new StringBuilder();
		if (code != null) {
			String[] morse = code.split(" ");
			for (String i : morse) {
				if (validMorse.indexOf(i) >= 0)
					decode.append(decoder(i));
				else if (i.equals("/"))
					decode.append(" ");
				else
					throw new IllegalArgumentException(decode + " Unrecognised string:" + i);
			}
		} else
			throw new NullPointerException();
		decode.setLength(decode.length() - 1);
		return decode.toString();
	}

	/**
	 * Decodes a Morse code value string into its character value.
	 * 
	 * @param string
	 *            Morse code value
	 * @return character value
	 */
	private static Character decoder(String string) {
		DecodingTree decodeTree = new DecodingTree();
		final String filePath = "/data/morseCode.txt";
		final InputStream inputFile = MorseCode.class.getResourceAsStream(filePath);
		final Scanner input = new Scanner(inputFile);
		while (input.hasNextLine()) {
			String characterValue = input.next();
			Character character = characterValue.charAt(0);
			String code = input.next();
			decodeTree.insert(character, code);
		}
		TreeNode<Character> root = getDecodingTree();
		decodeTree.preorder(root);
		StringBuilder decode = new StringBuilder("x");
		int i = 1;
		if (string.charAt(i - 1) == '-') {
			if (string.length() == i)
				decode.append(root.getLeftChild().getValue());
			else
				decode.append(decoder(root.getLeftChild(), string, i));
		} else if (string.charAt(i - 1) == '*') {
			if (string.length() == i) {
				if (root.getRightChild() != null)
					decode.append(root.getRightChild().getValue());
			} else
				decode.append(decoder(root.getRightChild(), string, i));
		}
		return decode.charAt(0);
	}

	/**
	 * Compares the parentNode's Child values to the morse string recursively.
	 * 
	 * @param parentNode
	 *            Child's values are compared to string
	 * @param string
	 *            A Morse code value
	 * @param i
	 *            integer count that steps through the characters of string.
	 * @return
	 * @return Node matching the string's key
	 */
	private static char decoder(TreeNode<Character> parentNode, String string, int i) {
		StringBuilder decoder = new StringBuilder();
		while (parentNode != null) {
			i++;
			if (string.charAt(i - 1) == '-') {
				if (string.length() == i) {
					decoder.append((parentNode.getLeftChild()).getValue());
					
				} else
					decoder(parentNode.getLeftChild(), string, i);

			} else if (string.charAt(i - 1) == '*') {
				if (string.length() == i) {
					decoder.append((parentNode.getRightChild()).getValue());
					
				} else
					decoder(parentNode.getRightChild(), string, i);
			}
		}
		return decoder.charAt(0);
	}

	/**
	 * Returns the root node of the binary tree used to decode a code string
	 * containing DOTs, DASHes, SLASHes, and space characters to its character
	 * representation. To ensure consistency, the right children represent DOTs,
	 * the left children DASHes.
	 * 
	 * @return the root node of the binary DecodingTree.
	 */
	public static TreeNode<Character> getDecodingTree() {
		TreeNode<Character> root = makeTree();
		
		return root;
	}
	
	public static TreeNode<Character> makeTree() {
		DecodingTree decodeTree = new DecodingTree();
		final String filePath = "/data/morseCode.txt";
		final InputStream inputFile = MorseCode.class.getResourceAsStream(filePath);
		final Scanner input = new Scanner(inputFile);
		while (input.hasNextLine()) {
			String characterValue = input.next();
			Character character = characterValue.charAt(0);
			String code = input.next();
			decodeTree.insert(character, code);
		}
		input.close();
		
		TreeNode<Character> root = decodeTree.getRoot();
		return root;
	}
}