package model;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import controller.SettingManager;

public class Thing {
	private String name;
	private String message;
	private String date;
	private Long millis;
	private String systemMessage;
	@XmlElement
	public Long getMillis() {
		return millis;
	}
	public void setMillis(Long millis) {
		this.millis = millis;
		updateDate();
	}
	private int status; // -1:delete 0:done 1:doing 2:to do
	public static int NOTDO = -2;
	public static int DELETE = -1;
	public static int DONE = 0;
	public static int DOING= 1;
	public static int TODO = 2;
	/**
	 * Correspond with status
	 */
	public static Color[] backgroundColors = {Color.BLACK, Color.GRAY, Color.GREEN, Color.RED, Color.BLUE};
	public Thing(){}
	public Thing(String message, Long millis, int status) {
		setMessage(message);
		setMillis(millis);
		setStatus(status);
	}
	@XmlElement
	public String getMessage() {
		return message;
	}
	@XmlElement
	public String getSystemMessage() {
		return systemMessage;
	}
	@XmlAttribute
	public int getStatus() {
		return status;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setSystemMessage(String systemMessage) {
		this.systemMessage = systemMessage;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@XmlAttribute
	public String getDate() {
		return date;
	}
	@XmlAttribute
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void updateDate() {
		Date d = new Date(this.millis);
		SimpleDateFormat dateFormat = new SimpleDateFormat(SettingManager.getManager().getSetting().getDateFormat());
		this.date = dateFormat.format(d);
	}
}
