/**
 * 
 */
package stockDataGather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.stream.Collectors;

import javax.net.ssl.HttpsURLConnection;

//import com.dslplatform;
//import com.dslplatform.json.DslJson;
//import com.dslplatform.json.JsonReader;

import Logger.FLAG;
import Logger.StatusListener;
import Logger.task;
import IO.fileIO;
/**
 * @author Jswift
 *
 */
public class SymbolDownloader extends task{

	fileIO fileWriter = new fileIO();
	private String rootFileName = "symbols.json";
	private String symbolPath = "\\symbols\\";
	public static String downloadURL = "https://api.iextrading.com/1.0/ref-data/symbols";
	private String downloadedSymbols = null;
	
	/**
	 * Only for local testing
	 */
	private SymbolDownloader() {
		super();
	}
	
	/**
	 * 
	 * @param idNumber
	 * @param listener
	 */
	public SymbolDownloader(int idNumber, StatusListener listener) {
		super(idNumber, listener);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 1. try to open file with todays date
	 * 2. if no file download new symbols, write to file with today's date
	 * @return this.downloadedSymbols
	 */
	public String getSymbols() {
		boolean fileReadFailure = false;
		if(this.downloadedSymbols == null) {
			if(FLAG.FLAG_DEBUG) {
				System.out.println("downloadedSymbols is null");
			}
			try {
				this.downloadedSymbols = fileWriter.readFile(fileWriter.currentWorkingDirectory()+this.symbolPath+this.getStringYearMonthDay()+"_"+this.rootFileName);
				System.out.println("reading file successful, found todays download");
			} catch (IOException e) {
				fileReadFailure = true;
				if(FLAG.FLAG_DEBUG) {
					System.out.println("fileReadFailure TRUE, no download for today found");
				}
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			if(fileReadFailure) {
				this.downloadSymbols();
				fileWriter.writeToFile(fileWriter.currentWorkingDirectory()+this.symbolPath+this.getStringYearMonthDay()+"_"+this.rootFileName, this.downloadedSymbols);
			}
		}
		return this.downloadedSymbols;
	}
	
	@SuppressWarnings("static-access")
	@Override
	public void start() {
		if(FLAG.FLAG_DEBUG) {
			System.out.print("SymbolDownloader has STARTED URL: "+ this.downloadURL +"\n");
		}
	}
	
	public void run() {
		this.getSymbols();
	}
	
	/**
	 * Downloads Symbols from SymbolDownloader.downloadURL and stores the in SymbolDownloader.downloadedSymbols
	 */
	private void downloadSymbols() {
    	try {
			URL obj = new URL(SymbolDownloader.downloadURL);
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			this.downloadedSymbols = in.lines().collect(Collectors.joining());
			if(FLAG.FLAG_DEBUG) {
				System.out.println("URL: "+ obj.toString() +"\n"+this.downloadedSymbols.substring(0, 20));
			}
			in.close();
			con.disconnect();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
	}
	
	/**
	 * 
	 * @return String of Year-Month-Day
	 */
	private String getStringYearMonthDay() {
		Date today = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		return Integer.toString(year)+"-"+Integer.toString(month+1)+"-"+Integer.toString(day);
	}
	
	/**
	 * Tests for SymbolDownloader
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SymbolDownloader test = new SymbolDownloader();
		@SuppressWarnings("unused")
		String symbols = test.getSymbols();
	}
}