package main;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import controller.SettingManager;

import view.SleepFrame;

public class SleepRunnable implements Runnable{
	
	@Override
	public void run() {
		final SleepFrame sleepFrame = new SleepFrame();
		while(true) {
			try {
				sleepFrame.setVisible(false);
				Thread.sleep(getMillisFromMinute(0));
				sleepFrame.getDialog().setVisible(true);
				
				sleepFrame.addWindowFocusListener(new WindowFocusListener() {
					public void windowGainedFocus(WindowEvent e) {}
					public void windowLostFocus(WindowEvent e) {
						sleepFrame.toFront();
					}
				});
				// time count down
				for(int i=5; i>0; i--) {
					sleepFrame.getDialog().getTimeLabel().setText(""+i+"s");
					Thread.sleep(1000);
				}
				sleepFrame.getDialog().setVisible(false);
				sleepFrame.setVisible(true);
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				return;
			}
		}
	}
	
	public Long getMillisFromMinute(int minute) {
		return 60000L * minute;
	}
}
