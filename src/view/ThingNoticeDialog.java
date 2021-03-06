package view;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JLabel;

import util.ResourceBundleUtil;

import manager.SettingManager;
import manager.listener.ThingMouseListener;
import model.Setting;
import model.Thing;

public class ThingNoticeDialog extends JDialog{
	private static final long serialVersionUID = -7684181078148441850L;
	private Setting setting = SettingManager.getManager().getSetting();
	
	private Dimension screenSize = SettingManager.getManager().getSetting().getScreenSize();
	private int height = screenSize.height / 4;
	private int width = screenSize.width / 4;
	private JLabel timeLabel;
	private JLabel mesLabel;
	private Button doneButton;
	private Button delayButton;
	private Button modifyButton;
	private Panel mesPanel;
	private Panel buttonPanel;
	private Thing thing;
	
	public ThingNoticeDialog(Thing thing) {
		this.thing = thing;
		this.enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		initStyle();
		
		addComponents();
		
		addListener();
		
		update();
	}
	
	private void initStyle() {
		setAlwaysOnTop(true);
		//setUndecorated(true);
		setLayout(new BorderLayout());
		setBounds(screenSize.width - width, screenSize.height - height, width, height);
		setIconImage(setting.getIcon());
		setModal(true);
	}
	
	@Override
	protected void processWindowEvent(WindowEvent e) {
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			return; // 直接返回，阻止默认动作，阻止窗口关闭
		}
		super.processWindowEvent(e);
	}

	private void addComponents() {
		mesPanel = new Panel(new GridLayout(2, 1));
		add(mesPanel, BorderLayout.CENTER);
		
		timeLabel = new JLabel("time", JLabel.CENTER);
		timeLabel.setFont(SettingManager.getManager().getSetting().getVfont().deriveFont(40));
		mesPanel.add(timeLabel);
		
		mesLabel = new JLabel("message", JLabel.CENTER);
		mesLabel.setFont(SettingManager.getManager().getSetting().getVfont().deriveFont(20));
		mesPanel.add(mesLabel);
		
		buttonPanel = new Panel(new GridLayout(1, 3));
		add(buttonPanel, BorderLayout.SOUTH);
		
		doneButton = new Button(ResourceBundleUtil.getString("doneButton"));
		modifyButton = new Button(ResourceBundleUtil.getString("modifyButton"));
		delayButton = new Button(ResourceBundleUtil.getString("delayButton"));
		
		buttonPanel.add(doneButton);
		buttonPanel.add(delayButton);
		buttonPanel.add(modifyButton);
	}
	
	private void addListener() {
		doneButton.addMouseListener(new ThingMouseListener(thing, ThingMouseListener.DONE, this));
		modifyButton.addMouseListener(new ThingMouseListener(thing, ThingMouseListener.MODIFY, this));
		delayButton.addMouseListener(new ThingMouseListener(thing, ThingMouseListener.DELAY, this));
	}

	public JLabel getTimeLabel() {
		return timeLabel;
	}

	public JLabel getMesLabel() {
		return mesLabel;
	}
	
	public void update() {
		this.timeLabel.setText(thing.getDate());
		this.mesLabel.setText(thing.getMessage());
	}
}
