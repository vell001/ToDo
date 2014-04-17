package controller;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.InputStream;

import model.Setting;

/**
 * @author VellBibi
 * All Setting information come from here
 */
public class SettingManager {
	private static SettingManager setting = null;
	private Dimension screenSize = null;
	private Setting DBS = null;
	private Font vfont = null;
	
	// SettingManager is a singleton
	static {
		setting = new SettingManager();
		setting.setScreenSize(Toolkit.getDefaultToolkit().getScreenSize());
		setting.initVFont();
	}
	// default font
	public void initVFont() {
		InputStream in = SettingManager.class.getResourceAsStream("/font/vfont.TTF"); 
		Font font = null;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, in);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		vfont = font.deriveFont(Font.PLAIN,24);
//		vfont = new Font(null, Font.PLAIN, 24);
	}
	
	public static SettingManager getManager() {
		return setting;
	}
	
	public Dimension getScreenSize() {
		return screenSize;
	}
	public void setScreenSize(Dimension screenSize) {
		this.screenSize = screenSize;
	}
	public int getBeforeSleepTime () {
		return DBS.getBeforeSleepTime();
	}
	
	public Setting getDBSetting() {
		if(DBS == null){
			DBS = getSetting();
		}
		return DBS;
	}
	
	/**
	 * @return DBSetting 
	 * get a new object from database
	 */
	public Setting getSetting() {
		return null;
	}
	
	/**
	 * @return DBSetting
	 * initialize a DBSetting and save to database
	 */
	private Setting initSetting() {
		return null;
	}
	
	/**
	 * @param dbs
	 * saveOrUpdate dbs to database
	 */
	public void saveSetting(Setting setting) {
		
	}

	public Font getVfont() {
		return vfont;
	}
}
