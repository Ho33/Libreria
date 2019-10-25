package listener.item;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Modelo.Tema;
import Vista.addLibro;
import control.paraUI;

public class ActionItemAddBook implements ActionListener {

	private paraUI ui;

	public ActionItemAddBook(paraUI ui) {
		super();
		this.ui = ui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		this.ui.getAddbook().enableField();
//		this.ui.getAddbook().emptyField();
		this.ui.asociarPanel("addbook");
//		addLibro addLibro = new addLibro();
		this.ui.getAddbook().getComboTema().removeAllItems();
		for (Tema tema : Tema.values()) {
			this.ui.getAddbook().getComboTema().addItem(tema);
		}
	};
	
}



