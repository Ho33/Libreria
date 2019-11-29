package Modelo;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import accessDB.DTOLibrary;
import accessDB.DTOTema;

public class Libreria implements Serializable {

	private DTOLibrary dtoLibreria;
	private DTOTema dtotema;
	private String nameDB = "Library";

	public Libreria() {
		super();
		this.dtoLibreria = new DTOLibrary(this.nameDB);
		this.dtotema = new DTOTema(this.nameDB);
	}

	public void addLB(String titulo, String autor, String isbn, String tema, String numeroPag, String precio,
			String checkTipe, String checkStatus, String cantidad) throws IOException {
		Libro book = new Libro(titulo, autor, isbn, tema, numeroPag, precio, checkTipe, checkStatus, cantidad);
		this.dtoLibreria.save(book);
	}

	public void deleteLB(Libro deleteLB) {
		Libro librito = dtoLibreria.sqlSearchBook(deleteLB.getISBN());
		if (librito.getCantidad().equals("0")) {
			this.dtoLibreria.sqlDeleteBook(deleteLB.getISBN());
		} else {
			JOptionPane.showMessageDialog(null, "Aún tienes stok disponible, no es posible elminar el libro");
		}
	}

	public void deletelibIfCantidad(String isbn, int cantidad) {
		Libro book = getBook(isbn);
		book.deleteCantidad(cantidad);
		this.dtoLibreria.modifyFields(isbn, "cantidad", book.getCantidad());
	}

	public Libro getBook(String isbn) {
		return this.dtoLibreria.sqlSearchBook(isbn);
	}

	public void aumentarCantidad(int cantidad, String isbn) {
		Libro book = getBook(isbn);
		book.aumentarCantidad(cantidad);
		this.dtoLibreria.modifyFields(isbn, "cantidad", book.getCantidad());
	}

	public boolean compareIsbn(String isbn) {
		return this.getBook(isbn) != null;
	}

	public void modifyBook(Libro libro) {
		this.dtoLibreria.sqlModifyBook(libro);
	}

	public ArrayList<String> getTema()
			throws IllegalArgumentException, IllegalAccessException, SecurityException, IOException, SQLException {
		return this.dtotema.read();
	}

	public void addTheme(String theme) {
		try {
			this.dtotema.saveTheme(theme);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void deleteTheme(String theme) {
		try {
			this.dtotema.deleteTheme(theme);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String[][] addFila() throws IllegalAccessException {
		String[][] retorno = new String[this.getLibreria().size()][9];
		int index = 0;
		for (Libro lib : this.getLibreria()) {
			retorno[index][0] = lib.getISBN();
			retorno[index][1] = lib.getTitulo();
			retorno[index][2] = lib.getPrecio();
			retorno[index][3] = lib.getCantidad();
			retorno[index][4] = lib.getNumeroPag();
			retorno[index][5] = lib.getFormato();
			retorno[index][6] = lib.getEstado();
			retorno[index][7] = lib.getTema().toString();
			retorno[index][8] = lib.getAutor();
			index++;
		}
		return retorno;
	}

	public String[] getBookFields(Libro libro) {
		String[] result = new String[9];
		result[0] = libro.getTitulo();
		result[1] = libro.getAutor();
		result[2] = libro.getTema();
		result[3] = libro.getNumeroPag();
		result[4] = libro.getFormato();
		result[5] = libro.getEstado();
		result[6] = libro.getPrecio();
		result[7] = libro.getCantidad();
		result[8] = libro.getISBN();
		return result;
	}

	public ArrayList<Libro> getLibreria() throws IllegalAccessException {
		return dtoLibreria.readBooks();
	}
}
