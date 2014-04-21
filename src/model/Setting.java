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
 * a setting entity save to xml
 */
@XmlRootElement(name="Setting")
public class Setting {
	public static Long getMillisFromMinute(int minute) {
		return 60000L * minute;
	}
	private int beforeSleepTime = 5; // time of notice to sleep, second
	private Long checkTime = 5000L;
	private String dateFormat = "yyyy-MM-dd HH:mm:ss";
	private Long noticeTime = 5000L;//Setting.getMillisFromMinute(5); // time of notice ToDo thing, minute
	private Dimension screenSize = null;
	private Long sleepTime = 10000L; // computer's sleep time, minute 
	private Font vfont = null;
	
	private Long workTime = Setting.getMillisFromMinute(0); // minute 
	public Setting() {
		initVFont();
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	}
	@XmlElement
	public int getBeforeSleepTime() {
		return beforeSleepTime;
	}
	@XmlElement
	public Long getCheckTime() {
		return checkTime;
	}
	@XmlElement
	public String getDateFormat() {
		return dateFormat;
	}
	@XmlElement
	public Long getNoticeTime() {
		return noticeTime;
	}
	public Dimension getScreenSize() {
		return screenSize;
	}
	@XmlElement
	public Long getSleepTime() {
		return sleepTime;
	}
	public Font getVfont() {
		return vfont;
	}
	@XmlElement
	public Long getWorkTime() {
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
	public void setBeforeSleepTime(int beforeSleepTime) {
		this.beforeSleepTime = beforeSleepTime;
	}
	public void setCheckTime(Long checkTime) {
		this.checkTime = checkTime;
	}
	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}
	public void setNoticeTime(Long noticeTime) {
		this.noticeTime = noticeTime;
	}
	public void setSleepTime(Long sleepTime) {
		this.sleepTime = sleepTime;
	}
	public void setWorkTime(Long workTime) {
		this.workTime = workTime;
	}
}
