package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.JDialog;

import util.ResourceBundleUtil;
import controller.SettingManager;


public class SleepDialog extends JDialog{
	private static final long serialVersionUID = 4834422536207853225L;

	private Dimension screenSize = SettingManager.getManager().getSetting().getScreenSize();
	private int height = screenSize.height / 4;
	private int width = screenSize.width / 4;
	private Label timeLabel;
	private Label mesLabel;
	
	public SleepDialog() {		
		initStyle();
		
		addComponents();
	}
	
	private void initStyle() {
		setBounds(screenSize.width - width, screenSize.height - height, width, height);
		setAlwaysOnTop(true);
		setUndecorated(true);
		setLayout(new GridLayout(2, 1));
		setModal(true);
	}
	
	private void addComponents() {
		timeLabel = new Label();
		timeLabel.setAlignment(Label.CENTER);
		timeLabel.setFont(SettingManager.getManager().getSetting().getVfont().deriveFont(40));
		mesLabel = new Label();
		mesLabel.setAlignment(Label.CENTER);
		mesLabel.setText(ResourceBundleUtil.getString("sleepText"));
		mesLabel.setFont(SettingManager.getManager().getSetting().getVfont().deriveFont(20));
		add(timeLabel);
		add(mesLabel);
	}

	public Label getTimeLabel() {
		return timeLabel;
	}

	public void setTimeLabel(Label label) {
		this.timeLabel = label;
	}
}
