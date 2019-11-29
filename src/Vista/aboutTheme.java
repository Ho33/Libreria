package Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Libreria;
import accessDB.DTOTema;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class aboutTheme extends JDialog {

	private JComboBox comboBorrar;
	private JTextField txtInsertTema;
	private JPanel buttonPane;
	private final JPanel panel = new JPanel();
	private Libreria libreria = new Libreria();
	private JButton btnEliminar;

	/**
	 * Create the dialog.
	 * 
	 * @throws SQLException
	 * @throws IOException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public aboutTheme()
			throws IllegalArgumentException, IllegalAccessException, SecurityException, IOException, SQLException {
		setVisible(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		{

			panel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JLabel label = new JLabel("INSERTAR TEMA");
				label.setBounds(78, 104, 109, 13);
				panel.add(label);
			}
			{
				txtInsertTema = new JTextField();
				txtInsertTema.setBounds(210, 101, 164, 19);
				txtInsertTema.setColumns(10);
				panel.add(txtInsertTema);
			}
			{
				JLabel label = new JLabel("BORRAR TEMA");
				label.setBounds(78, 165, 109, 13);
				panel.add(label);
			}

			comboBorrar = new JComboBox();
			comboBorrar.setBounds(210, 161, 164, 21);
			panel.add(comboBorrar);
		}
		{
			buttonPane = new JPanel();
			buttonPane.setBounds(0, 232, 436, 31);
			panel.add(buttonPane);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{
				JButton okButton = new JButton("Guardar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (!txtInsertTema.getText().isBlank()) {
							insertTheme();
							txtInsertTema.setText("");
							JOptionPane.showMessageDialog(null, "Dado de alta con exito");
							fillComboTheme();
						} else {
							JOptionPane.showMessageDialog(null, "Introduce algun dato braindead");
						}
					}
				});
				{
					btnEliminar = new JButton("Eliminar");
					btnEliminar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (comboBorrar.getSelectedItem() != null) {
								libreria.deleteTheme(comboBorrar.getSelectedItem().toString());
								JOptionPane.showMessageDialog(null, "Dado de baja exitosamente");
								fillComboTheme();
							} else {
								JOptionPane.showMessageDialog(null, "Dado de baja exitosamente MAL");
							}
						}
					});
					buttonPane.add(btnEliminar);
				}
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}

		fillComboTheme();
	}

	private void fillComboTheme() {
		ArrayList<String> temas;
		this.comboBorrar.removeAllItems();
		try {
			temas = this.libreria.getTema();
			temas.forEach((tema) -> this.comboBorrar.addItem(tema));
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void insertTheme() {
		this.libreria.addTheme(txtInsertTema.getText().toString());
	}
}
