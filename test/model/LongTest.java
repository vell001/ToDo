package model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LongTest {
	private List<Long> longlist = new ArrayList<Long>();
	@XmlElementWrapper(name="longs")
	@XmlElement(name="long")
	public List<Long> getLonglist() {
		return longlist;
	}
	public void setLonglist(List<Long> longlist) {
		this.longlist = longlist;
	}
}
