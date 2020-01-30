package Parser;

import com.google.gson.annotations.SerializedName;

/**
 * IEX symbols JSON object
 * EG: {"symbol":"A","name":"Agilent Technologies Inc.","date":"2019-07-26","isEnabled":true,"type":"cs","iexId":"2"},
 * @author jswift
 *
 */
public class iexCompany {
	@SerializedName("symbol")
	private String ticker; 
	@SerializedName("name")
	private String companyName;
	@SerializedName("date")
	private String date; 
	@SerializedName("isEnabled")
	private boolean isEnabled;
	@SerializedName("type")
	private String type; 
	@SerializedName("iexId")
	private int iexId;
	
	public iexCompany(String ticker, String companyName, String date, boolean isEnabled, String type, int iexId){
		this.ticker = ticker;
		this.companyName = companyName;
		this.date = date;
		this.isEnabled = isEnabled;
		this.type = type;
		this.iexId = iexId;
	}
	
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public boolean isEnabled() {
		return isEnabled;
	}
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	public int getIexId() {
		return iexId;
	}
	public void setIexId(int iexId) {
		this.iexId = iexId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}