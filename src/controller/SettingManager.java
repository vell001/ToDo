package controller;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBException;

import model.Setting;
import util.JAXBUtil;

/**
 * @author VellBibi
 * All Setting information come from here
 */
public class SettingManager {
	private static final SettingManager settingManager = new SettingManager();
	// SettingManager is a singleton
	
	public static SettingManager getManager() {
		return settingManager;
	}
	
	private Setting setting = null;
	
	private File settingFile = null;
	
	private SettingManager() {
		this.settingFile = new File(SettingManager.class.getResource("/").getPath()+"setting.xml");
		if(!this.settingFile.exists()) {
			try {
				this.settingFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			initSetting();
		}
		this.setting = readSetting();
	}
	
	private void initSetting() {
		this.setting = new Setting();
		saveSetting();
	}
	
	public void saveSetting() {
		try {
			JAXBUtil.save(this.setting, Setting.class, this.settingFile);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public Setting getSetting() {
		return setting;
	}

	public File getSettingFile() {
		return settingFile;
	}

	private Setting readSetting() {
		Setting setting = null;
		try {
			setting = (Setting) JAXBUtil.read(settingFile, Setting.class);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return setting;
	}

	public void setSetting(Setting setting) {
		this.setting = setting;
	}

	public void setSettingFile(File settingFile) {
		this.settingFile = settingFile;
	}
	
	public void updateSetting() {
		this.setting = readSetting();
	}
}
