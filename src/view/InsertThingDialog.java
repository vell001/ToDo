package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Thing;
import model.Todo;
import controller.TodoManager;

public class InsertThingDialog extends ModifyThingDialog {
	private static final long serialVersionUID = 2057460434009188091L;
	private Todo todo = TodoManager.getTodoManager().getTodo();

	public InsertThingDialog() {
		super(new Thing("your message", System.currentTimeMillis(), Thing.TODO));
	}

	protected void initStyle() {
		super.initStyle();
		setTitle("InsertThingDialog");
	}

	protected void addListeners() {
		super.addListeners();
		this.confirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				thing.setMessage(messageText.getText());
				thing.setMillis(dateChooserJButton.getDate().getTime());
				todo.getThings().add(thing);
				TodoManager.getTodoManager().saveTodo();
				ThingFrame.getThingFrame().updateView();
				setVisible(false);
			}
		});
	}
}
