package controller.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.Thing;

/**
 * @author VellBibi
 * DELETE MODIFY DELAY DONE
 */
public class ThingMouseListener implements MouseListener {
	public static String DELETE="DELETE", MODIFY="MODIFY", DELAY="DELAY", DONE="DONE";
	private Thing thing = null;
	private String command = null;
	public ThingMouseListener(Thing thing, String command) {
		this.thing = thing;
		this.command = command;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println(command + " : ThingListenerPressed : " + thing.getMessage());
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
