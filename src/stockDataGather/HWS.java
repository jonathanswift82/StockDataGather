package stockDataGather;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class HWS {
	// Production:
	// https://could.iexapis.com/v1/stock/AAPL/financials/token={TOKEN}&period=annual
	// base url			: https://could.iexapis.com
	// version			: /v1/
	// endpoint path	: stock/{TICKER}/financials/2
	// query string		: ?token={TOKEN}&period=annual
	//
	// SandBox:
	// https://sandbox.iexapis.com/beta/stock/AAPL/financials/2?token=YOUR_TEST_TOKEN_HERE&period=annual
	String version_V1 = "v1";
	String version_BETA = "beta";
	String endPoint_BalanceSheet = "/stock/{symbol}/balance-sheet/{last}/{field}";
	String endPoint_Quote = "/stock/{symbol}/quote/{field}";
	String getSymbolsURL = "/ref-data/symbols";
	String ApiBaseUrl_PRODUCTION = "https://cloud.iexapis.com/";
	String ApiBaseUrl_SANDBOX = "https://sandbox.iexapis.com/";
	
	String Token_SECRET = "sk_d9a8ce6747bc429c9b53bec60287612f";
	String Token_PUBLISHABLE = "pk_0c05696ca7a34d8f933ae7e9516ab498";
			
	
	public HWS() {
	
	}
	
    public static void main(String[] args){
    	try {
	    	HWS test = new HWS();
	    	String url =  test.ApiBaseUrl_PRODUCTION
	    			+ "/v1/stock/AAPL/financials/2?token="
	    			+test.Token_PUBLISHABLE
	    			+ "&amp;period=annual";
	    	
	    	String url1 = test.ApiBaseUrl_PRODUCTION
	    			+ "/beta/stock/AAPL/financials/2?token="
	    			+ test.Token_PUBLISHABLE
	    			+ "&period=annual";
    			
    	
    			URL obj = new URL(url1);
    			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
    			con.setRequestMethod("GET");
    			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    			in.close();
    			con.disconnect();
    			
    			System.out.print("URL: "+ obj.toString() +"\n"+in.lines().toString());
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }   	
}
