package Manager;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import Logger.TaskStatusListener;
import Logger.task;
//import stockDataGather.SymbolDownloader;

public class Manager {
	
	private int CorePoolSize = 4;
	private int maximumPoolSize = 10;
	private long keepAliveTime = 10;
	private int backLogSize = 10;
	private ArrayBlockingQueue<Runnable> threadBackLog = new ArrayBlockingQueue<Runnable>(this.backLogSize);
	MyMonitorThread monitor;
	Thread monitorThread;
	RejectedExecutionHandlerImpl rejectionHandler;
	ThreadFactory threadFactory;
	ThreadPoolExecutor executorPool;
	TaskStatusListener taskLister;
	
	public Manager() {
        //RejectedExecutionHandler implementation
        rejectionHandler = new RejectedExecutionHandlerImpl();
        //Get the ThreadFactory implementation to use
        threadFactory = Executors.defaultThreadFactory();
        //creating the ThreadPoolExecutor
        executorPool = new ThreadPoolExecutor(this.CorePoolSize, this.maximumPoolSize,
        										this.keepAliveTime, TimeUnit.SECONDS, 
        										threadBackLog, threadFactory, rejectionHandler);
        //start the monitoring thread
        monitor = new MyMonitorThread(executorPool, 3);
        monitorThread = new Thread(monitor);
        monitorThread.start();
        
        this.taskLister = new TaskStatusListener();
	}
	
	public void shutdown() throws InterruptedException {
		Thread.sleep(3000);
		executorPool.shutdown();
		Thread.sleep(5000);
		monitor.shutdown();
		System.out.println("finished");
	}
	
//	public void downloadSymbols() {
//		SymbolDownloader test  = new SymbolDownloader();
//		test.start();
//		test.run();
//	}
	
	public void addThread(task task) {
		this.executorPool.execute(task);
	}
	
	public void removeThread(task task) {
		this.executorPool.remove(task);
	}
	
	public String threadStatus(Runnable task) {
		//String status = this.executorPool.
		
		//return status;
		return "";
	}
	
	public String threadPoolStatus() {
		String status = "";
		
		return status;		
	}
	
    public static void main(String args[]) throws InterruptedException{
    	System.out.println("Manager Test Cases");
    	Manager manage = new Manager();
        //submit work to the thread pool
        for(int i=0; i<23; i++){
            manage.addThread(new task(i, manage.taskLister));
        }
        while(true) {
        	if(manage.executorPool.getCompletedTaskCount() == manage.executorPool.getTaskCount()) {
        		break;
        	}
        	else {
        		Thread.sleep(3000);
        	}
        }
    	manage.shutdown();
    }
}
