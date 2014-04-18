package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

import controller.DelayButtonListener;
import controller.DoneButtonListener;
import controller.ModifyButtonListener;
import controller.SettingManager;

public class ThingNoticeDialog extends Dialog{
	private static final long serialVersionUID = -7684181078148441850L;
	
	private Dimension screenSize = SettingManager.getManager().getSetting().getScreenSize();
	private int height = screenSize.height / 4;
	private int width = screenSize.width / 4;
	private Label timeLabel;
	private Label mesLabel;
	private Button doneButton;
	private Button delayButton;
	private Button modifyButton;
	private Panel mesPanel;
	private Panel buttonPanel;
	
	public ThingNoticeDialog(Frame owner) {
		super(owner);
		
		initStyle();
		
		addComponents();
		
		addListener();
	}
	
	private void initStyle() {
		setAlwaysOnTop(true);
		setUndecorated(true);
		setLayout(new BorderLayout());
		setBounds(screenSize.width - width, screenSize.height - height, width, height);
	}
	
	private void addComponents() {
		mesPanel = new Panel(new GridLayout(2, 1));
		add(mesPanel, BorderLayout.CENTER);
		
		timeLabel = new Label();
		timeLabel.setAlignment(Label.CENTER);
		timeLabel.setFont(SettingManager.getManager().getSetting().getVfont().deriveFont(40));
		mesPanel.add(timeLabel);
		
		mesLabel = new Label();
		mesLabel.setAlignment(Label.CENTER);
		mesLabel.setFont(SettingManager.getManager().getSetting().getVfont().deriveFont(20));
		mesPanel.add(mesLabel);
		
		buttonPanel = new Panel(new GridLayout(1, 3));
		add(buttonPanel, BorderLayout.SOUTH);
		
		doneButton = new Button("done");
		modifyButton = new Button("modify");
		delayButton = new Button("delay");
		
		buttonPanel.add(doneButton);
		buttonPanel.add(delayButton);
		buttonPanel.add(modifyButton);
	}
	
	private void addListener() {
		doneButton.addMouseListener(new DoneButtonListener());
		modifyButton.addMouseListener(new ModifyButtonListener());
		delayButton.addMouseListener(new DelayButtonListener());
	}

	public Label getTimeLabel() {
		return timeLabel;
	}

	public Label getMesLabel() {
		return mesLabel;
	}
}
