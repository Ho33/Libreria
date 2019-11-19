package Modelo;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import accessDB.DTOLibrary;

public class Libreria implements Serializable {

	private DTOLibrary dtoLibreria;
	private String nameDB = "Library";

	public Libreria() {
		super();
		this.dtoLibreria = new DTOLibrary(this.nameDB);
	}

	public void addLB(String titulo, String autor, String isbn, String tema, String numeroPag, String precio,
			String checkTipe, String checkStatus, String cantidad) throws IOException {
		Libro book = new Libro(titulo, autor, isbn, tema, numeroPag, precio, checkTipe, checkStatus, cantidad);
		this.dtoLibreria.save(book);
	}

	public void deleteLB(Libro deleteLB) {
		this.dtoLibreria.sqlDeleteBook(deleteLB.getISBN());
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
	
	public void modifyBook(Libro libro){
		this.dtoLibreria.sqlModifyBook(libro);
	}

	public String[][] addFila() {
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
		String [] result = new String[8];
		result[0] = libro.getTitulo();
		result[1] = libro.getAutor();
		result[3] = libro.getNumeroPag();
		result[4] = libro.getFormato();
		result[5] = libro.getEstado();
		result[6] = libro.getPrecio();
		result[7] = libro.getCantidad();
		return result;
		
	}

	public ArrayList<Libro> getLibreria() {
		return dtoLibreria.readBooks();
	}
}
