package Vista;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class infoLibros extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private String[] data;
	private JTextPane textPane;
	private JTextPane textPane_1;
	private JTextPane textPane_2;
	private JTextPane textPane_3;
	private JTextPane textPane_4;
	private JTextPane textPane_5;
	private JTextPane textPane_7;
	private JTextPane textPane_6;
	private JTextPane textPane_8;
	private JLabel lblIsbn;
	private JLabel lblTitulo;
	private JLabel lblPrecio;
	private JLabel lblAutor;
	private JLabel lblPaginas;
	private JLabel lblTipo;
	private JLabel lblEstado;
	private JLabel lblTematica;
	private JLabel lblCantidad;
	private JButton btnEditar;
	private JPanel panel_1;
	private JLabel lblNewLabel;

	public infoLibros(String[] datos) {
		this.data = datos;
		setBackground(new Color(200, 200, 200));
		setResizable(false);
		setVisible(true);
		setBounds(100, 100, 400, 492);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 1, 0, 10));

		JPanel panel = new JPanel();
		contentPanel.add(panel);

		textPane = new JTextPane();

		textPane_1 = new JTextPane();

		textPane_2 = new JTextPane();

		textPane_3 = new JTextPane();

		textPane_4 = new JTextPane();

		textPane_5 = new JTextPane();

		textPane_6 = new JTextPane();

		textPane_7 = new JTextPane();
		
		lblIsbn = new JLabel("ISBN");
		lblIsbn.setHorizontalAlignment(SwingConstants.LEFT);
		lblIsbn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblTitulo = new JLabel("TITULO");
		lblTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblPrecio = new JLabel("PRECIO");
		lblPrecio.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblAutor = new JLabel("AUTOR");
		lblAutor.setHorizontalAlignment(SwingConstants.LEFT);
		lblAutor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblPaginas = new JLabel("PAGINAS");
		lblPaginas.setHorizontalAlignment(SwingConstants.LEFT);
		lblPaginas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblTipo = new JLabel("TIPO");
		lblTipo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTipo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblEstado = new JLabel("ESTADO");
		lblEstado.setHorizontalTextPosition(SwingConstants.CENTER);
		lblEstado.setHorizontalAlignment(SwingConstants.LEFT);
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblTematica = new JLabel("TEMATICA");
		lblTematica.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTematica.setHorizontalAlignment(SwingConstants.LEFT);
		lblTematica.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblCantidad = new JLabel("CANTIDAD");
		lblCantidad.setHorizontalAlignment(SwingConstants.LEFT);
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textPane_8 = new JTextPane();
		textPane_8.setText((String) null);
		
		JPanel pnlBoton = new JPanel();
		
		panel_1 = new JPanel();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblAutor, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED))
								.addComponent(lblTematica, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
								.addComponent(lblTipo, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
								.addComponent(lblPaginas, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
								.addComponent(lblEstado, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
								.addComponent(lblCantidad, Alignment.TRAILING))
							.addGap(10)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(textPane_4, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
										.addComponent(textPane_5, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
										.addComponent(textPane_6, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
										.addComponent(textPane_7, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
										.addComponent(textPane_3, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE))
									.addGap(17))
								.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
									.addComponent(textPane_8, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
									.addGap(17))))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(pnlBoton, GroupLayout.PREFERRED_SIZE, 294, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
							.addGap(16))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblIsbn, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
								.addComponent(lblTitulo, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
								.addComponent(lblPrecio, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_panel.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(textPane)
									.addComponent(textPane_1, GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE))
								.addComponent(textPane_2, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 287, GroupLayout.PREFERRED_SIZE))
							.addGap(13))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblIsbn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTitulo, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(textPane_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(textPane_2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPrecio, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAutor, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(textPane_8, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPaginas, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(textPane_4, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTipo, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(textPane_5, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEstado, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(textPane_6, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTematica, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(textPane_7, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textPane_3, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(pnlBoton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblCantidad, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(31))
		);
		panel_1.setLayout(new CardLayout(0, 0));
		
		lblNewLabel = new JLabel("DATOS");
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 46));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel, "name_133090866175300");
		pnlBoton.setLayout(new CardLayout(0, 0));
		
		btnEditar = new JButton("EDITAR");
		pnlBoton.add(btnEditar, "name_128969754259800");
		panel.setLayout(gl_panel);
		setLocationRelativeTo(null);
		rellenarDatos();
	}

//}

	private void rellenarDatos() {
		this.textPane.setText(this.data[0]);
		this.textPane_1.setText(this.data[1]);
		this.textPane_2.setText(this.data[2]);
		this.textPane_3.setText(this.data[3]);
		this.textPane_4.setText(this.data[4]);
		this.textPane_5.setText(this.data[5]);
		this.textPane_6.setText(this.data[6]);
		this.textPane_7.setText(this.data[7]);
		this.textPane_8.setText(this.data[8]);
		this.textPane.setEnabled(false);
	}
}
