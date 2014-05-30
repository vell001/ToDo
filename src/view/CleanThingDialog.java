package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import model.Setting;
import model.Thing;
import model.Todo;
import util.ResourceBundleUtil;
import controller.SettingManager;
import controller.TodoManager;

public class CleanThingDialog extends JDialog {
	private static final long serialVersionUID = 7336810745860478278L;
	private Todo todo = TodoManager.getTodoManager().getTodo();
	private Setting setting = SettingManager.getManager().getSetting();
	private char[] toCleanStatusChars = setting.getToCleanStatuses().toCharArray();
	private JLabel noticeText = null;
	private JPanel checkBoxPanel = null;
	JCheckBox[] checkBoxs = {new JCheckBox("NOTDO"), new JCheckBox("DELETE"), new JCheckBox("DONE"), new JCheckBox("DOING"), new JCheckBox("TODO")};
	protected JButton confirmButton = new JButton(ResourceBundleUtil.getString("confirmButton"));
	protected JButton cancelButton = new JButton(ResourceBundleUtil.getString("cancelButton"));
	protected JPanel southPanel = new JPanel(new GridLayout(1, 2));
	
	public CleanThingDialog() {
		initStyle();
		addComponents();
		addListeners();
	}
	
	private void initStyle() {
		setTitle("CleanThing");
		setLayout(new BorderLayout());
		setSize(400, 160);
		setLocation((setting.getScreenSize().width - getWidth()) / 2,
				(setting.getScreenSize().height - getHeight()) / 2);
		setIconImage(setting.getIcon());
		setModal(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	
	private void addComponents() {
		noticeText = new JLabel(ResourceBundleUtil.getString("cleanThingDialogNoticeText"), JLabel.CENTER);
		this.add(noticeText, BorderLayout.NORTH);
		
		initCheckBoxPanel();
		this.add(checkBoxPanel, BorderLayout.CENTER);
		
		this.southPanel.add(confirmButton);
		this.southPanel.add(cancelButton);
		add(southPanel, BorderLayout.SOUTH);
	}
	
	private void initCheckBoxPanel() {
		checkBoxPanel = new JPanel(new GridLayout(1, checkBoxs.length));
		for(int i=0; i<checkBoxs.length; i++) {
			checkBoxs[i].setForeground(Color.WHITE);
			checkBoxs[i].setBackground(Thing.backgroundColors[i]);
			checkBoxPanel.add(checkBoxs[i]);
			checkBoxs[i].setSelected(toCleanStatusChars[i] == '1' ? true : false);
		}
	}

	private void addListeners() {
		this.cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		
		this.confirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cleanThings();
				updateCleanSetting();
				setVisible(false);
				dispose();
			}
		});
	}
	
	private void cleanThings() {
		List<Thing> thingList = todo.getThings();
		List<Thing> toCleanThings = new ArrayList<Thing>();
		if(thingList.isEmpty()) return;
		for(Thing thing : thingList) {
			if(checkBoxs[thing.getStatus()].isSelected()) {
				toCleanThings.add(thing);
			}
		}
		
		for(Thing thing : toCleanThings) {
			thingList.remove(thing);
		}
		
		TodoManager.getTodoManager().saveTodo();
		ThingFrame.getThingFrame().updateView();
	}
	
	private void updateCleanSetting() {
		for(int i=0; i<checkBoxs.length; i++) {
			if(checkBoxs[i].isSelected()) {
				toCleanStatusChars[i] = '1';
			} else {
				toCleanStatusChars[i] = '0';
			}
		}
		setting.setToCleanStatuses(String.valueOf(toCleanStatusChars));
		SettingManager.getManager().saveSetting();
	}
}
