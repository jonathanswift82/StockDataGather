/**
 * 
 */
package Logger;

import IO.fileIO;

/**
 * @author JSwift
 *	https://www.journaldev.com/977/logger-in-java-logging-example#logger-in-java
 */
public class Logger {

	String logFilePath = "_logfile.txt";
	fileIO output = new fileIO(this.logFilePath);
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
