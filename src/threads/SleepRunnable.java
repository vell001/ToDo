package threads;

import view.SleepFrame;
import controller.SettingManager;

/**
 * @author VellBibi
 * Sleep Thread
 */
public class SleepRunnable implements Runnable{
	private final SleepFrame sleepFrame = new SleepFrame();
	@Override
	public void run() {
		while(true) {
			try {
				sleepFrame.setVisible(false);
				Thread.sleep(SettingManager.getManager().getSetting().getWorkTime()); // work time
				sleepFrame.getDialog().setVisible(true); // show sleep notice dialog
				
				// time count down for sleep
				for(int i=SettingManager.getManager().getSetting().getBeforeSleepTime(); i>0; i--) {
					sleepFrame.getDialog().setTime(""+i+"s");
					Thread.sleep(1000);
				}
				
				sleepFrame.getDialog().setVisible(false); // hidden sleep notice dialog
				sleepFrame.setVisible(true); // start sleep
				Thread.sleep(SettingManager.getManager().getSetting().getSleepTime());
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}
