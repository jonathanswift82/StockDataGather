package Logger;

/***
 * 
 * @author jswift
 *
 */
public class task implements Runnable{
	
	private final StatusListener myStatusListener;
	private final int ID;
	private final boolean ListenerStatus;
	
	public task() {
		this.ListenerStatus = false;
		this.ID = 0;
		this.myStatusListener = null;
	}
	
	public task(int idNumber, StatusListener listener) {
		this.ListenerStatus = true;
		this.myStatusListener = listener;
		this.ID = idNumber;
		this.myStatusListener.updateStatus(this.ID, STATUS.WAITING);
	}
	public void run() {
		if(this.ListenerStatus) {
			try {
				this.myStatusListener.updateStatus(this.ID, STATUS.IN_PROGRESS);
				Thread.sleep(1000);
				// do things in here
				this.myStatusListener.updateStatus(this.ID, STATUS.FINISHED);
			}catch(InterruptedException e) {
				this.myStatusListener.updateStatus(this.ID, STATUS.FAILED);
			}
		}
	}
	
	public void start() {
		this.myStatusListener.updateStatus(this.ID, STATUS.STARTING);
	}
	
	public int getID() {
		return this.ID;
	}
	@Override
	public String toString() {
		return String.valueOf(this.ID);
	}

}
