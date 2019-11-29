package listener.item;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import control.paraUI;

public class ActionItemAddBook implements ActionListener {

	private paraUI ui;

	public ActionItemAddBook(paraUI ui) {
		super();
		this.ui = ui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ArrayList<String> temas;
		this.ui.getAddbook().getComboTema().removeAllItems();
		try {
			temas = this.ui.getControl().getTema();
			for (String tema : temas) {
				this.ui.getAddbook().getComboTema().addItem(tema);
			}
			this.ui.asociarPanel("addbook");
		} catch (IllegalArgumentException | IllegalAccessException | SecurityException | IOException
				| SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	};
}
