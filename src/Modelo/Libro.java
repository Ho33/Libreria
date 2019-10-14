package Modelo;

public class Libro {

	private String titulo;
	private String autor;
	private String isbn;
	private Tema tema;
	private String numeroPag;
	private String precio;
	private String formato;
	private String estado;
	private String cantidad;

	public Libro(String titulo, String autor, String iSBN, Tema tema, String numeroPag,String precio, String formato,
			String estado,String cantidad) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = iSBN;
		this.tema = tema;
		this.numeroPag = numeroPag;
		this.formato = formato;
		this.estado = estado;
		this.precio = precio;
		this.cantidad = cantidad;
	}
	

	public Libro() {
		super();
	}


	public boolean compareLb(String isbnLb) {
		return this.isbn.equals(isbnLb);
	}
	
	public void aumentarCantidad(int cantidad) {
		cantidad = Integer.parseInt(this.cantidad) + cantidad;
		this.cantidad = String.valueOf(cantidad);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Libro other = (Libro) obj;
		return isbn.equals(other.isbn);
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

	public Tema getTema() {
		return tema;
	}

	public String getNumeroPag() {
		return numeroPag;
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


	public void setTema(Tema tema) {
		this.tema = tema;
	}


	public void setNumeroPag(String numeroPag) {
		this.numeroPag = numeroPag;
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
