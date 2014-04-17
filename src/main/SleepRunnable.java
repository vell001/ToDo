package main;

import view.SleepFrame;
import controller.SettingManager;

/**
 * @author VellBibi
 * Sleep Thread
 */
public class SleepRunnable implements Runnable{
	
	@Override
	public void run() {
		final SleepFrame sleepFrame = new SleepFrame();
		while(true) {
			try {
				sleepFrame.setVisible(false);
				Thread.sleep(getMillisFromMinute(SettingManager.getManager().getDBSetting().getWorkTime())); // work time
				sleepFrame.getDialog().setVisible(true); // show sleep notice dialog
				
				// time count down for sleep
				for(int i=SettingManager.getManager().getDBSetting().getBeforeSleepTime(); i>0; i--) {
					sleepFrame.getDialog().getTimeLabel().setText(""+i+"s");
					Thread.sleep(1000);
				}
				
				sleepFrame.getDialog().setVisible(false); // hidden sleep notice dialog
				sleepFrame.setVisible(true); // start sleep
				Thread.sleep(getMillisFromMinute(SettingManager.getManager().getDBSetting().getSleepTime()));
			} catch (InterruptedException e) {
				return;
			}
		}
	}
	
	public Long getMillisFromMinute(int minute) {
		return 60000L * minute;
	}
}
