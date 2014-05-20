package model;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import controller.SettingManager;

public class Thing {
	/**
	 * Correspond with status
	 */
	public static Color[] backgroundColors = {Color.BLACK, Color.GRAY, Color.GREEN, Color.RED, Color.BLUE};
	public static int DELETE = 1;
	public static int DOING= 3;
	public static int DONE = 2;
	public static int NOTDO = 0;
	public static int TODO = 4;
	private String date;
	private String message;
	private Long millis; // date's millis
	private String name;
	private int status; 
	private String systemMessage;
	public Thing(){}
	public Thing(String message, Long millis, int status) {
		setMessage(message);
		setMillis(millis);
		setStatus(status);
	}
	@XmlAttribute
	public String getDate() {
		return date;
	}
	@XmlElement
	public String getMessage() {
		return message;
	}
	@XmlElement
	public Long getMillis() {
		return millis;
	}
	@XmlAttribute
	public String getName() {
		return name;
	}
	@XmlAttribute
	public int getStatus() {
		return status;
	}
	@XmlElement
	public String getSystemMessage() {
		return systemMessage;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setMillis(Long millis) {
		this.millis = millis;
		updateDate();
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setSystemMessage(String systemMessage) {
		this.systemMessage = systemMessage;
	}
	public void updateDate() {
		Date d = new Date(this.millis);
		SimpleDateFormat dateFormat = new SimpleDateFormat(SettingManager.getManager().getSetting().getDateFormat());
		this.date = dateFormat.format(d);
	}
}
