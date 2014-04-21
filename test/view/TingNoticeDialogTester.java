package view;

import java.awt.Frame;

import model.Thing;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TingNoticeDialogTester {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		Thing thing = new Thing("hello", 3242342434134L, 2);
		ThingNoticeDialog TND = new ThingNoticeDialog( thing);
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
