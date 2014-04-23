package view;

import java.awt.Frame;

import model.Thing;

public class ThingPanelTester {
	
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
