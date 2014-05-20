package view;

import model.Thing;

public class ThingNoticeDialogTest {
	public static void main(String[] args) {
		Thing thing = new Thing("hello", System.currentTimeMillis(), Thing.TODO);
		ThingNoticeDialog noticeDialog = new ThingNoticeDialog(thing);
		noticeDialog.setVisible(true);
	}
}
