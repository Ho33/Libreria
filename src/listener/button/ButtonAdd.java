package listener.button;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import Modelo.Tema;
import control.paraUI;

public class ButtonAdd implements ActionListener {

	private paraUI ui;

	public ButtonAdd(paraUI ui) {
		super();
		this.ui = ui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (isWord(ui.getAddbook().getTxtISBN().getText())
				&& isNumeric(ui.getAddbook().getTextPrecio().getText(), ui.getAddbook().getTxtNpag().getText())) {
			if (!ui.getControl().compareISBN(ui.getAddbook().getTxtISBN().getText())) {
				addLB();
			} else {
				alreadyADD();
			}
		} else {
			JOptionPane.showMessageDialog(null, "DATOS INVALIDOS");
		}
		this.ui.deselectedEverything();
	}

	private void alreadyADD() {
		ui.getAddbook().getTxtInfo().setBackground(Color.red);
		ui.getAddbook().getTxtInfo().setText("Ese libro ya esta registrado");
	}

	private void addLB() {
		ui.getAddbook().getTxtInfo().setBackground(Color.green);
		ui.getControl().addLb(ui.getAddbook().getTxtTitulo().getText(), ui.getAddbook().getTxtAutor().getText(),
				ui.getAddbook().getTxtISBN().getText(), (Tema) ui.getAddbook().getComboTema().getSelectedItem(),
				ui.getAddbook().getTxtNpag().getText(), ui.getAddbook().getTextPrecio().getText(), ui.getCheckBoxTipe(),
				ui.getCheckBoxStatus(), ui.getAddbook().getSpnCantidad().getValue().toString());
		ui.getAddbook().getTxtInfo().setText("añadido");
	}
	
	private static boolean isWord(String word) {
		if (word.isEmpty()) {
			return false;
		}
		return Pattern.matches("[a-zA-Z]+", word);
	}

	public boolean isNumeric(String word, String palabra) {
		try {
			Integer.parseInt(word);
			Integer.parseInt(palabra);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public boolean isSelected() {
		if (ui.getAddbook().getTipe().getSelection().isSelected()
				&& ui.getAddbook().getStatus().getSelection().isSelected()) {
			return true;
		}
		return false;
	}
}
