package control;

import java.util.ArrayList;

import Modelo.Libreria;
import Modelo.Libro;
import Modelo.Tema;

public class Control {

	private Libreria lib;

	public Control() {
		super();
		this.lib = new Libreria();
	}

	public void addLb(String titulo, String autor, String isbn, Tema tema, String numeroPag, String precio,
			String checkTipe, String checkStatus,String cantidad) {
		lib.addLB(titulo, autor, isbn, tema, numeroPag, precio, checkTipe, checkStatus, cantidad);
	}

	public boolean compareISBN(String isbn) {
		boolean result = false;
		if (lib.compareIsbn(isbn)) {
			result = true;
		}
		return result;
	}
	public void aumentarCantidad(String isbn,int cantidad) {
		this.lib.aumentarCantidad(cantidad, isbn);
	}

	public Libro getLibro(String isbn) {
		return lib.getBook(isbn);
	}

	public void deleteBook(String isbn) {
		lib.deleteLB(lib.getBook(isbn));
	}
	
	public String[][] addFila() {
		return this.lib.addFila();
	}

	public ArrayList<Libro> getLib() {
		return lib.getLibreria();
	}
}
