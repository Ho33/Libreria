package listener.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import control.paraUI;

public class ButtonAddC implements ActionListener {

	private paraUI ui;

	public ButtonAddC(paraUI ui) {
		super();
		this.ui = ui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (ui.getShowBook().getTableLibros().getSelectedRow()!=-1) {
			String cantidad = JOptionPane.showInputDialog("CANTIDAD");
			if (isNumeric(cantidad)) {
				int numberOffBook = Integer.parseInt(cantidad);
				String isbn = this.ui.getShowBook().getIsbnRow();
				try {
					this.ui.getControl().aumentarCantidad(isbn, numberOffBook);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else {
				JOptionPane.showMessageDialog(null, "Introduzca un numero por favor, cambios no guardados");
			}
		}
		this.ui.fillRow();
	}
	public boolean isNumeric(String cantidad) {
		try {
			Integer.parseInt(cantidad);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
