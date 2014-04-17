package controller;

import java.util.ArrayList;

import model.Thing;
import model.Todo;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TodoManagerTester {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testSaveThing() {
		Thing thing = new Thing();
		thing.setMessage("helloworld");
		thing.setStatus(1);
		thing.setName("tester");
		Todo todo = new Todo();
		todo.setThings(new ArrayList<Thing>());
		todo.getThings().add(thing);
		TodoManager.getTodoManager().saveTodo(todo);
	}
	
	public static void main(String[] args) {
		Thing thing = new Thing();
		thing.setMessage("helloworld");
		thing.setStatus(1);
		thing.setName("tester");
		Todo todo = new Todo();
		todo.setThings(new ArrayList<Thing>());
		todo.getThings().add(thing);
		TodoManager.getTodoManager().saveTodo(todo);
	}
	
}
