package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

import javax.swing.JDialog;

import model.Thing;
import controller.SettingManager;
import controller.listener.ThingMouseListener;

public class ThingNoticeDialog extends JDialog{
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
	private Thing thing;
	
	public ThingNoticeDialog(Thing thing) {
		this.thing = thing;
		initStyle();
		
		addComponents();
		
		addListener();
		
		update();
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
		doneButton.addMouseListener(new ThingMouseListener(thing, ThingMouseListener.DONE));
		modifyButton.addMouseListener(new ThingMouseListener(thing, ThingMouseListener.MODIFY));
		delayButton.addMouseListener(new ThingMouseListener(thing, ThingMouseListener.DELAY));
	}

	public Label getTimeLabel() {
		return timeLabel;
	}

	public Label getMesLabel() {
		return mesLabel;
	}
	
	public void update() {
		this.timeLabel.setText(thing.getDate());
		this.mesLabel.setText(thing.getMessage());
	}
}
