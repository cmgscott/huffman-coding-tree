// Christin Scott

/**
 * 
 * @author CMGS
 *
 */
public class FrequencyCalculator {
	/**  **/
	private static int totalSymbolsInText;
	
	/**
	 * 
	 */
	public FrequencyCalculator() {
		totalSymbolsInText = 0;
	}

	/**
	 * 
	 * @param symbol
	 * @param theText
	 * @return
	 */
	public static int calculateFreq(char symbol, String theText) {
		int count = 0;
		for (int i = 0; i < theText.length(); i++) {
			if (symbol == theText.charAt(i)) {
				count++;
			}
		}
		return count;
	}
	
	/**
	 * 
	 * @param theText
	 * @return
	 */
	public static int findTotalSymbols(String theText) {
		for (int i = 0; i < theText.length(); i++) {
				totalSymbolsInText++;
		}
		return totalSymbolsInText;
	}

}
