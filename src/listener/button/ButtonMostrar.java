package listener.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.infoLibros;
import control.paraUI;

public class ButtonMostrar implements ActionListener {
	private paraUI ui;

	public ButtonMostrar(paraUI ui) {
		super();
		this.ui = ui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int selected = this.ui.getShowBook().getTableLibros().getSelectedRow();
		if (this.ui.getShowBook().getTableLibros().getSelectedRow() != -1) {
			String datos[][] = this.ui.getShowBook().getData();
			String data[] = new String[datos[0].length];
			for (int i = 0; i < data.length; i++) {
				data[i] = datos[selected][i];
			}
			new infoLibros(data);
		}
	}
}
