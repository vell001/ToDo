package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DBSetting {
	private int id;
	private int beforeSleepTime;
	private int sleepTime;
	private int noticeTime;
	private int status;

	@Id
	public int getId() {
		return id;
	}
	public int getStatus() {
		return status;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getBeforeSleepTime() {
		return beforeSleepTime;
	}
	public int getSleepTime() {
		return sleepTime;
	}
	public int getNoticeTime() {
		return noticeTime;
	}
	public void setBeforeSleepTime(int beforeSleepTime) {
		this.beforeSleepTime = beforeSleepTime;
	}
	public void setSleepTime(int sleepTime) {
		this.sleepTime = sleepTime;
	}
	public void setNoticeTime(int noticeTime) {
		this.noticeTime = noticeTime;
	}
}
