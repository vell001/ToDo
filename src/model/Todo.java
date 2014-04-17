package model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ToDo")
public class Todo {
	private ArrayList<Thing> things;
	
	@XmlElement
	public ArrayList<Thing> getThings() {
		return things;
	}

	public void setThings(ArrayList<Thing> things) {
		this.things = things;
	}
}
