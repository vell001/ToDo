package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import manager.SettingManager;
import model.Setting;
import util.ResourceBundleUtil;

public class SettingDialog extends JDialog {
	private static final long serialVersionUID = 8376100275979503453L;
	private Setting setting = SettingManager.getManager().getSetting();
	private List<JLabel> settingTimeLabelList = new ArrayList<JLabel>();
	private List<JLabel> settingTimeUnitLabelList = new ArrayList<JLabel>();
	private List<JTextField> settingTimeFieldList = new ArrayList<JTextField>();
	private List<JPanel> settingTimePanelList = new ArrayList<JPanel>();
	protected JButton confirmButton = new JButton(ResourceBundleUtil.getString("confirmButton"));
	protected JButton cancelButton = new JButton(ResourceBundleUtil.getString("cancelButton"));
	protected JPanel southPanel = new JPanel(new GridLayout(1, 2));
	
	private JPanel settingPanel = null;
	
	public SettingDialog() {
		initStyle();
		addComponents();
		addListeners();
	}
	private void initStyle() {
		setTitle("Setting");
		setLayout(new BorderLayout());
		setSize(400, 200);
		setLocation((setting.getScreenSize().width - getWidth()) / 2,
				(setting.getScreenSize().height - getHeight()) / 2);
		setIconImage(setting.getIcon());
		setModal(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	
	private void addComponents() {
		initSettingTimePanelList();
		settingPanel = new JPanel(new GridLayout(settingTimePanelList.size(), 1));
		
		for(int i=0; i<settingTimePanelList.size(); i++) {
			settingPanel.add(settingTimePanelList.get(i));
		}
		
		this.add(settingPanel);
		
		this.southPanel.add(confirmButton);
		this.southPanel.add(cancelButton);
		add(southPanel, BorderLayout.SOUTH);
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
				saveSetting();
				setVisible(false);
				dispose();
			}
		});
	}
	
	private void initSettingTimePanelList() {
		// beforeSleepTime s
		settingTimeLabelList.add(new JLabel(ResourceBundleUtil.getString("beforeSleepTimeLabel")));
		settingTimeFieldList.add(new JTextField(String.valueOf(setting.getBeforeSleepTime())));
		settingTimeUnitLabelList.add(new JLabel("s"));
		// checkTime ms
		settingTimeLabelList.add(new JLabel(ResourceBundleUtil.getString("checkTimeLabel")));
		settingTimeFieldList.add(new JTextField(String.valueOf(setting.getCheckTime())));
		settingTimeUnitLabelList.add(new JLabel("ms"));
		// delayTime m
		settingTimeLabelList.add(new JLabel(ResourceBundleUtil.getString("delayTimeLabel")));
		settingTimeFieldList.add(new JTextField(String.valueOf(Setting.getMinuteFromMillis(setting.getDelayTime()))));
		settingTimeUnitLabelList.add(new JLabel("m"));
		// noticeTime m
		settingTimeLabelList.add(new JLabel(ResourceBundleUtil.getString("noticeTimeLabel")));
		settingTimeFieldList.add(new JTextField(String.valueOf(Setting.getMinuteFromMillis(setting.getNoticeTime()))));
		settingTimeUnitLabelList.add(new JLabel("m"));
		// sleepTime m
		settingTimeLabelList.add(new JLabel(ResourceBundleUtil.getString("sleepTimeLabel")));
		settingTimeFieldList.add(new JTextField(String.valueOf(Setting.getMinuteFromMillis(setting.getSleepTime()))));
		settingTimeUnitLabelList.add(new JLabel("m"));
		// workTime m
		settingTimeLabelList.add(new JLabel(ResourceBundleUtil.getString("workTimeLabel")));
		settingTimeFieldList.add(new JTextField(String.valueOf(Setting.getMinuteFromMillis(setting.getWorkTime()))));
		settingTimeUnitLabelList.add(new JLabel("m"));
		
		JPanel mainPanel = null;
		JPanel secondPanel = null;
		for(int i=0; i<settingTimeLabelList.size(); i++) {
			mainPanel = new JPanel(new GridLayout(1,2));
			secondPanel = new JPanel(new BorderLayout());
			mainPanel.add(settingTimeLabelList.get(i));
			secondPanel.add(settingTimeFieldList.get(i), BorderLayout.CENTER);
			secondPanel.add(settingTimeUnitLabelList.get(i), BorderLayout.EAST);
			mainPanel.add(secondPanel);
			settingTimePanelList.add(mainPanel);
		}
	}
	
	private void saveSetting() {
		JTextField field = null;
		Iterator<JTextField> it = settingTimeFieldList.iterator();
		try {
			// beforeSleepTime s
			if(it.hasNext()) field = it.next();
			setting.setBeforeSleepTime(Integer.parseInt(field.getText()));
			// checkTime ms
			if(it.hasNext()) field = it.next();
			setting.setCheckTime(Long.parseLong(field.getText()));
			// delayTime m
			if(it.hasNext()) field = it.next();
			setting.setDelayTime(Setting.getMillisFromMinute(Integer.parseInt(field.getText())));
			// noticeTime m
			if(it.hasNext()) field = it.next();
			setting.setNoticeTime(Setting.getMillisFromMinute(Integer.parseInt(field.getText())));
			// sleepTime m
			if(it.hasNext()) field = it.next();
			setting.setSleepTime(Setting.getMillisFromMinute(Integer.parseInt(field.getText())));
			// workTime m
			if(it.hasNext()) field = it.next();
			setting.setWorkTime(Setting.getMillisFromMinute(Integer.parseInt(field.getText())));
		} catch (Exception e) {
			return;
		}
		
		SettingManager.getManager().saveSetting();
	}
}
