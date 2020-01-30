package Logger;

import java.util.ArrayList;

/**
 * https://stackoverflow.com/questions/42071046/threadpoolexecutor-get-a-specific-runnable-that-is-being-executed
 * @author JSwift
 *
 */
public class TaskStatusListener implements StatusListener{
	
	private ArrayList<Object> tasks = new ArrayList<Object>();
	
	public TaskStatusListener() {
		
	}

	@Override
	public synchronized void updateStatus(int id, STATUS status) {
		// TODO Auto-generated method stub
		
		String message = Integer.toString(id) + " "+ status;
		System.out.println(message);
		// need to finish setting up logs
	}
	
	/*
	 * public STATUS threadStatus(int id) {
	 * 
	 * }
	 */

}
