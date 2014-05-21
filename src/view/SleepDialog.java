package view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;

import util.ResourceBundleUtil;
import controller.SettingManager;


public class SleepDialog extends JDialog{
	private static final long serialVersionUID = 4834422536207853225L;

	private Dimension screenSize = SettingManager.getManager().getSetting().getScreenSize();
	private int height = screenSize.height / 4;
	private int width = screenSize.width / 4;
	private JLabel timeLabel;
	private JLabel mesLabel;
	
	public SleepDialog() {
		initStyle();
		
		addComponents();
	}
	
	private void initStyle() {
		setBounds(screenSize.width - width, screenSize.height - height, width, height);
		setAlwaysOnTop(true);
		setUndecorated(true);
		setLayout(new GridLayout(2, 1));
	}
	
	private void addComponents() {
		timeLabel = new JLabel("time", JLabel.CENTER);
		timeLabel.setFont(SettingManager.getManager().getSetting().getVfont().deriveFont(40));
		mesLabel = new JLabel("message", JLabel.CENTER);
		mesLabel.setText(ResourceBundleUtil.getString("sleepText"));
		mesLabel.setFont(SettingManager.getManager().getSetting().getVfont().deriveFont(20));
		timeLabel.setOpaque(true);
		mesLabel.setOpaque(true);
		add(timeLabel);
		add(mesLabel);
	}
	
	public void setTime(String time) {
		timeLabel.setText(time);
	}
	
	public void setMessage(String message) {
		mesLabel.setText(message);
	}
}
