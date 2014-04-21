package threads;

import javax.swing.JDialog;

import controller.SettingManager;

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
			dialog.setVisible(false);
		}
	}

	public JDialog getDialog() {
		return dialog;
	}
}
