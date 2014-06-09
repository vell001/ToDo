package manager.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.InsertThingDialog;

public class InsertButtonActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		new InsertThingDialog().setVisible(true);
	}
}
