package view;

import java.awt.Color;
import java.awt.Frame;

import model.Thing;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ThingPanelTester {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
	}
	
	public static void main(String[] args) throws InterruptedException {
		Frame f = new Frame();
		Thing thing = new Thing();
		thing.setMessage("hehe");
		thing.setStatus(2);
		ThingPanel tp = new ThingPanel(thing);
		f.add(tp);
		f.pack();
		f.setVisible(true);
		
		Thread.sleep(3000);
		thing.setStatus(0);
		thing.setMessage("haha");
		tp.updateView();
	}

}
