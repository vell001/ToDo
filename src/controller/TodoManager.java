package controller;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import model.Thing;
import model.Todo;
import util.JAXBUtil;

/**
 * @author VellBibi
 */
public class TodoManager {
	private static TodoManager todoManager = null;
	private File xmlFile = null;
	private Todo todo = null;
	
	static {
		todoManager = new TodoManager();
	}
	
	public TodoManager() {
		this.xmlFile = new File(TodoManager.class.getResource("/todo.xml").getPath());
		this.todo = readTodo();
	}

	public static TodoManager getTodoManager() {
		return todoManager;
	}
	
	public void updateTodo() {
		todo = readTodo();
	}
	
	public void saveTodo(Todo todo) {
		try {
			JAXBUtil.save(todo, Todo.class, xmlFile);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public Todo initTodo() {
		Todo todo = new Todo();
		todo.setThings(new ArrayList<Thing>());
		try {
			JAXBUtil.save(todo, Todo.class, xmlFile);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return todo;
	}

	public File getXmlFile() {
		return xmlFile;
	}

	public Todo getTodo() {
		return todo;
	}
	
	private Todo readTodo() {
		Todo todo = null;
		try {
			todo = (Todo) JAXBUtil.read(xmlFile, Todo.class);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return todo;
	}
}
