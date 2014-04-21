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
		things.add(new Thing("hello", System.currentTimeMillis()+5000, 2));
		things.add(new Thing("hello", System.currentTimeMillis()+2000, 2));
		things.add(new Thing("hello", System.currentTimeMillis()+1000, 2));
		todo.sortThingList();
		ThingFrame f = new ThingFrame(things);
		f.setVisible(true);
		new Thread(new TimeRunable()).start();
	}
}
