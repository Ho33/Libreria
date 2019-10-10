package listener.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.paraUI;

public class ButtonNew implements ActionListener {
	
	private paraUI ui;
	
	
	public ButtonNew(paraUI ui) {
		super();
		this.ui = ui;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		this.ui.getAddbook().emptyField();
		this.ui.getAddbook().enableField();
	}

}
