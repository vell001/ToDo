package threads;

import java.util.List;

import javax.swing.JDialog;

import model.Setting;
import model.Thing;
import model.Todo;
import view.ThingNoticeDialog;
import controller.SettingManager;
import controller.TodoManager;

public class TimeRunable implements Runnable {
	private Setting setting = SettingManager.getManager().getSetting();
	private TodoManager todoManager = TodoManager.getTodoManager();
	private Todo todo = todoManager.getTodo();
	private List<Thing> things = todo.getThings();

	@Override
	public void run() {
		while (true) {
			check();
			try {
				Thread.sleep(setting.getCheckTime());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void check() {
		List<Integer> noticeThingIndexs = todoManager.updateTodoStatus();
		Thing thing = null;
		JDialog dialog = null;
		if (!noticeThingIndexs.isEmpty()) { // have something to notice
			for (int i = 0; i < noticeThingIndexs.size(); i++) {
				thing = things.get(noticeThingIndexs.get(i));
				dialog = new ThingNoticeDialog(thing);
				dialog.setLocation(dialog.getLocation().x,
						dialog.getLocation().y - i
								* (dialog.getSize().height + 5)); // set dialog location
				new DialogThread(dialog).start();
			}
		}
	}
}
