package control;

import javax.swing.JOptionPane;

public class validadores {
	private String messageError = "Algun campo esta vacio o no selecionado";
	private String messageDone = "Dado de alta con exito";


	public boolean executeValidate(String data[]) {
			if (isEmpty(data)) {
				JOptionPane.showMessageDialog(null, this.messageError);
				return false;
			}
		JOptionPane.showMessageDialog(null, this.messageDone);
		return true;
	}

	private boolean isEmpty(String data[]) {
		boolean result = false;
		for (int i = 0; i < data.length; i++) {
			if (data[i].isBlank()) {
				result = true;
			}
		}
		return result;
	}
	
}