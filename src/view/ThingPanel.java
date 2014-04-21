package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Label;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;

import model.Thing;
import controller.listener.ThingPanelListener;

public class ThingPanel extends JPanel{
	private static final long serialVersionUID = -2185655644123920126L;
	
	private Label timeLabel;
	private JTextArea messageText;
	private final Thing thing;
	
	public ThingPanel(Thing thing) {
		this.thing = thing;
		initStyle();
		addComponents();
		updateView();
		addListeners();
	}
	
	private void initStyle() {
		setLayout(new BorderLayout());
		setBorder(new BevelBorder(BevelBorder.RAISED, Color.blue, Color.GRAY));
	}
	
	private void addComponents() {
		timeLabel = new Label();
		messageText = new JTextArea();
		messageText.setEditable(false);
		messageText.setLineWrap(true);
		add(timeLabel, BorderLayout.NORTH);
		add(messageText, BorderLayout.CENTER);
	}
	
	private void addListeners() {
		this.timeLabel.addMouseListener(new ThingPanelListener(this.timeLabel, thing));
		this.messageText.addMouseListener(new ThingPanelListener(this.messageText, thing));
	}
	
	public Label getTimeLabel() {
		return timeLabel;
	}

	public JTextArea getMessageText() {
		return messageText;
	}
	
	public Thing getThing() {
		return thing;
	}
	
	public void updateView() {
		// update color
		this.timeLabel.setForeground(Color.WHITE);
		this.timeLabel.setBackground(thing.backgroundColors[thing.getStatus()]);
		// update text
		this.timeLabel.setText(thing.getDate());
		this.messageText.setText(thing.getMessage());
	}
}
