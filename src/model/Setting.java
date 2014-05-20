package model;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.InputStream;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import util.ImageUtil;
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
	public static int getMinuteFromMillis(Long millis) {
		return (int) (millis / 60000L);
	}
	private int beforeSleepTime = 60; // time of notice to sleep, second
	private Long checkTime = 5000L;
	private String dateFormat = "yyyy-MM-dd HH:mm:ss";
	private Long delayTime = Setting.getMillisFromMinute(5);
	private Image icon = ImageUtil.getImage("/images/logo.png");
	private Long noticeTime = Setting.getMillisFromMinute(5); // time of notice ToDo thing, minute; // computer's sleep time, minute 
	private Dimension screenSize = null;
	private Long sleepTime = Setting.getMillisFromMinute(5);
	private String toCleanStatuses = null; // "00100"
	private Font vfont = null;
	private Long workTime = Setting.getMillisFromMinute(120); // minute 
	
	public Setting() {
		initVFont();
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		char[] toCleanStatusChars = new char[Thing.backgroundColors.length];
		for(int i=0; i<toCleanStatusChars.length; i++) {
			toCleanStatusChars[i] = '0';
		}
		toCleanStatuses = String.valueOf(toCleanStatusChars);
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
	public Long getDelayTime() {
		return delayTime;
	}
	public Image getIcon() {
		return icon;
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
	@XmlElement
	public String getToCleanStatuses() {
		return toCleanStatuses;
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
	public void setDelayTime(Long delayTime) {
		this.delayTime = delayTime;
	}
	public void setIcon(Image icon) {
		this.icon = icon;
	}
	public void setNoticeTime(Long noticeTime) {
		this.noticeTime = noticeTime;
	}
	public void setSleepTime(Long sleepTime) {
		this.sleepTime = sleepTime;
	}
	public void setToCleanStatuses(String toCleanStatuses) {
		this.toCleanStatuses = toCleanStatuses;
	}
	public void setWorkTime(Long workTime) {
		this.workTime = workTime;
	}
}
