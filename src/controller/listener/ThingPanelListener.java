package controller.listener;

import java.awt.Component;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.Thing;
import view.ThingPanelMenu;

public class ThingPanelListener implements MouseListener {
	
	private ThingPanelMenu menu = null;
	private Component fatherComponent = null;
	private Thing thing = null;
	
	public ThingPanelListener(Component fatherComponent, Thing thing) {
		this.fatherComponent = fatherComponent;
		this.thing = thing;
		this.menu = new ThingPanelMenu(this.thing);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getModifiers() == InputEvent.BUTTON3_MASK) { 
			showMenu(e);
		}
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
	
	private void showMenu(MouseEvent e) {
		menu.show(fatherComponent, e.getX(), e.getY());
	}
}
