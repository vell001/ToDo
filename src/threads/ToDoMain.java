package threads;

import view.ThingFrame;

public class ToDoMain {
	public static void main(String[] args) throws InterruptedException {
		// start a sleep thread
		SleepRunnable sleepRunnable = new SleepRunnable();
		Thread sleepRunnableThread = new Thread(sleepRunnable, "sleep");
		sleepRunnableThread.start();
		
		// start a time thread
		TimeRunable timeRunable = new TimeRunable();
		Thread timeRunableThread = new Thread(timeRunable, "time");
		timeRunableThread.start();
		ThingFrame f = ThingFrame.getThingFrame();
		f.setVisible(true);
	}
}
