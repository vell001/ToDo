package view;

import java.util.ArrayList;
import java.util.List;

import model.Thing;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.TodoManager;

public class ThingFrameTester {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
	}
	
	public static void main(String[] args) {
		List<Thing> thingList = TodoManager.getTodoManager().getTodo().getThings();
		thingList.add(new Thing("hello", 1234453464541L, 2));
		thingList.add(new Thing("hello", 1234453467541L, 2));
		thingList.add(new Thing("hello", 1234453468541L, 2));
		thingList.add(new Thing("hello", 1234453469541L, 2));
		thingList.add(new Thing("hello", 1234453465541L, 2));
		thingList.add(new Thing("hello", 1234453466541L, 2));
		TodoManager.getTodoManager().getTodo().sortThingList();
		TodoManager.getTodoManager().saveTodo();
		ThingFrame f = new ThingFrame(thingList);
		f.setVisible(true);
	}

}
