package model;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.InputStream;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import controller.SettingManager;


/**
 * @author VellBibi
 * a setting entity save to database
 */
@XmlRootElement(name="Setting")
public class Setting {
	private int beforeNoticeTime; // minute
	private int beforeSleepTime; // time of notice to sleep, second
	private int noticeTime; // time of notice ToDo thing, minute
	private Dimension screenSize = null;
	private int sleepTime; // computer's sleep time, minute 
	private Font vfont = null;
	private int workTime;
	
	public Setting() {
		initVFont();
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	}
	
	@XmlElement
	public int getBeforeNoticeTime() {
		return beforeNoticeTime;
	}
	@XmlElement
	public int getBeforeSleepTime() {
		return beforeSleepTime;
	}
	@XmlElement
	public int getNoticeTime() {
		return noticeTime;
	}
	public Dimension getScreenSize() {
		return screenSize;
	}
	@XmlElement
	public int getSleepTime() {
		return sleepTime;
	}
	public Font getVfont() {
		return vfont;
	}
	@XmlElement
	public int getWorkTime() {
		return workTime;
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
	}
	public void setBeforeNoticeTime(int beforeNoticeTime) {
		this.beforeNoticeTime = beforeNoticeTime;
	}
	public void setBeforeSleepTime(int beforeSleepTime) {
		this.beforeSleepTime = beforeSleepTime;
	}
	public void setNoticeTime(int noticeTime) {
		this.noticeTime = noticeTime;
	}
	public void setSleepTime(int sleepTime) {
		this.sleepTime = sleepTime;
	}
	public void setWorkTime(int workTime) {
		this.workTime = workTime;
	}
}
