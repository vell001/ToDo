package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import manager.SettingManager;
import manager.TodoManager;
import manager.listener.colorButtonsActionListener;
import model.Setting;
import model.Thing;
import util.ResourceBundleUtil;

public class ModifyThingDialog extends JDialog {
	private static final long serialVersionUID = -5811564425597917454L;
	protected Thing thing = null;
	protected DateChooserJButton dateChooserJButton = null;
	protected JTextArea messageText = new JTextArea();
	protected JButton confirmButton = new JButton(ResourceBundleUtil.getString("confirmButton"));
	protected JButton cancelButton = new JButton(ResourceBundleUtil.getString("cancelButton"));
	protected JPanel southPanel = new JPanel(new GridLayout(1, 2));
	protected Setting setting = SettingManager.getManager().getSetting();
	protected JPanel colorPanel = null;

	public ModifyThingDialog(Thing thing) {
		this.thing = thing;
		initStyle();
		addComponents();
		addListeners();
		updateView();
	}

	protected void initStyle() {
		setTitle("ModifyThing");
		setLayout(new BorderLayout());
		setSize(400, 200);
		setLocation((setting.getScreenSize().width - getWidth()) / 2,
				(setting.getScreenSize().height - getHeight()) / 2);
		setIconImage(setting.getIcon());
		setModal(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}

	protected void addComponents() {
		dateChooserJButton = new DateChooserJButton(new SimpleDateFormat(
				setting.getDateFormat()), thing.getDate());
		add(dateChooserJButton, BorderLayout.NORTH);
		JPanel centerPanel = new JPanel(new BorderLayout());
		initColorPanel();
		centerPanel.add(colorPanel, BorderLayout.NORTH);
		centerPanel.add(messageText, BorderLayout.CENTER);
		add(centerPanel, BorderLayout.CENTER);
		this.southPanel.add(confirmButton);
		this.southPanel.add(cancelButton);
		add(southPanel, BorderLayout.SOUTH);
	}
	
	protected void initColorPanel() {
		JButton[] colorButtons = {new JButton("NOTDO"), new JButton("DELETE"), new JButton("DONE"), new JButton("DOING"), new JButton("TODO")};
		colorPanel = new JPanel(new GridLayout(1, colorButtons.length));
		for(int i=0; i<colorButtons.length; i++) {
			colorButtons[i].setForeground(Color.WHITE);
			colorButtons[i].setBackground(Thing.backgroundColors[i]);
			colorButtons[i].addActionListener(new colorButtonsActionListener(this, i));
			colorPanel.add(colorButtons[i]);
		}
	}

	public Thing getThing() {
		return thing;
	}

	protected void addListeners() {
		this.confirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				thing.setMessage(messageText.getText());
				thing.setMillis(dateChooserJButton.getDate().getTime());
				TodoManager.getTodoManager().saveTodo();
				ThingFrame.getThingFrame().updateView();
				setVisible(false);
				dispose();
			}
		});
		this.cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		this.messageText.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if(messageText.getText().trim().equals(""))
					messageText.setText(ResourceBundleUtil.getString("defaultThingMessage"));
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(messageText.getText().equals(ResourceBundleUtil.getString("defaultThingMessage")))
					messageText.setText("");
			}
		});
	}

	protected void updateView() {
		dateChooserJButton.setText(thing.getDate());
		dateChooserJButton.setBackground(
				Thing.backgroundColors[thing.getStatus()]);
		messageText.setText(thing.getMessage());
	}
	
	public void updateStatusColor() {
		dateChooserJButton.setBackground(
				Thing.backgroundColors[thing.getStatus()]);
	}
}
