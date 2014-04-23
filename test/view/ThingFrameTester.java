package view;


public class ThingFrameTester {
	
	public static void main(String[] args) {
		/*List<Thing> thingList = TodoManager.getTodoManager().getTodo().getThings();
		thingList.add(new Thing("hello", 1234453464530L, 2));
		thingList.add(new Thing("hello", 1234453467541L, 2));
		thingList.add(new Thing("hello", 1234453468541L, 2));
		thingList.add(new Thing("hello", 1234453469541L, 2));
		thingList.add(new Thing("hello", 1234453465541L, 2));
		thingList.add(new Thing("hello", 1234453466541L, 2));
		TodoManager.getTodoManager().saveTodo();*/
		ThingFrame f = ThingFrame.getThingFrame();
		f.setVisible(true);
	}

}
