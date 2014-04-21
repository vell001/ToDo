package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.Setting;
import model.Thing;
import controller.SettingManager;

public class EditThingDialog extends JDialog {
	private static final long serialVersionUID = -5811564425597917454L;
	private Thing thing = null;
	private DateChooserJButton dateChooserJButton = null;
	private JTextArea messageText = new JTextArea();
	private JButton confirmButton = new JButton("Confirm");
	private JButton cancelButton = new JButton("Cancel");
	private JPanel southPanel = new JPanel(new GridLayout(1, 2));
	private Setting setting = SettingManager.getManager().getSetting();

	public EditThingDialog(Thing thing) {
		this.thing = thing;
		initStyle();
		addComponents();
		addListeners();
		updateView();
	}

	private void initStyle() {
		setTitle("EditThing");
		setLayout(new BorderLayout());
		setSize(400, 200);
		setLocation((setting.getScreenSize().width - getWidth()) / 2,
				(setting.getScreenSize().height - getHeight()) / 2);
	}

	private void addComponents() {
		dateChooserJButton = new DateChooserJButton(new SimpleDateFormat(
				setting.getDateFormat()), thing.getDate());
		add(dateChooserJButton, BorderLayout.NORTH);
		add(messageText, BorderLayout.CENTER);
		this.southPanel.add(confirmButton);
		this.southPanel.add(cancelButton);
		add(southPanel, BorderLayout.SOUTH);
	}

	private void addListeners() {
		
	}

	private void updateView() {
		dateChooserJButton.setText(thing.getDate());
		dateChooserJButton.setBackground(thing.backgroundColors[thing
				.getStatus()]);
		messageText.setText(thing.getMessage());
	}
}
