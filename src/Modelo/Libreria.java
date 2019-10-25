package Modelo;

import java.io.Serializable;

import java.util.ArrayList;

import almacen.DTO;

public class Libreria implements Serializable {

	private ArrayList<Libro> libros;
	private DTO<ArrayList<Libro>> dtoLibreria;
	private String path = "libros.dat";

	public Libreria() {
		super();
		this.dtoLibreria = new DTO<ArrayList<Libro>>();
		this.libros = this.dtoLibreria.leer(path);
		if (this.libros == null) {
			this.libros = new ArrayList<Libro>();
		}
	}

	public void addLB(String titulo, String autor, String isbn, Tema tema, String numeroPag, String precio,
			String checkTipe, String checkStatus, String cantidad) {
		this.libros.add(new Libro(titulo, autor, isbn, tema, numeroPag, precio, checkTipe, checkStatus, cantidad));
		this.dtoLibreria.grabar(this.libros, path);
	}

	public void deleteLB(Libro deleteLB) {
		ArrayList<Libro> toRemove = new ArrayList<Libro>();
		for (Libro libro : libros) {
			if (libro.equals(deleteLB)) {
				toRemove.add(libro);
			}
		}
		this.libros.removeAll(toRemove);
	}

	public void deletelibIfCantidad(String isbn, int cantidad) {
		getBook(isbn).deleteCantidad(cantidad);
		for (Libro libro : libros) {
			if (Integer.parseInt(libro.getCantidad()) < 0) {
				libro.setCantidad("0");
			}
		}
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
		return libros;
	}
}
