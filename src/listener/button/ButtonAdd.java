package listener.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import control.paraUI;

public class ButtonAdd implements ActionListener {

	private paraUI ui;

	public ButtonAdd(paraUI ui) {
		super();
		this.ui = ui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (ui.getAddbook().getTxtISBN().getText().length()==13) {
			if (!ui.getControl().compareISBN(ui.getAddbook().getTxtISBN().getText())) {
					try {
						addLB();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
			} else {
				alreadyADD();
			}
		} else {
			JOptionPane.showMessageDialog(null, "ISBN CON LONGITUD ERRONEA");
		}
		this.ui.deselectedEverything();
	}

	private void alreadyADD() {
		JOptionPane.showMessageDialog(null, "Ya hay un libro registrado con este ISBN");
	}

	private void addLB() throws IOException {
		ui.getControl().addLb(ui.getAddbook().getTxtTitulo().getText(), ui.getAddbook().getTxtAutor().getText(),
				ui.getAddbook().getTxtISBN().getText(), ui.getAddbook().getComboTema().getSelectedItem().toString(),
				ui.getAddbook().getTxtNpag().getText(), ui.getAddbook().getTextPrecio().getText(), ui.getCheckBoxTipe(),
				ui.getCheckBoxStatus(), ui.getAddbook().getSpnCantidad().getValue().toString());
	}
}
