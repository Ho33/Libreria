package Vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

public class addBook extends JPanel{

	private JTextField txtAutor;
	private JTextField txtTitulo;
	private JTextField txtInfo;
	private JLabel lblLibreria;
	private JButton btnAltas;
	private JButton btnNuevas;
	private JComboBox comboTema;
	private JCheckBox chckbxTapaDura;
	private JCheckBox chckbxRustica;
	private JCheckBox chkCartone;
	private JCheckBox chckbxReedicion;
	private JCheckBox chckbxNovedad;
	private JButton btnExit;
	private JPanel titlePanel;
	private JPanel dataPanel;
	private JPanel btnPanel;
	private JPanel checkPanel;
	private JTextField txtPrecio;
	private JTextField txtISBN;
	private JTextField txtNpag;
	private ButtonGroup tipe;
	private ButtonGroup status;
	private JSpinner spnCantidad;
	private JLabel lblPrecio;
	private JButton btnModificar;

	/**
	 * Create the panel.
	 */
	public addBook(Color fondo){
		titlePanel = new JPanel();
		titlePanel.setBackground(fondo);

		dataPanel = new JPanel();
		dataPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		dataPanel.setBackground(Color.CYAN);

		checkPanel = new JPanel();
		checkPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		checkPanel.setBackground(fondo);

		chkCartone = new JCheckBox("Carton\u00E9");
		chkCartone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chkCartone.setBackground(fondo);

		chckbxRustica = new JCheckBox("Rustica");
		chckbxRustica.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxRustica.setBackground(fondo);

		chckbxTapaDura = new JCheckBox("Tapa dura");
		chckbxTapaDura.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxTapaDura.setBackground(fondo);

		chckbxNovedad = new JCheckBox("Novedad");
		chckbxNovedad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxNovedad.setBackground(fondo);

		chckbxReedicion = new JCheckBox("Reedicion");
		chckbxReedicion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxReedicion.setBackground(fondo);

		JLabel lblInfo = new JLabel("INFORMACION");
		lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtInfo = new JTextField();
		txtInfo.setColumns(10);

		GroupLayout gl_checkPanel = new GroupLayout(checkPanel);
		gl_checkPanel.setHorizontalGroup(gl_checkPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_checkPanel.createSequentialGroup().addGap(84).addGroup(gl_checkPanel
						.createParallelGroup(Alignment.TRAILING)
						.addComponent(chkCartone, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
						.addComponent(chckbxTapaDura, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
						.addComponent(chckbxNovedad, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
						.addComponent(chckbxReedicion, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
						.addComponent(chckbxRustica, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblInfo, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(txtInfo, GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE).addGap(89)));
		gl_checkPanel.setVerticalGroup(gl_checkPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_checkPanel.createSequentialGroup().addGap(43).addComponent(chkCartone)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(chckbxRustica)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(chckbxTapaDura).addGap(43)
						.addComponent(chckbxNovedad).addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(chckbxReedicion).addGap(147)
						.addGroup(gl_checkPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblInfo, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtInfo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(160)));
		checkPanel.setLayout(gl_checkPanel);

		JLabel lblTitulo = new JLabel("TITULO");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblAutor = new JLabel("AUTOR");
		lblAutor.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblTema = new JLabel("TEMA");
		lblTema.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNpags = new JLabel("N\u00BAPAGs");
		lblNpags.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtAutor = new JTextField();
		txtAutor.setColumns(10);

		txtTitulo = new JTextField();
		txtTitulo.setColumns(10);

		txtISBN = new JTextField();
		txtISBN.setColumns(10);

		txtNpag = new JTextField();
		txtNpag.setColumns(10);

		comboTema = new JComboBox();

		btnPanel = new JPanel();

		btnAltas = new JButton("ALTAS");

		btnNuevas = new JButton("NUEVAS");

		JLabel lblPrice = new JLabel("PRECIO");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);

		lblPrecio = new JLabel("CANTIDAD");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));

		spnCantidad = new JSpinner();

		GroupLayout gl_dataPanel = new GroupLayout(dataPanel);
		gl_dataPanel.setHorizontalGroup(gl_dataPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_dataPanel
				.createSequentialGroup().addGap(36)
				.addGroup(gl_dataPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnPanel, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_dataPanel.createSequentialGroup().addGroup(gl_dataPanel
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_dataPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblPrice, GroupLayout.PREFERRED_SIZE, 54,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblIsbn, GroupLayout.PREFERRED_SIZE, 48,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblPrecio, Alignment.TRAILING))
								.addComponent(lblNpags, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTema, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAutor, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTitulo, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_dataPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(spnCantidad, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
										.addComponent(txtAutor, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
										.addComponent(txtTitulo, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
										.addComponent(comboTema, 0, 270, Short.MAX_VALUE)
										.addComponent(txtNpag, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
										.addComponent(txtPrecio, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
										.addComponent(txtISBN, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))))
				.addGap(52)));
		gl_dataPanel.setVerticalGroup(gl_dataPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_dataPanel
				.createSequentialGroup().addGap(29)
				.addGroup(gl_dataPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtAutor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTitulo))
				.addGap(49)
				.addGroup(gl_dataPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblAutor).addComponent(
						txtTitulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(54)
				.addGroup(gl_dataPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboTema, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTema))
				.addGap(50)
				.addGroup(gl_dataPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblNpags).addComponent(
						txtNpag, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(38)
				.addGroup(gl_dataPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtISBN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIsbn))
				.addGap(35)
				.addGroup(gl_dataPanel.createParallelGroup(Alignment.TRAILING).addComponent(lblPrice).addComponent(
						txtPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(30)
				.addGroup(gl_dataPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPrecio, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(spnCantidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
				.addComponent(btnPanel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE).addGap(43)));
		dataPanel.setLayout(gl_dataPanel);

		lblLibreria = new JLabel("LIBRERIA");
		lblLibreria.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblLibreria.setHorizontalAlignment(SwingConstants.CENTER);

		btnExit = new JButton("EXIT");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup().addGap(10).addGroup(groupLayout
								.createParallelGroup(Alignment.TRAILING)
								.addComponent(titlePanel, GroupLayout.DEFAULT_SIZE, 950, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup().addGap(13)
										.addComponent(dataPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addGap(18)
										.addComponent(checkPanel, GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE))))
						.addGroup(groupLayout.createSequentialGroup().addContainerGap(870, Short.MAX_VALUE)
								.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(titlePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(dataPanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 541,
										Short.MAX_VALUE)
								.addComponent(checkPanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(29).addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		GroupLayout gl_titlePanel = new GroupLayout(titlePanel);
		gl_titlePanel.setHorizontalGroup(gl_titlePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_titlePanel.createSequentialGroup().addGap(200)
						.addComponent(lblLibreria, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE).addGap(162)));
		gl_titlePanel.setVerticalGroup(
				gl_titlePanel.createParallelGroup(Alignment.TRAILING).addGroup(gl_titlePanel.createSequentialGroup()
						.addContainerGap().addComponent(lblLibreria, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)));
		titlePanel.setLayout(gl_titlePanel);
		setLayout(groupLayout);
		setBackground(Color.cyan);
		btnPanel.setLayout(new GridLayout(0, 3, 0, 0));
		btnPanel.add(btnAltas);
		btnPanel.add(btnNuevas);
		
		btnModificar = new JButton("MODIFICAR");
		btnPanel.add(btnModificar);
		tipe = new ButtonGroup();
		tipe.add(chkCartone);
		tipe.add(chckbxTapaDura);
		tipe.add(chckbxRustica);
		status = new ButtonGroup();
		status.add(chckbxNovedad);
		status.add(chckbxReedicion);
		soloNumeros(txtPrecio);
		soloNumeros(txtNpag);
		soloNumeros(txtNpag);
			}
	
	
	public void soloNumeros(Component component) {
		component.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if ((e.getKeyChar() < '0' || e.getKeyChar() > '9')) {
					e.consume();
				}
			}
		});
	}
	

	public JLabel addImage(String name) {
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(getClass().getResource(name));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		return picLabel;
	}

	public void enableField() {
		btnAltas.setEnabled(true);
		txtAutor.setEnabled(true);
		txtISBN.setEnabled(true);
		txtNpag.setEnabled(true);
		txtTitulo.setEnabled(true);
		txtPrecio.setEnabled(true);
		comboTema.setEnabled(true);
		spnCantidad.setEnabled(true);
	}

	public void disableField() {
		btnAltas.setEnabled(false);
		txtAutor.setEnabled(false);
		txtISBN.setEnabled(false);
		txtNpag.setEnabled(false);
		txtTitulo.setEnabled(false);
		txtPrecio.setEnabled(false);
		comboTema.setEnabled(false);
		spnCantidad.setEnabled(false);
		limpiarCHK();
	}

	public void emptyField() {
		getTxtTitulo().setText("");
		getTxtISBN().setText("");
		getTextPrecio().setText("");
		getTxtNpag().setText("");
		getTxtInfo().setText("");
		getTxtInfo().setBackground(Color.white);
		getTxtAutor().setText("");
		getSpnCantidad().setValue(0);
		limpiarCHK();

	}

	private void limpiarCHK() {
		tipe.clearSelection();
		status.clearSelection();
	}

	public String getCheckBoxTipe() {
		if (chckbxRustica.isSelected()) {
			return chckbxRustica.getText();
		} else if (chkCartone.isSelected()) {
			return chkCartone.getText();
		} else if (chckbxTapaDura.isSelected()) {
			return chckbxTapaDura.getText();
		}
		return null;
	}

	public String getCheckBoxStatus() {
		if (chckbxNovedad.isSelected()) {
			return chckbxNovedad.getText();
		} else if (chckbxReedicion.isSelected()) {
			return chckbxReedicion.getText();
		}
		return null;
	}

	public JTextField getTxtTitulo() {
		return txtAutor;
	}

	public JTextField getTxtAutor() {
		return txtTitulo;
	}

	public JTextField getTxtInfo() {
		return txtInfo;
	}

	public JLabel getLblLibreria() {
		return lblLibreria;
	}

	public JButton getBtnAltas() {
		return btnAltas;
	}

	public JButton getBtnNuevas() {
		return this.btnNuevas;
	}

	public JComboBox getComboTema() {
		return comboTema;
	}

	public JCheckBox getChckbxTapaDura() {
		return chckbxTapaDura;
	}

	public JCheckBox getChckbxRustica() {
		return chckbxRustica;
	}

	public JCheckBox getChkCartone() {
		return chkCartone;
	}

	public JCheckBox getChckbxReedicion() {
		return chckbxReedicion;
	}

	public JCheckBox getChckbxNovedad() {
		return chckbxNovedad;
	}

	public JButton getBtnExit() {
		return btnExit;
	}

	public JPanel getTitlePanel() {
		return titlePanel;
	}

	public JPanel getDataPanel() {
		return dataPanel;
	}

	public JPanel getBtnPanel() {
		return btnPanel;
	}

	public JPanel getCheckPanel() {
		return checkPanel;
	}

	public JTextField getTextPrecio() {
		return txtPrecio;
	}

	public JTextField getTxtISBN() {
		return txtISBN;
	}

	public JTextField getTxtNpag() {
		return txtNpag;
	}

	public JSpinner getSpnCantidad() {
		return spnCantidad;
	}

	public ButtonGroup getTipe() {
		return tipe;
	}

	public ButtonGroup getStatus() {
		return status;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}
	
}
