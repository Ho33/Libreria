package Vista;

import java.awt.CardLayout;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class showBook extends JPanel {
	private JPanel panel;
	private String columnaLibro[] = { "ISBN", "Libro","Precio","Cantidad" };
	private JScrollPane scrollPane;
	protected JTable tableLibros = new JTable();
	private String datosLibro[][];
	private JButton btnBaja;
	private JButton btnMostrar = new JButton();
	private JButton btnAddLibro;

	/**
	 * Create the panel.
	 */
	public showBook() {
		panel = new JPanel();

		scrollPane = new JScrollPane();

		JPanel panel_1 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE))
					.addGap(35))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
					.addGap(31)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(24))
		);

		btnBaja = new JButton("ELIMINAR");
		btnBaja.setActionCommand("");
		
		btnMostrar = new JButton("MOSTRAR");
		btnMostrar.setActionCommand("");
		
		btnAddLibro = new JButton("A\u00D1ADIR LIBRO");
		btnAddLibro.setActionCommand("");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(btnAddLibro, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnMostrar, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnBaja, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
					.addComponent(btnAddLibro, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addComponent(btnBaja, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addComponent(btnMostrar, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
		);
		panel_1.setLayout(gl_panel_1);

		JLabel lblTitulo = new JLabel("LISTADO");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(lblTitulo,
				GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE));
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup().addGap(5)
						.addComponent(lblTitulo, GroupLayout.PREFERRED_SIZE, 32, Short.MAX_VALUE).addContainerGap()));
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
		
	}

	public String getIsbnRow() {
		String isbn = null;
		if (this.tableLibros.getSelectedRow() != -1) {
			isbn = datosLibro[this.tableLibros.getSelectedRow()][0];
		}
		return isbn;
	}

	public void rellenarLibro(String[][] datos) {
		this.datosLibro = datos;
		DefaultTableModel defaultTableModelC = new DefaultTableModel(datosLibro, columnaLibro);
		tableLibros.setModel(defaultTableModelC);
		tableLibros.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 15));
		tableLibros.setDefaultEditor(Object.class, null);
		scrollPane.setViewportView(tableLibros);
	}

	public String[][] getData() {
		return datosLibro;
	}

	public JPanel getPanel() {
		return panel;
	}

	public String[] getColumnaCita() {
		return columnaLibro;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public JTable getTableLibros() {
		return tableLibros;
	}

	public String[][] getDatosLibro() {
		return datosLibro;
	}

	public JButton getBtnBaja() {
		return btnBaja;
	}

	public JButton getBtnMostrar() {
		return btnMostrar;
	}

	public JButton getBtnAddLibro() {
		return btnAddLibro;
	}
	
	
}
