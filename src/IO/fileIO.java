package IO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 
 * @author Jswift
 *	Class to handle File IO, creating, parsing, writing, reading
 */
public class fileIO {

	private String path = null;
	public fileIO() {
		this(null);
	}
	
	public fileIO(String path) {
		this.path = path;
	}
	
	public String currentWorkingDirectory() {
		Path currentRelativePath = Paths.get("");
		return currentRelativePath.toAbsolutePath().toString();
	}
	
	public void writeToFile(String input) {
		this.writeToFile(this.path, input);
	}
	
	public void writeToFile(String newPath, String input) {
	    try {
	        File file = new File(newPath);
	        if (!file.exists()) {
	            file.createNewFile();
	        } 
	        FileOutputStream writer = new FileOutputStream(newPath);
	        writer.write((input).getBytes());
	        writer.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public String readFile() throws IOException {
		return this.readFile(this.path);
	}
	
	public String readFile(String newPath) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(newPath));
		return new String(encoded);
	}
	/**
	 * Used for testing class
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String args[]) throws IOException {
		 fileIO test = new fileIO();
		 String path = "test.txt";
		 test.writeToFile(path,"test");
		 System.out.println("read from file:"+test.readFile(path));
	}
}
