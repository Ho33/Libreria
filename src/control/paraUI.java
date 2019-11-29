package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ListSelectionModel;

import Vista.libUI;
import listener.button.ButtonAdd;
import listener.button.ButtonAddC;
import listener.button.ButtonDelete;
import listener.button.ButtonDeleteCantidad;
import listener.button.ButtonExit;
import listener.button.ButtonModificar;
import listener.button.ButtonMostrar;
import listener.button.ButtonNew;
import listener.button.WindownClose;
import listener.item.ActionItemAddBook;
import listener.item.ActionItemShowBook;
import listener.item.ActionItemTema;
import listener.txtField.TxtISBN;

public class paraUI extends libUI {

	private Control control;
	private ListSelectionModel modelo;
	
	
	public paraUI() throws IllegalArgumentException, IllegalAccessException, SecurityException, IOException, SQLException {
		super();
		this.control = new Control();
		// Listener Items
		getItemListado().addActionListener(new ActionItemShowBook(this));
		getItemAddBook().addActionListener(new ActionItemAddBook(this));
		getItemTema().addActionListener(new ActionItemTema(this));
		// Listener Buttons
		getAddbook().getBtnExit().addActionListener(new ButtonExit());
		getAddbook().getBtnAltas().addActionListener(new ButtonAdd(this));
		getAddbook().getBtnNuevas().addActionListener(new ButtonNew(this));
		getShowBook().getBtnBaja().addActionListener(new ButtonDelete(this));
		getShowBook().getBtnMostrar().addActionListener(new ButtonMostrar(this));
		getShowBook().getBtnAddLibro().addActionListener(new ButtonAddC(this));
		getShowBook().getBtnEliminarCantidad().addActionListener(new ButtonDeleteCantidad(this));
		getAddbook().getTxtISBN().addKeyListener(new TxtISBN(this));
		getAddbook().getBtnModificar().addActionListener(new ButtonModificar(this));
		//addWindowListener(new WindownClose(this));
	}

	public void fillRow() {
		try {
			rellenarLib(this.control.addFila());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Control getControl() {
		return control;
	}

	public ListSelectionModel getModelo() {
		return modelo;
	}
}
