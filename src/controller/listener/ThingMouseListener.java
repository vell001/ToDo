package controller.listener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.Setting;
import model.Thing;
import view.ModifyThingDialog;
import view.ThingFrame;
import controller.SettingManager;
import controller.TodoManager;

/**
 * @author VellBibi
 * DELETE MODIFY DELAY DONE
 */
public class ThingMouseListener implements MouseListener {
	public static int DELETE=0, MODIFY=1, DELAY=2, DONE=3;
	private Setting setting = SettingManager.getManager().getSetting();
	private Thing thing = null;
	private int command = -1;
	private Component component = null;
	public ThingMouseListener(Thing thing, int command, Component component) {
		this.thing = thing;
		this.command = command;
		this.component = component;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println(command + " : ThingListenerPressed : " + thing.getMessage());
		switch (command) {
		case 0:
			thing.setStatus(Thing.DELETE);
			break;
		case 1:
			new ModifyThingDialog(thing).setVisible(true);
			break;
		case 2:
			thing.setMillis(thing.getMillis() + setting.getDelayTime());
			thing.setStatus(Thing.TODO);
			break;
		case 3:
			thing.setStatus(Thing.DONE);
			break;
		default:
			break;
		}
		TodoManager.getTodoManager().saveTodo();
		ThingFrame.getThingFrame().updateView();
		component.setVisible(false);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}
