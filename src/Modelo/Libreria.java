package Modelo;

import java.util.ArrayList;

public class Libreria {

	private ArrayList<Libro> libreria;

	public Libreria() {
		super();
		this.libreria = new ArrayList<Libro>();
		this.addLB("hola", "adios", "asdfqwerbasd1", Tema.Poesia, "150", "150", "Cartone", "nuevo", "15");
		this.addLB("hola", "adios", "asdfqwergafd1", Tema.Poesia, "150", "150", "Cartone", "nuevo", "15");
		this.addLB("hola", "adios", "as5fqwergasd1", Tema.Poesia, "150", "150", "Cartone", "nuevo", "15");
		this.addLB("hola", "adios", "asdfxwergasd1", Tema.Poesia, "150", "150", "Cartone", "nuevo", "15");
		this.addLB("hola", "adios", "asdfzwergasd1", Tema.Poesia, "150", "150", "Cartone", "nuevo", "15");
	}

	public void addLB(String titulo, String autor, String isbn, Tema tema, String numeroPag, String precio,
			String checkTipe, String checkStatus, String cantidad) {
		this.libreria.add(new Libro(titulo, autor, isbn, tema, numeroPag, precio, checkTipe, checkStatus,cantidad));
	}

	public void deleteLB(Libro deleteLB) {
		ArrayList<Libro> toRemove = new ArrayList<Libro>();
		for (Libro libro : libreria) {
			if (libro.equals(deleteLB)) {
				toRemove.add(libro);
			}
		}
		this.libreria.removeAll(toRemove);
	}

	public Libro getBook(String isbn) {
		Libro selected = null;
		for (Libro libro : libreria) {
			if (libro.compareLb(isbn)) {
				selected = libro;
			}
		}
		return selected;
	}
	public void aumentarCantidad(int cantidad,String isbn) {
		getBook(isbn).aumentarCantidad(cantidad);
	}

	public boolean compareIsbn(String isbn) {
		boolean selected = false;
		for (Libro libro : libreria) {
			if (libro.compareLb(isbn)) {
				selected = true;
			}
		}
		return selected;
	}

	public String[][] addFila() {
		String[][] retorno = new String[this.libreria.size()][9];
		int index = 0;
		for (Libro lib : this.libreria) {
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
		return libreria;
	}
}
