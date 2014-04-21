package model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ToDo")
public class Todo {
	private List<Thing> things;
	
	public Todo() {}
	
	public Todo(List<Thing> things) {
		this.things = things;
	}
	
	@XmlElement
	public List<Thing> getThings() {
		return things;
	}
	
	/**
	 * sort thinglist by date
	 * quicksort
	 */
	public void sortThingList() {
		quickSort(things, 0, things.size() - 1);
	}
	
	public void quickSort(List<Thing> things, int low, int high) {
		if(low >= high) return;
		int mid = partition(things, low, high);
		quickSort(things, low, mid - 1);
		quickSort(things, mid + 1, high);
	}
	
	public int partition(List<Thing> things, int low, int high) {
		if(low >= high) return low;
		Thing key = things.get(low);
		while(high > low) {
			while(high > low && things.get(high).getMillis() > key.getMillis()) high --;
			things.set(low, things.get(high));
			while(high > low && things.get(low).getMillis() < key.getMillis()) low ++;
			things.set(high, things.get(low));
		}
		things.set(low, key);
		return low;
	}
}
