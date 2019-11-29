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
	/**
	 * Create the dialog.
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws SecurityException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public aboutTheme() throws IllegalArgumentException, IllegalAccessException, SecurityException, IOException, SQLException {
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
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		rellenarCombo();
	}
	public void rellenarCombo() throws IllegalArgumentException, IllegalAccessException, SecurityException, IOException, SQLException {
		ArrayList<String> temas = this.libreria.getTema();
		temas.forEach((n)->
		this.comboBorrar.addItem(n));
	}
}
