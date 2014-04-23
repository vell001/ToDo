package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import model.Setting;
import model.Thing;
import model.Todo;
import util.JAXBUtil;

/**
 * @author VellBibi
 */
public class TodoManager {
	private static TodoManager todoManager = new TodoManager();;

	public static TodoManager getTodoManager() {
		return todoManager;
	}

	private Todo todo = null;

	private File xmlFile = null;

	private TodoManager() {
		this.xmlFile = new File(TodoManager.class.getResource("/").getPath()
				+ "todo.xml");
		if (!this.xmlFile.exists()) {
			try {
				this.xmlFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			initTodo();
		}
		this.todo = readTodo();
		if (this.todo.getThings() == null)
			initTodo();
	}

	public Todo getTodo() {
		return todo;
	}

	public File getXmlFile() {
		return xmlFile;
	}

	private void initTodo() {
		this.todo = new Todo();
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
	public void updateTodoFromXml() {
		todo = readTodo();
	}

	/**
	 * update thing's status with current time
	 */
	public List<Integer> updateTodoStatus() {
		Setting setting = SettingManager.getManager().getSetting();
		List<Thing> things = todo.getThings();
		Long nowTime = System.currentTimeMillis();
		Thing thing = null;
		double intervalTime = 0;
		double noticeTime = setting.getNoticeTime().doubleValue();
		List<Integer> noticeThingIndexs = new ArrayList<Integer>();
		for (int i = 0; i < things.size(); i++) {
			thing = things.get(i);
			intervalTime = nowTime - thing.getMillis();
			if (thing.getStatus() == Thing.TODO) {
				if (intervalTime >= 0) {
					thing.setStatus(Thing.DOING);
					noticeThingIndexs.add(i);
				}
			} else if (thing.getStatus() == Thing.DOING) {
				if(intervalTime > noticeTime) {
					thing.setStatus(Thing.NOTDO);
				} else if (intervalTime < 0) {
					thing.setStatus(Thing.TODO);
				}
			} /*else if (thing.getStatus() == Thing.DONE) {
			} else if (thing.getStatus() == Thing.DELETE) {
			} else if (thing.getStatus() == Thing.NOTDO) {
			}*/
		}
		return noticeThingIndexs;
	}
}
