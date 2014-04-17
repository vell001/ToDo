package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.UIManager;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.SettingManager;

public class TingNoticeDialogTester {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		Frame f = new Frame();
		ThingNoticeDialog TND = new ThingNoticeDialog(f);
		TND.getMesLabel().setText("test mes 信息");
		TND.getTimeLabel().setText(ResourceBundle.getBundle("string", Locale.CHINA).getString("welcome"));
		TND.setVisible(true);
	}
	
	public static void main(String[] args) {
		TingNoticeDialogTester t = new TingNoticeDialogTester();
		t.test();
	}
}
