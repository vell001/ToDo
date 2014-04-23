package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Todo {
	private ThingList things = new ThingList();
	
	@XmlElementWrapper(name="things")
    @XmlElement(name="thing")
	public ThingList getThings() {
		return things;
	}
	
	public void setThings(ThingList things) {
		this.things = things;
	}
}
