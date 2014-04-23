package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ThingList implements List<Thing> {
	
	private ArrayList<Thing> thingList = new ArrayList<Thing>();
	
	public ThingList() {}
	/**
	 * sort thinglist by date
	 * quicksort
	 */
	public void sortThingList() {
		quickSort(thingList, 0, thingList.size() - 1);
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
			while(high > low && things.get(high).getMillis() >= key.getMillis()) high --;
			things.set(low, things.get(high));
			while(high > low && things.get(low).getMillis() <= key.getMillis()) low ++;
			things.set(high, things.get(low));
		}
		things.set(low, key);
		return low;
	}

	@Override
	public int size() {
		return thingList.size();
	}

	@Override
	public boolean isEmpty() {
		return thingList.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return thingList.contains(o);
	}

	@Override
	public Iterator<Thing> iterator() {
		return thingList.iterator();
	}

	@Override
	public Object[] toArray() {
		return thingList.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return thingList.toArray(a);
	}

	@Override
	public boolean add(Thing e) {
		boolean flag = thingList.add(e);
		sortThingList();
		return flag;
	}

	@Override
	public boolean remove(Object o) {
		return thingList.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return thingList.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends Thing> c) {
		boolean flag = thingList.addAll(c);
		sortThingList();
		return flag;
	}

	@Override
	public boolean addAll(int index, Collection<? extends Thing> c) {
		boolean flag = thingList.addAll(index, c);
		sortThingList();
		return flag;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return thingList.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return thingList.retainAll(c);
	}

	@Override
	public void clear() {
		thingList.clear();
	}

	@Override
	public Thing get(int index) {
		return thingList.get(index);
	}

	@Override
	public Thing set(int index, Thing element) {
		Thing thing = thingList.set(index, element);
		sortThingList();
		return thing;
	}

	@Override
	public void add(int index, Thing element) {
		thingList.add(index, element);
		sortThingList();
	}

	@Override
	public Thing remove(int index) {
		return thingList.remove(index);
	}

	@Override
	public int indexOf(Object o) {
		return thingList.indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o) {
		return thingList.lastIndexOf(o);
	}

	@Override
	public ListIterator<Thing> listIterator() {
		return thingList.listIterator();
	}

	@Override
	public ListIterator<Thing> listIterator(int index) {
		return thingList.listIterator(index);
	}

	@Override
	public List<Thing> subList(int fromIndex, int toIndex) {
		return thingList.subList(fromIndex, toIndex);
	}
}
