package stockDataGather;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Class setup to gather stock data from IEX
 *
 * https://iexcloud.io/docs/api/#streaming
 * https://stackoverflow.com/questions/3913502/restful-call-in-java#3916369
 * @author JSWift
 *
 */
public class dataDownloader{
	public static boolean DEBUG = true;
	
	URL productionApiUrl;
	URL standBoxApiUrl;
	String version = "v1";
	String endPointBalanceSheet = "/stock/{symbol}/balance-sheet/{last}/{field}";
	String endPointQuote = "/stock/{symbol}/quote/{field}";
	/**
	 * Last - Optional (Number) - Number of quarters or years to return. Default is 1.
	 * Field - Optional (String) -  
	 * @param args
	 */
	dataDownloader() {
		try {
			productionApiUrl = new URL("https://cloud.iexapis.com/");
			standBoxApiUrl = new URL("https://sandbox.iexapis.com/");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
