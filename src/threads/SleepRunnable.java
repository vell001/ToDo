package threads;

import manager.SettingManager;
import model.Setting;
import view.SleepFrame;

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
					if(setting.getSleepDelay() == Setting.DELAY) {
						setting.setSleepDelay(Setting.NONDELAY);
						Thread.sleep(setting.getDelayTime());
						i = setting.getBeforeSleepTime();
						sleepFrame.getDialog().setVisible(true);
						continue;
					} else if(setting.getSleepDelay() == Setting.DOITNOW) {
						setting.setSleepDelay(Setting.NONDELAY);
						break;
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
