package model;

import java.io.File;

import javax.xml.bind.JAXBException;

import util.JAXBUtil;

public class JAXBTester {
	public static void main(String[] args) throws JAXBException {
		//JAXBUtil.save(new Todo(), Todo.class, new File("D:/Dropbox/java_workspace/ToDo_XML001/bin/todo.xml"));
		/*Todo todo = (Todo)JAXBUtil.read(new File("D:/Dropbox/java_workspace/ToDo_XML001/bin/todo.xml"), Todo.class);
		todo.getThings().add(new Thing("hello", System.currentTimeMillis(), 2));
		System.out.println(todo.getThings().get(0).getMessage());*/
		
		LongTest longTest = new LongTest();
		longTest.getLonglist().add(4L);
		longTest.getLonglist().add(5L);
		JAXBUtil.save(longTest, LongTest.class, new File("d:/longtest.xml"));
		
		LongTest longTest2 = (LongTest) JAXBUtil.read(new File("d:/longtest.xml"), LongTest.class);
		System.out.println(longTest2.getLonglist().get(1));
	}
}
