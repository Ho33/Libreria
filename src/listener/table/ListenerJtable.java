package listener.table;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Vista.infoLibros;
import control.paraUI;

public class ListenerJtable implements ListSelectionListener {

	private paraUI ui;
	private infoLibros hola;
	
	public ListenerJtable(paraUI ui) {
		super();
		this.ui = ui;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!this.ui.getModelo().isSelectionEmpty()) {
			String datos[][] = this.ui.getShowBook().getData();
			String data[] = new String [datos[0].length];
			int selected = this.ui.getShowBook().getTableLibros().getSelectedRow();
			for (int i = 0; i < data.length; i++) {
					data[i] = datos[selected][i];
				}
				this.hola = new infoLibros(data);
			}
		}
	}

