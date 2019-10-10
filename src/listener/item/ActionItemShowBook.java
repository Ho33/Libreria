package listener.item;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.Tema;
import control.paraUI;

public class ActionItemShowBook implements ActionListener{
	
	private paraUI ui;
	
	public ActionItemShowBook(paraUI ui) {
		super();
		this.ui = ui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.ui.asociarPanel("showbook");
		this.ui.fillRow();
	}
}
