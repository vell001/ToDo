package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.ScrollPane;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Thing;
import util.ImageUtil;
import controller.listener.InsertMouseListener;
import controller.listener.ThingMouseListener;
import controller.listener.SettingMouseListener;
import controller.listener.UpdateMouseListener;
import controller.listener.VellWindowListener;

public class ThingFrame extends JFrame {
	private static final long serialVersionUID = 1950987589795392479L;
	private List<Thing> thingList = null;
	private List<ThingPanel> thingPanelList = null;
	private JPanel thingListPanel = null;
	private JPanel topPanel = null;
	private JButton insertButton = null;
	private JButton updateButton = null;
	private JButton settingButton = null;
	public ThingFrame(List<Thing> thingList){
		if(thingList != null) this.thingList = thingList;
		else thingList = new ArrayList<Thing>();
		initThingPanelList();
		initStyle();
		addComponents();
		addListeners();
	}
	
	private void initStyle() {
		setTitle("Things");
		Image img=ImageUtil.getImage("/images/logo.png");
		setIconImage(img);
		setBounds(0, 0, 400, 600);
		setResizable(false);
	}

	private void addComponents() {
		setLayout(new BorderLayout());
		thingListPanel = new JPanel(new GridLayout(thingPanelList.size(), 1, 0, 5));
		Iterator<ThingPanel> it = thingPanelList.iterator();
		while(it.hasNext()) {
			thingListPanel.add(it.next());
		}
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.add(thingListPanel);
		add(scrollPane, BorderLayout.CENTER);
		
		// top button
		topPanel = new JPanel(new GridLayout(1, 2));
		insertButton = new JButton("insert");
		updateButton = new JButton("update");
		settingButton = new JButton("setting");
		topPanel.add(insertButton);
		topPanel.add(updateButton);
		topPanel.add(settingButton);
		add(topPanel, BorderLayout.NORTH);
	}
	
	private void addListeners() {
		addWindowListener(new VellWindowListener());
		this.insertButton.addMouseListener(new InsertMouseListener());
		this.updateButton.addMouseListener(new UpdateMouseListener());
		this.settingButton.addMouseListener(new SettingMouseListener());
	}
	
	/**
	 * read thingList and new thingPanel to thingPanelList
	 */
	private void initThingPanelList() {
		Iterator<Thing> thingIterator = thingList.iterator();
		thingPanelList = new ArrayList<ThingPanel>();
		while(thingIterator.hasNext()) {
			thingPanelList.add(new ThingPanel(thingIterator.next()));
		}
	}

	public List<Thing> getThingList() {
		return thingList;
	}

	public void setThingList(List<Thing> thingList) {
		this.thingList = thingList;
	}
}
