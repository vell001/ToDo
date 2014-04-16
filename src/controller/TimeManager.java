package controller;

public class TimeManager {
	private static TimeManager TimeManager = null;
	
	static {
		TimeManager = new TimeManager();
	}
	
	public static TimeManager getTimeManager() {
		return TimeManager;
	}
	
	public void start(){
		
	}
}
