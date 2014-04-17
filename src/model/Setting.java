package model;


/**
 * @author VellBibi
 * a setting entity save to database
 */
public class Setting {
	private int id;
	private int beforeSleepTime; // time of notice to sleep, second
	private int sleepTime; // computer's sleep time, minute
	private int beforeNoticeTime; // minute
	private int noticeTime; // time of notice ToDo thing, minute
	private int workTime; 
	private int status; 

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
	public int getBeforeNoticeTime() {
		return beforeNoticeTime;
	}
	public void setBeforeNoticeTime(int beforeNoticeTime) {
		this.beforeNoticeTime = beforeNoticeTime;
	}
	public int getWorkTime() {
		return workTime;
	}
	public void setWorkTime(int workTime) {
		this.workTime = workTime;
	}
}
