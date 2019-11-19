package test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import Modelo.Libro;
import Modelo.Tema;
import control.Control;

class ControlTest {
	Control instance = new Control();

	@Test
	void testCompareISBN() {
		String tocompare = instance.getLib().get(0).getISBN();
		assertTrue(instance.compareISBN(tocompare));
	}

	@Test
	void testAumentarCantidad() {
		String isbn = instance.getLib().get(0).getISBN();
		int cantidad = 15;
		try {
			instance.aumentarCantidad(isbn, 15);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String cantidadFinal = instance.getLib().get(0).getCantidad();
		assertTrue(cantidadFinal == instance.getLib().get(0).getCantidad());
	}

	@Test
	void testGetLibro() {
		Libro toCompare = instance.getLibro(instance.getLib().get(0).getISBN());
		assertEquals(toCompare, instance.getLib().get(0));
	}

	@Test
	void testDeleteBook() {
		String isbn = instance.getLib().get(0).getISBN();
		try {
			instance.deleteBook(isbn);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertFalse(instance.getLib().contains(instance.getLibro(isbn)));
	}

	@Test
	void testAddLib() throws IOException {
		instance.addLb("holasda", "adasdios", "asdfzrrrgasd1", "drama", "15000", "15000", "Cartone",
				"nuevo", "15");
		assertTrue(instance.compareISBN("asdfzrrrgasd1"));
	}

}
