package threads;

import model.Setting;
import view.SleepFrame;
import controller.SettingManager;

/**
 * @author VellBibi
 * Sleep Thread
 */
public class SleepRunnable implements Runnable{
	private final SleepFrame sleepFrame = new SleepFrame();
	private Setting setting = SettingManager.getManager().getSetting();
	@Override
	public void run() {
		while(true) {
			try {
				sleepFrame.setVisible(false);
				Thread.sleep(setting.getWorkTime()); // work time
				sleepFrame.getDialog().setVisible(true); // show sleep notice dialog
				
				// time count down for sleep
				for(int i=setting.getBeforeSleepTime(); i>0; i--) {
					sleepFrame.getDialog().setTime(""+i+"s");
					Thread.sleep(1000);
					// delay sleep
					if(setting.isSleepDelay()) {
						setting.setSleepDelay(false);
						Thread.sleep(setting.getDelayTime());
						i = setting.getBeforeSleepTime() + 1;
						sleepFrame.getDialog().setVisible(true);
					}
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
