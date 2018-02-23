// Christin Scott

/**
 * The FrequencyCalculator class handles calculating the frequency of characters in a text.
 * @author Christin Scott
 *
 */
public class FrequencyCalculator {
	/** the total number of characters found in the text **/
	private static int totalSymbolsInText;
	
	/**
	 * The constructor for the class. Initializes total number of symbols to zero.
	 */
	public FrequencyCalculator() {
		totalSymbolsInText = 0;
	}

	/**
	 * This method calculates the frequency of the character in the text.
	 * @param symbol the symbol to count the frequency of
	 * @param theText the text to search
	 * @return
	 */
	public static int calculateFreq(char symbol, String theText) {
		/** the count of the character **/
		int count = 0;
		for (int i = 0; i < theText.length(); i++) {
			if (symbol == theText.charAt(i)) {
				count++;
			}
		}
		return count;
	}
	
	/**
	 * This method finds the total number of characters in a text.
	 * @param theText to find total number of characters of
	 * @return the total number of characters in the text
	 */
	public static int findTotalSymbols(String theText) {
		for (int i = 0; i < theText.length(); i++) {
				totalSymbolsInText++;
		}
		return totalSymbolsInText;
	}

}
