package threads;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;

import view.ThingNoticeDialog;

import model.Setting;
import model.Thing;
import model.Todo;
import controller.SettingManager;
import controller.TodoManager;

public class TimeRunable implements Runnable {
	private Setting setting = SettingManager.getManager().getSetting();
	private TodoManager todoManager = TodoManager.getTodoManager();
	private Todo todo = todoManager.getTodo();
	private List<Thing> things = todo.getThings();
	@Override
	public void run() {
		while(true) {
			check();
			try {
				Thread.sleep(setting.getCheckTime());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void check() {
		List<Integer> noticeThingIndexs = updateTodoStatus();
		Thing thing = null;
		JDialog dialog = null;
		if(!noticeThingIndexs.isEmpty()) { // have something to notice
			for(int i=0; i<noticeThingIndexs.size(); i++) {
				thing = things.get(noticeThingIndexs.get(i));
				dialog = new ThingNoticeDialog(thing);
				dialog.setLocation(dialog.getLocation().x, dialog.getLocation().y-i*(dialog.getSize().height + 5)); // set dialog location
				new DialogThread(dialog).start();
			}
		}
	}
	
	/**
	 * update thing's status with current time
	 */
	public List<Integer> updateTodoStatus() {
		Long nowTime = System.currentTimeMillis();
		Thing thing = null;
		double intervalTime = 0;
		double noticeTime = setting.getNoticeTime().doubleValue();
		List<Integer> noticeThingIndexs = new ArrayList<Integer>();
		for(int i=0; i<things.size(); i++) {
			thing = things.get(i);
			intervalTime = nowTime - thing.getMillis();
			if(intervalTime >= 0 && thing.getStatus() == Thing.TODO) { // time to notice
				thing.setStatus(Thing.DOING);
				noticeThingIndexs.add(i);
			} else if(intervalTime > noticeTime && thing.getStatus() >= Thing.DONE) { // not do;
				thing.setStatus(Thing.NOTDO);
			}
		}
		return noticeThingIndexs;
	}
}
