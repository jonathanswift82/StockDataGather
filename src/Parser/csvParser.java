package Parser;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Logger.task;

/**
 * CSV parser class
 * help from: https://stackoverflow.com/questions/1441556/parsing-csv-input-with-a-regex-in-java
 * @author Jswift
 *
 */
public class csvParser extends task{
    private final Pattern csvPattern = Pattern.compile("\"([^\"]*)\"|(?<=,|^)([^,]*)(?:,|$)");  
    private ArrayList<String> allMatches = null;    
    private Matcher matcher = null;
    @SuppressWarnings("unused")
	private String match = null;
    private int size;

    public csvParser() {
        allMatches = new ArrayList<String>();
        matcher = null;
        match = null;
    }
    
    public String[] parse(String csvLine) {
        matcher = csvPattern.matcher(csvLine);
        allMatches.clear();
        String match;
        while (matcher.find()) {
            match = matcher.group(1);
            if (match!=null) {
                allMatches.add(match);
            }
            else {
                allMatches.add(matcher.group(2));
            }
        }
        size = allMatches.size();       
        if (size > 0) {
            return allMatches.toArray(new String[size]);
        }
        else {
            return new String[0];
        }           
    }
    /**
     * For testing class
     * @param args
     */
	public static void main(String[] args) {
		String test = "Charles De Gaulle (Paris),0,Van,150.0,";
		csvParser myParser = new csvParser();
		System.out.println("test string: "+test);
		for(String x: myParser.parse(test)) {
			System.out.println(x);
		}
	}
}