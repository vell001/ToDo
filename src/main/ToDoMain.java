package main;

public class ToDoMain {
	public static void main(String[] args) throws InterruptedException {
		// start a sleep thread
		SleepRunnable SR = new SleepRunnable();
		Thread SRT = new Thread(SR, "sleep");
		SRT.start();
		
		// start a time thread
		
	}
}
