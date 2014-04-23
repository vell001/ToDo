package controller;

import java.util.List;

import model.Thing;
import model.Todo;
import threads.TimeRunable;
import view.ThingFrame;

public class TimeTester {
	public static void main(String[] args) {
		Todo todo = TodoManager.getTodoManager().getTodo();
		if(todo == null) {System.out.println("null"); return;}
		List<Thing> things = todo.getThings();
		things.add(new Thing("hello5", System.currentTimeMillis()+5000, Thing.TODO));
		things.add(new Thing("hello2", System.currentTimeMillis()+2000, Thing.TODO));
		things.add(new Thing("hello1", System.currentTimeMillis()+1000, Thing.TODO));
		ThingFrame f = ThingFrame.getThingFrame();
		f.setVisible(true);
		new Thread(new TimeRunable()).start();
	}
}
