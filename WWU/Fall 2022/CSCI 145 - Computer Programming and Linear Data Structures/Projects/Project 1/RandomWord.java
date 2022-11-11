/* 
 * CSCI 145 Version
 */

import java.util.Scanner;
import java.util.Random;

public class RandomWord {

	// Enumerated List Word Bank
	enum WordBank {
		algorithms, ASCII, binary, branching, compile, debugging,
		hardware, identifier, Java, logic, loops, machine, memory, narrowing,
		nesting, primitive, processor, software, syntax, widening
	}

	// This variable is set when grading the program --- does not shuffle the word
	// bank
	private static final boolean GRADING_MODE = false;

	// Updated each time we call newWord
	private static int arrayIndex = 0;

	// word array has same length
	static String[] WORD_ARRAY = new String[WordBank.values().length];

	public static void populateWORD_ARRAY() {
		int i = 0;
		for (WordBank p : WordBank.values()) {
			WORD_ARRAY[i] = p.toString();
			i++;
		}

		// If grading mode is off, shuffle word bank.
		if (!GRADING_MODE)
			shuffleWordBank();
	}

	public static void shuffleWordBank() {
		Random r = new Random();
		int index1, index2;

		for (int i = 0; i < 50; i++) // Performs 50 random "swaps" of indices.
		{

			index1 = r.nextInt(20); // random index between 0-19
			index2 = r.nextInt(20); // random index between 0-19
			swap(index1, index2);
		}
	}

	public static void swap(int a, int b) // swaps items @ indices a & b in WORD_ARRAY
	{
		String temp = WORD_ARRAY[a];
		WORD_ARRAY[a] = WORD_ARRAY[b];
		WORD_ARRAY[b] = temp;
	}

	public static String newWord() // returns the next word in the bank
	{
		// On first call, populate the word array.
		if (arrayIndex == 0)
			populateWORD_ARRAY();

		String myWord = WORD_ARRAY[arrayIndex];
		arrayIndex++;
		return myWord;

	}

	// Hidden method to print word bank contents - can be used for grading
	public static void printWORD_ARRAY() {
		for (int i = 0; i < WORD_ARRAY.length; i++) {
			System.out.println(i + ":\t" + WORD_ARRAY[i]);
		}
	}
}