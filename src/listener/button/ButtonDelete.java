package listener.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ListSelectionModel;

import control.paraUI;

public class ButtonDelete implements ActionListener {

	private paraUI ui;

	public ButtonDelete(paraUI ui) {
		super();
		this.ui = ui;
	}

	@Override
	public void actionPerformed(ActionEvent e)throws ArrayIndexOutOfBoundsException{
		if (this.ui.getShowBook().getIsbnRow()!=null) {
			this.ui.getControl().deleteBook(this.ui.getShowBook().getIsbnRow());
			this.ui.fillRow();
		} else {
			this.ui.fillRow();
		}
	}
}
