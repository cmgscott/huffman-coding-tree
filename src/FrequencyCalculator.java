
public class FrequencyCalculator {
	
	private static int totalSymbolsInText;
	
	public FrequencyCalculator() {
		totalSymbolsInText = 0;
	}

	public static int calculateFreq(char symbol, String theText) {
		int count = 0;
		for (int i = 0; i < theText.length(); i++) {
			if (symbol == theText.charAt(i)) {
				count++;
			}
		}
		// for debugging
//		System.out.println("The frequency of "+ symbol + " is: " + count + " times");
		return count;
	}
	
	public static int findTotalSymbols(String theText) {
		for (int i = 0; i < theText.length(); i++) {
				totalSymbolsInText++;
		}
		return totalSymbolsInText;
	}
	
	// for debugging
	public static void printTotalSymbols() {
		System.out.println("Total number of symbols: " + totalSymbolsInText);
	}

}
