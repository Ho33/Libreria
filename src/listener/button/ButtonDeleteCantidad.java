package listener.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import control.paraUI;

public class ButtonDeleteCantidad implements ActionListener {

	private paraUI ui;

	public ButtonDeleteCantidad(paraUI ui) {
		super();
		this.ui = ui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (ui.getShowBook().getTableLibros().getSelectedRow() != -1) {
			String cantidad = JOptionPane.showInputDialog("CANTIDAD");
			if (isNumeric(cantidad)) {
				int numberOffBook = Integer.parseInt(cantidad);
				String isbn = this.ui.getShowBook().getIsbnRow();
				this.ui.getControl().deleteCantidad(isbn, numberOffBook);
			} else {
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
