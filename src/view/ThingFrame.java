package view;

import java.awt.AWTEvent;
import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Setting;
import model.Thing;
import controller.SettingManager;
import controller.TodoManager;
import controller.listener.InsertButtonActionListener;

public class ThingFrame extends JFrame {
	private static final long serialVersionUID = 1950987589795392479L;
	private static ThingFrame thingFrame = new ThingFrame();
	private Setting setting = SettingManager.getManager().getSetting();
	private List<Thing> things = null;
	private List<ThingPanel> thingPanelList = null;
	private JPanel thingListPanel = null;
	private JPanel topPanel = null;
	private ScrollPane scrollPane = null;
	private JButton insertButton = null;
	private JButton updateButton = null;
	private JButton settingButton = null;
	private JButton cleanButton = null;
	private TrayIcon trayIcon = null;
	private Image icon = setting.getIcon();
	private JPanel colorPanel = null;

	private ThingFrame() {
		things = TodoManager.getTodoManager().getTodo().getThings();
		initThingPanelList();
		initStyle();
		addComponents();
		addListeners();
	}
	
	public static ThingFrame getThingFrame() {
		return thingFrame;
	}

	private void initStyle() {
		setTitle("Things");
		setIconImage(icon);
		setBounds(0, 0, 400, 600);
		setResizable(false);
		// trayIcon
		if (SystemTray.isSupported()) {
			trayIcon = new TrayIcon(icon, "Todo");
			SystemTray tray = SystemTray.getSystemTray();
			try {
				tray.add(trayIcon);
			} catch (AWTException e) {
				e.printStackTrace();
			}
		}
		setLocation((setting.getScreenSize().width - getWidth()) / 2,
				(setting.getScreenSize().height - getHeight()) / 2);
	}

	private void addComponents() {
		setLayout(new BorderLayout());
		thingListPanel = new JPanel(new GridLayout(thingPanelList.size(), 1, 0, 5));
		addThingPanel();
		scrollPane = new ScrollPane();
		scrollPane.add(thingListPanel);
		add(scrollPane, BorderLayout.CENTER);
		// top button
		topPanel = new JPanel(new GridLayout(1, 3));
		insertButton = new JButton("insert");
		updateButton = new JButton("update");
		settingButton = new JButton("setting");
		cleanButton = new JButton("clean");
		topPanel.add(insertButton);
		topPanel.add(updateButton);
		topPanel.add(cleanButton);
		topPanel.add(settingButton);
		add(topPanel, BorderLayout.NORTH);
		initColorPanel();
		add(colorPanel, BorderLayout.SOUTH);
	}
	
	private void initColorPanel() {
		JLabel[] colorLabels = {new JLabel("NOTDO"), new JLabel("DELETE"), new JLabel("DONE"), new JLabel("DOING"), new JLabel("TODO")};
		colorPanel = new JPanel(new GridLayout(1, colorLabels.length));
		for(int i=0; i<colorLabels.length; i++) {
			colorLabels[i].setForeground(Thing.backgroundColors[i]);
			colorLabels[i].setAlignmentX(JLabel.CENTER_ALIGNMENT);
			colorPanel.add(colorLabels[i]);
		}
	}

	private void addThingPanel() {
		Iterator<ThingPanel> it = thingPanelList.iterator();
		while (it.hasNext()) {
			thingListPanel.add(it.next());
		}
	}

	private void addListeners() {
		this.enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		this.insertButton.addActionListener(new InsertButtonActionListener());
		this.updateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateView();
			}
		});
		this.cleanButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new CleanThingDialog().setVisible(true);
				updateView();
			}
		});
		this.settingButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SettingDialog().setVisible(true);
			}
		});
		this.trayIcon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (getExtendedState() == JFrame.ICONIFIED) {
					setVisible(true);// 设置为可见
					// 设置窗口状态(在最小化状态弹出显示)
					setExtendedState(JFrame.NORMAL);
					toFront();
				} else {
					setVisible(false);// 设置为可见
					setExtendedState(JFrame.ICONIFIED);
				}
			}
		});
	}

	/*@Override
	protected void processWindowEvent(WindowEvent e) {
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			setExtendedState(JFrame.ICONIFIED);
			return; // 直接返回，阻止默认动作，阻止窗口关闭
		}
		super.processWindowEvent(e); // 该语句会执行窗口事件的默认动作(如：隐藏)
	}*/

	/**
	 * read thingList and new thingPanel to thingPanelList
	 */
	private void initThingPanelList() {
		Iterator<Thing> thingIterator = things.iterator();
		thingPanelList = new ArrayList<ThingPanel>();
		while (thingIterator.hasNext()) {
			thingPanelList.add(new ThingPanel(thingIterator.next()));
		}
	}

	public List<Thing> getThingList() {
		return things;
	}

	public void setThingList(List<Thing> thingList) {
		this.things = thingList;
	}

	public void updateView() {
		TodoManager.getTodoManager().updateTodoStatus();
		removeOldThingPanel();
		addNewThingPanel();
		this.validate();
		this.repaint();
	}

	private void addNewThingPanel() {
		initThingPanelList();
		addThingPanel();
		thingListPanel.setLayout(new GridLayout(thingPanelList.size(), 1, 0, 5));
		thingListPanel.validate();
		thingListPanel.repaint();
	}

	private void removeOldThingPanel() {
		Iterator<ThingPanel> it = thingPanelList.iterator();
		while (it.hasNext()) {
			thingListPanel.remove(it.next());
		}
	}
}
