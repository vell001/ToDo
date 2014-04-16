package controller;

import java.util.Iterator;
import java.util.List;

import model.Thing;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ThingManagerTester {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testSaveThing() {
		Thing thing = new Thing();
		thing.setMessage("helloworld");
		thing.setId(1);
		thing.setStatus(1);
		thing.setTimeMillis(System.currentTimeMillis());
		ThingManager.getThingManager().saveThing(thing);
	}
	
	@Test
	public void testGetThings() {
		List<Thing> things = ThingManager.getThingManager().getToDoThings();
		if(things != null) {
			Iterator<Thing> it = things.iterator();
		
			while(it.hasNext()){
				Thing t = it.next();
				System.out.print(t.getMessage() + " : ");
				System.out.println(t.getTimeMillis());
			}
		}
	}
}
