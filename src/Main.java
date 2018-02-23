// Christin Scott

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The main class.
 * @author Christin Scott
 *
 */
public class Main {

	/** the text to compress **/
	private final static StringBuilder myText = new StringBuilder();
	
	/** original file size **/
	private static long fileSize;
	
	/** the coding tree **/
	static CodingTree myCodingTree;

	/**
	 * This method launches the encoder.
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		// read in from a text file
		// output two files (codes text file and compressed binary file
		// display statistics (output the original size in bits or bytes, the compressed size in bits or bytes, the 
		// compression ratio as a percentage, and the elapsed time for compression)
		FileReader inputStream = null;

		try {
			inputStream = new FileReader("src\\test1");
			BufferedReader bufferedStream = new BufferedReader(inputStream);
			String line;
			File theFile = new File("src\\test1");
			System.out.println("File size before compression: " + theFile.length() + " bytes");
			while ((line = bufferedStream.readLine()) != null) {
				myText.append(line);
			}
			myCodingTree = new CodingTree(myText.toString());
			fileSize = theFile.length();
			bufferedStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			writeToFile();
			System.out.println("Running time: " + (System.currentTimeMillis() - startTime) + " milliseconds");
			}
		
	}

	/**
	 * Method to write the newly encoded message to a new file, and display some results information to console.
	 */
	private static void writeToFile() {
		FileOutputStream outFile = null;
		BufferedWriter codesOutFile = null;

		try {
			Map<Character, String> codes = myCodingTree.getCodes();
			List<Character> encodedMsg = myCodingTree.getEncodedMsg();
			outFile = new FileOutputStream("compressed.txt");
			codesOutFile = new BufferedWriter(new FileWriter("codes.txt"));
			for (int i = 0; i < encodedMsg.size(); i++) {
				outFile.write(encodedMsg.get(i));
			}
			Set<Character> keyMap = codes.keySet();
			for (char c : keyMap) {
				codesOutFile.write("" + c + ": " + codes.get(c));
				codesOutFile.newLine();
			}
			File theFile = new File("compressed.txt");
			System.out.println("Compressed file size:         " + theFile.length() + " bytes");
			if (fileSize != 0) {
				System.out.println("Compression ratio: " + (theFile.length() * 100) / fileSize + "%");
			} else {
				System.out.println("Compression ratio: N/A");
			}
			outFile.close();
			codesOutFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
