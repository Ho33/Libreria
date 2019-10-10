package Modelo;

public enum Tema {
	Poesia("Poesia"), Terror("Terror"), Drama("Drama"), Infantil("Infantil");
	
	private String nombre;

	private Tema(String nombre) {
		this.nombre = nombre;
	}
	 @Override
	public String toString() {
		return nombre.toString();
	}
}
