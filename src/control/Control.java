package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import Modelo.Libreria;
import Modelo.Libro;

public class Control {

	private Libreria lib;
	private validadores validate;

	public Control() {
		super();
		this.validate = new validadores();
		this.lib = new Libreria();
	}

	public void addLb(String titulo, String autor, String isbn, String tema, String numeroPag, String precio,
			String checkTipe, String checkStatus, String cantidad) throws IOException {
		if (validate.executeValidate(this.lib.getBookFields(
				new Libro(titulo, autor, isbn, tema, numeroPag, precio, checkTipe, checkStatus, cantidad)))) {
			lib.addLB(titulo, autor, isbn, tema, numeroPag, precio, checkTipe, checkStatus, cantidad);
		}
	}

	public boolean compareISBN(String isbn) {
		boolean result = false;
		if (lib.compareIsbn(isbn)) {
			result = true;
		}
		return result;
	}

	public void aumentarCantidad(String isbn, int cantidad) throws IOException {
		this.lib.aumentarCantidad(cantidad, isbn);
	}

	public void deleteLibroIfCantidad(String isbn, int cantidad) throws IOException {
		this.lib.deletelibIfCantidad(isbn, cantidad);
	}

	public void modifyBook(Libro libro) {
		this.lib.modifyBook(libro);
	}

	public Libro getLibro(String isbn) {
		return lib.getBook(isbn);
	}

	public void deleteBook(String isbn) throws IOException {
		lib.deleteLB(lib.getBook(isbn));
	}

	public ArrayList<String> getTema() throws IllegalArgumentException, IllegalAccessException, SecurityException, IOException, SQLException {
		return this.lib.getTema();
	}

	public String[][] addFila() throws IllegalAccessException {
		return this.lib.addFila();
	}

	public ArrayList<Libro> getLib() throws IllegalAccessException {
		return lib.getLibreria();
	}

	public void deleteCantidad(String isbn, int numberOffBook) throws IOException {
		this.lib.deletelibIfCantidad(isbn, numberOffBook);
	}
}
