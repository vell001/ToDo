package threads;

import javax.swing.JDialog;

import manager.SettingManager;

import view.ThingFrame;


public class DialogThread extends Thread {
	
	private JDialog dialog;
	
	public DialogThread(JDialog dialog) {
		this.dialog = dialog;
	}
	
	@Override
	public void run() {
		dialog.setVisible(true);
		try {
			Thread.sleep(SettingManager.getManager().getSetting().getNoticeTime());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			ThingFrame.getThingFrame().updateView();
			dialog.setVisible(false);
		}
	}

	public JDialog getDialog() {
		return dialog;
	}
}
