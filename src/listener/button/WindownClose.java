package listener.button;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import Modelo.Libreria;
import control.paraUI;

public class WindownClose implements WindowListener {
	
	private paraUI ui;	
	

	public WindownClose(paraUI ui) {
		super();
		this.ui = ui;
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		this.ui.getControl().updateLibrary();

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}
