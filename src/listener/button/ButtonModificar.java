package listener.button;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Modelo.Libro;
import control.paraUI;

public class ButtonModificar implements ActionListener {

	private paraUI ui;

	public ButtonModificar(paraUI ui) {
		super();
		this.ui = ui;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String txtISBN = ui.getAddbook().getTxtISBN().getText();
		Libro libro = ui.getControl().getLibro(txtISBN);
		libro.setTitulo(ui.getAddbook().getTxtTitulo().getText().toString());
		libro.setAutor(ui.getAddbook().getTxtAutor().getText().toString());
		libro.setTema(ui.getAddbook().getComboTema().getSelectedItem().toString());
		libro.setNumeroPag(ui.getAddbook().getTxtNpag().getText().toString());
		libro.setCantidad(ui.getAddbook().getSpnCantidad().getValue().toString());
		libro.setPrecio(ui.getAddbook().getTextPrecio().getText().toString());
		libro.setEstado(ui.getAddbook().getCheckBoxStatus());
		libro.setFormato(ui.getAddbook().getCheckBoxTipe());
		this.ui.getControl().modifyBook(libro);
		JOptionPane.showMessageDialog(null, "Modificado con exito");
	}
}
