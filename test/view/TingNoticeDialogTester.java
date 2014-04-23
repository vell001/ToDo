package view;

import model.Thing;

public class TingNoticeDialogTester {
	public void test() {
		Thing thing = new Thing("hello", 3242342434134L, 2);
		ThingNoticeDialog TND = new ThingNoticeDialog(thing);
		TND.setVisible(true);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		TND.setVisible(false);
	}
	
	public static void main(String[] args) {
		TingNoticeDialogTester t = new TingNoticeDialogTester();
		t.test();
	}
}
