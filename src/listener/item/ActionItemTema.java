package listener.item;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JDialog;

import Vista.aboutTheme;
import control.paraUI;

public class ActionItemTema implements ActionListener {
	private paraUI ui;

	public ActionItemTema(paraUI ui) {
		super();
		this.ui = ui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			new aboutTheme();
		} catch (IllegalArgumentException | IllegalAccessException | SecurityException | IOException
				| SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
