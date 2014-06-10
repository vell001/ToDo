package view;

public class SleepFrameTest {
	public static void main(String[] args) throws InterruptedException {
		SleepFrame sleepFrame = new SleepFrame();
		sleepFrame.setVisible(true);
		Thread.sleep(3000);
		sleepFrame.setVisible(false);
	}
}
