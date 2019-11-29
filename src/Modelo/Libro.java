package Modelo;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

public class Libro implements Serializable {

	private String titulo;
	private String autor;
	private String isbn;
	private String tema;
	private String numeroPags;
	private String precio;
	private String formato;
	private String estado;
	private String cantidad;
	
	
	public Libro(HashMap<String, Object> datosLibro) throws IllegalArgumentException, IllegalAccessException, SecurityException {
	    Field[] declaredFields = this.getClass().getDeclaredFields();
	    for (int i = 0; i < declaredFields.length; i++) {
	      declaredFields[i].set(this, datosLibro.get(declaredFields[i].getName()));
	    }
	  }

	public Libro(String titulo, String autor, String iSBN, String tema, String numeroPag, String precio, String formato,
			String estado, String cantidad) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = iSBN;
		this.tema = tema;
		this.numeroPags = numeroPag;
		this.formato = formato;
		this.estado = estado;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public boolean compareLb(String isbnLb) {
		return this.isbn.equals(isbnLb);
	}

	public void aumentarCantidad(int cantidad) {
		if (cantidad > 0) {
			cantidad = Integer.parseInt(this.cantidad) + cantidad;
			this.cantidad = String.valueOf(cantidad);
		}
	}

	public void deleteCantidad(int cantidad) {
		int result = Integer.parseInt(this.cantidad) - cantidad;
		if (result >= 0) {
			this.cantidad = String.valueOf(result);
		}else {
			this.cantidad = "0";
		}
	}



	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public String getISBN() {
		return isbn;
	}

	public String getTema() {
		return tema;
	}

	public String getNumeroPag() {
		return numeroPags;
	}

	public String getFormato() {
		return formato;
	}

	public String getEstado() {
		return estado;
	}

	public String getPrecio() {
		return precio;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public void setNumeroPag(String numeroPag) {
		this.numeroPags = numeroPag;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
