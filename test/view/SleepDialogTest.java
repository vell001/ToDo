package view;


public class SleepDialogTest {
	public static void main(String[] args) {
//		Thing thing = new Thing("hello", System.currentTimeMillis(), Thing.TODO);
		SleepDialog sleepDialog = new SleepDialog();
		sleepDialog.setTime("1s");
		sleepDialog.setVisible(true);
	}
}
