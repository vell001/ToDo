package view;

import javax.swing.JFrame;

import model.Thing;

public class EditDialogTester {
	public static void main(String[] args) {
		JFrame f = new JFrame();
		EditThingDialog ed = new EditThingDialog(new Thing("hello", 1234413413413L, 2));
		
		ed.setVisible(true);
	}
}
