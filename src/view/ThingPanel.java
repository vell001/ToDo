package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;

import manager.listener.ThingPanelListener;
import model.Thing;

public class ThingPanel extends JPanel{
	private static final long serialVersionUID = -2185655644123920126L;
	
	private JLabel timeLabel;
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
		setSize(300, 100);
	}
	
	private void addComponents() {
		timeLabel = new JLabel();
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
	
	public JLabel getTimeLabel() {
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
		this.timeLabel.setBackground(Thing.backgroundColors[thing.getStatus()]);
		// update text
		this.timeLabel.setText(thing.getDate());
		this.messageText.setText(thing.getMessage());
		this.timeLabel.setOpaque(true);
		this.messageText.setOpaque(true);
		updateUI();
	}
}
