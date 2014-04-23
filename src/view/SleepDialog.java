package view;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.util.ResourceBundle;

import javax.swing.JLabel;

import controller.SettingManager;


public class SleepDialog extends Dialog{
	private static final long serialVersionUID = 4834422536207853225L;

	private Dimension screenSize = SettingManager.getManager().getSetting().getScreenSize();
	private int height = screenSize.height / 4;
	private int width = screenSize.width / 4;
	private JLabel timeLabel;
	private JLabel mesLabel;
	
	public SleepDialog(Frame owner) {
		super(owner);
		
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
		timeLabel = new JLabel();
		timeLabel.setAlignmentX(Label.CENTER);
		timeLabel.setFont(SettingManager.getManager().getSetting().getVfont().deriveFont(40));
		mesLabel = new JLabel();
		mesLabel.setAlignmentX(Label.CENTER);
		mesLabel.setText(ResourceBundle.getBundle("string").getString("sleepText"));
		mesLabel.setFont(SettingManager.getManager().getSetting().getVfont().deriveFont(20));
		add(timeLabel);
		add(mesLabel);
	}

	public JLabel getTimeLabel() {
		return timeLabel;
	}

	public void setTimeLabel(JLabel label) {
		this.timeLabel = label;
	}
}
