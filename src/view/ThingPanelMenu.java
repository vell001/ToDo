package view;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import util.ResourceBundleUtil;

import model.Thing;
import controller.listener.InsertButtonActionListener;
import controller.listener.ThingMouseListener;

public class ThingPanelMenu extends JPopupMenu {
	private static final long serialVersionUID = -5129788468090313685L;

	private Thing thing = null;
	
	private JMenuItem deleteItem = new JMenuItem(ResourceBundleUtil.getString("deleteButton"));
	private JMenuItem insertItem = new JMenuItem(ResourceBundleUtil.getString("insertButton"));
	private JMenuItem modifyItem = new JMenuItem(ResourceBundleUtil.getString("modifyButton"));
	
	public ThingPanelMenu(Thing thing){
		this.thing = thing;
		setStyle();
		addListeners();
		addItems();
	}
	
	private void setStyle() {
		setAlignmentX(JPopupMenu.CENTER_ALIGNMENT);
	}
	
	private void addItems() {
		add(deleteItem);
		add(insertItem);
		add(modifyItem);
	}
	
	private void addListeners() {
		this.insertItem.addActionListener(new InsertButtonActionListener());
		this.deleteItem.addMouseListener(new ThingMouseListener(thing, ThingMouseListener.DELETE, this));
		this.modifyItem.addMouseListener(new ThingMouseListener(thing, ThingMouseListener.MODIFY, this));
	}
}
