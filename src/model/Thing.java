package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Thing {
	private int id;
	private String message;
	private Long timeMillis;
	private String systemMessage;
	private int status;
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public String getMessage() {
		return message;
	}
	public String getSystemMessage() {
		return systemMessage;
	}
	public int getStatus() {
		return status;
	}
	public void setId(int id) {
		this.id = id;
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
	public Long getTimeMillis() {
		return timeMillis;
	}
	public void setTimeMillis(Long timeMillis) {
		this.timeMillis = timeMillis;
	}
}
