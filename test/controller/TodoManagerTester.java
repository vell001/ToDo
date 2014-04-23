package controller;

import model.Thing;

public class TodoManagerTester {
	
	public static void main(String[] args) {
		Thing thing = new Thing();
		thing.setMessage("helloworld001");
		thing.setStatus(1);
		thing.setName("tester");
		TodoManager.getTodoManager().getTodo().getThings().add(thing);
		TodoManager.getTodoManager().saveTodo();
		System.out.println(TodoManager.getTodoManager().getTodo().getThings().get(0).getMessage());
	}
}
