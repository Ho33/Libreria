package Modelo;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

import almacen.DTO;

public class Libreria implements Serializable {

	private ArrayList<Libro> libros;
	private DTO<Libro> dtoLibreria;
	private String path = "./libros";

	public Libreria() {
		super();
		this.dtoLibreria = new DTO<Libro>();
		this.libros = getLibreria();
		File path = new File(this.path);
		if (!path.exists()) {
			path.mkdir();
		}
	}

	public void addLB(String titulo, String autor, String isbn, Tema tema, String numeroPag, String precio,
			String checkTipe, String checkStatus, String cantidad) {
		this.libros.add(new Libro(titulo, autor, isbn, tema, numeroPag, precio, checkTipe, checkStatus, cantidad));
		updateLibrary();
	}

	public void updateLibrary() {
		if (this.libros != null) {
			for (Libro libro : libros) {
				this.dtoLibreria.grabar(libro, getRute(libro.getISBN()));
			}
		}
	}

	public void deleteLB(Libro deleteLB) {
		ArrayList<Libro> toRemove = new ArrayList<Libro>();
		for (Libro libro : libros) {
			if (libro.equals(deleteLB)) {
				toRemove.add(libro);
				deleteBook(libro.getISBN());
			}
		}
		this.libros.removeAll(toRemove);
		updateLibrary();
	}

	public void deletelibIfCantidad(String isbn, int cantidad) {
		getBook(isbn).deleteCantidad(cantidad);
		for (Libro libro : libros) {
			if (Integer.parseInt(libro.getCantidad()) < 0) {
				libro.setCantidad("0");
			}
		}
		updateLibrary();
	}

	public void deleteBook(String ISBN) {
		File file = new File(this.getRute(ISBN));
		if (file.exists())
			file.delete();
	}

	public Libro getBook(String isbn) {
		Libro selected = null;
		for (Libro libro : libros) {
			if (libro.compareLb(isbn)) {
				selected = libro;
			}
		}
		return selected;
	}

	public void aumentarCantidad(int cantidad, String isbn) {
		getBook(isbn).aumentarCantidad(cantidad);
		updateLibrary();
	}

	public boolean compareIsbn(String isbn) {
		boolean selected = false;
		for (Libro libro : libros) {
			if (libro.compareLb(isbn)) {
				selected = true;
			}
		}
		return selected;
	}

	public String[][] addFila() {
		String[][] retorno = new String[this.libros.size()][9];
		int index = 0;
		for (Libro lib : this.libros) {
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

	public ArrayList<Libro> getLibreria() {
		ArrayList<Libro> libros = new ArrayList<Libro>();
		String[] path = new File(this.path).list();
		for (int i = 0; i < path.length; i++) {
			libros.add(dtoLibreria.leer(this.path + "/" + path[i]));
		}
		return libros;
	}

	public String getRute(String isbn) {
		return this.path + "/" + isbn + ".dat";

	}
}
