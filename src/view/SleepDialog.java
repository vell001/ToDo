package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import util.ResourceBundleUtil;
import controller.SettingManager;


public class SleepDialog extends JDialog{
	private static final long serialVersionUID = 4834422536207853225L;

	private Dimension screenSize = SettingManager.getManager().getSetting().getScreenSize();
	private int height = screenSize.height / 4;
	private int width = screenSize.width / 4;
	private JLabel timeLabel;
	private JLabel mesLabel;
	private JPanel buttonPanel;
	private JPanel mesPanel;
	private JButton delayButton;
	
	public SleepDialog() {
		initStyle();
		
		addComponents();
		
		addListeners();
	}
	
	private void addListeners() {
		delayButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SettingManager.getManager().getSetting().setSleepDelay(true);
				setVisible(false);
			}
		});
	}

	private void initStyle() {
		setBounds(screenSize.width - width, screenSize.height - height, width, height);
		setAlwaysOnTop(true);
		setUndecorated(true);
		setLayout(new BorderLayout());
	}
	
	private void addComponents() {
		timeLabel = new JLabel("time", JLabel.CENTER);
		timeLabel.setFont(SettingManager.getManager().getSetting().getVfont().deriveFont(40));
		mesLabel = new JLabel("message", JLabel.CENTER);
		mesLabel.setText(ResourceBundleUtil.getString("sleepText"));
		mesLabel.setFont(SettingManager.getManager().getSetting().getVfont().deriveFont(20));
		timeLabel.setOpaque(true);
		mesLabel.setOpaque(true);
		
		mesPanel = new JPanel(new GridLayout(2, 1));
		buttonPanel = new JPanel(new GridLayout(1,1));
		delayButton = new JButton(ResourceBundleUtil.getString("delayButton"));
		mesPanel.add(timeLabel);
		mesPanel.add(mesLabel);
		buttonPanel.add(delayButton);
		
		this.add(mesPanel, BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.SOUTH);
	}
	
	public void setTime(String time) {
		timeLabel.setText(time);
	}
	
	public void setMessage(String message) {
		mesLabel.setText(message);
	}
}
