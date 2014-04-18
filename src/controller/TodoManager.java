package controller;

import java.io.File;
import java.io.IOException;
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
	static {
		todoManager = new TodoManager();
	}
	public static TodoManager getTodoManager() {
		return todoManager;
	}
	
	private Todo todo = null;
	
	private File xmlFile = null;

	public TodoManager() {
		this.xmlFile = new File(TodoManager.class.getResource("/").getPath()+"todo.xml");
		if(!this.xmlFile.exists()) {
			try {
				this.xmlFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			initTodo();
		}
		this.todo = readTodo();
	}
	
	public Todo getTodo() {
		return todo;
	}
	
	public File getXmlFile() {
		return xmlFile;
	}
	
	private void initTodo() {
		this.todo = new Todo();
		this.todo.setThings(new ArrayList<Thing>());
		saveTodo();
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

	public void saveTodo() {
		try {
			JAXBUtil.save(this.todo, Todo.class, xmlFile);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public void setTodo(Todo todo) {
		this.todo = todo;
	}

	/**
	 * update ToDo from xml
	 */
	public void updateTodo() {
		todo = readTodo();
	}
}
