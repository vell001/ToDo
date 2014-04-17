package main;

public class ToDoMain {
	public static void main(String[] args) throws InterruptedException {
		// start a sleep thread
		SleepRunnable sleepRunnable = new SleepRunnable();
		Thread sleepRunnableThread = new Thread(sleepRunnable, "sleep");
		sleepRunnableThread.start();
		
		// start a time thread
		
	}
}
