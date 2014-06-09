package manager.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Thing;
import view.ModifyThingDialog;

public class colorButtonsActionListener implements ActionListener {

	private int status;
	private ModifyThingDialog editThingDialog;
	private Thing thing;
	public colorButtonsActionListener(ModifyThingDialog ModifyThingDialog, int status) {
		this.status = status;
		this.editThingDialog = ModifyThingDialog;
		thing = ModifyThingDialog.getThing();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		thing.setStatus(status);
		editThingDialog.updateStatusColor();
	}

}
