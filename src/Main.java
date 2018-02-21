// Christin Scott

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 * 
 * @author CMGS
 *
 */
public class Main {

	/**  **/
	private final static StringBuilder myText = new StringBuilder();

	/**  **/
	private static CodingTree myCodingTree;

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// read in from a text file
		// output two files (codes text file and compressed binary file
		// display statistics (output the original size in bits or bytes, the compressed size in bits or bytes, the 
		// compression ratio as a percentage, and the elapsed time for compression)
		FileReader inputStream = null;

		try {
			inputStream = new FileReader("src\\test1");
			BufferedReader bufferedStream = new BufferedReader(inputStream);
			String line;
			while ((line = bufferedStream.readLine()) != null) {
				myText.append(line);
//				myText.append(" ");
			}
			myCodingTree = new CodingTree(myText.toString());
			bufferedStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {}
	}

}
