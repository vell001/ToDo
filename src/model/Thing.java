package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Thing {
	private String name;
	private String message;
	private String date;
	private String systemMessage;
	private int status;
	
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
	public void setDate(String date) {
		this.date = date;
	}
	@XmlAttribute
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
