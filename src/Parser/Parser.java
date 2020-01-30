/**
 * 
 */
package Parser;

import java.util.HashMap;

import Logger.task;

/**
 * @author Jswift
 *
 */
public class Parser extends task{
	
	public Parser() {
		
	}
	
	/**
	 * 
	 * @param DataType type
	 * @param String input
	 */
	void parseString(DataType type, String input) {
		switch(type) {
			case CSV:
				break;
			case JSON:
				break;
			case TAB:
				break;
			case XML:
				break;
			default:
				break;
		}
	}
	
	/**
	 * https://github.com/fabienrenaud/java-json-benchmark
	 * https://stackoverflow.com/questions/2591098/how-to-parse-json-in-java?page=1
	 * @param input
	 * @return
	 */
	@SuppressWarnings("unused")
	private HashMap processJavascript(String input) {
		HashMap<Integer, HashMap<String, String>> hmap = new HashMap<Integer, HashMap<String, String>>();
		return hmap;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
