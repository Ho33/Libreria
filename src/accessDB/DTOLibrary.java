package accessDB;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import javax.swing.JOptionPane;

import Modelo.Libro;

public class DTOLibrary {

	private String id = "root";
	private String password = "";
	private String nameDB;
	private DAO dao;

	public DTOLibrary(String nombreBaseDatos) {
		this.nameDB = "jdbc:mysql://localhost/" + nombreBaseDatos;
		this.dao = new DAO(id, password, nameDB);
	}

	public boolean save(Libro libro) throws IOException {
		try {
			return dao.executeUpdate(sqlInsertBook(libro));
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Internal Error or Sql error");
			return false;
		}
	}

	public ArrayList<Libro> readBooks() throws IllegalAccessException {
		ArrayList<Libro> books = new ArrayList<Libro>();
		CachedRowSet cachedRowSet = null;
		try {
			cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
			cachedRowSet.populate(dao.executeSelect(sqlGetBooks()));
			while (cachedRowSet.next()) {
				books.add(crearLibroDesdeResultSet(cachedRowSet.getOriginalRow()));
			}
			cachedRowSet.close();
		} catch (SQLException | IOException | IllegalArgumentException | SecurityException e) {
			JOptionPane.showMessageDialog(null, "Internal Error");
		}
		return books;
	}

	private String sqlInsertBook(Libro obLibro) {
		return "INSERT INTO `libro` (`isbn`, `titulo`, `autor`, `tema`, `numeroPags`, `formato`, `estado`, `precio`, `cantidad`) VALUES ('"
				+ obLibro.getISBN() + "' , '" + obLibro.getTitulo() + "' , '" + obLibro.getAutor() + "' , '"
				+ obLibro.getTema() + "' , '" + obLibro.getNumeroPag() + "' , '" + obLibro.getFormato() + "' , '"
				+ obLibro.getEstado() + "' , '" + obLibro.getPrecio() + "' , '" + obLibro.getCantidad() + "');";
	}

	public void sqlDeleteBook(String isbn) {
		this.executeUpdate("DELETE FROM LIBRO WHERE isbn = " + isbn);
	}

	private Libro crearLibroDesdeResultSet(ResultSet resultSet)
			throws IOException, SQLException, IllegalArgumentException, IllegalAccessException, SecurityException {
		HashMap<String, Object> datosLibro = new HashMap<>();
		if (resultSet.first()) {
			for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
				datosLibro.put(resultSet.getMetaData().getColumnName(i), resultSet.getObject(i));
			}
			return new Libro(datosLibro);
		}
		return null;
	}

	public Libro sqlSearchBook(String isbn) {
		CachedRowSet cachedRowSet;
		String consulta = "SELECT * FROM `libro` WHERE `isbn` = '" + isbn + "'";
		try {
			cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
			cachedRowSet.populate(dao.executeSelect(consulta));
			while (cachedRowSet.next()) {
				return new Libro(cachedRowSet.getString("titulo"), cachedRowSet.getString("autor"),
						cachedRowSet.getString("isbn"), cachedRowSet.getString("tema"),
						cachedRowSet.getString("numeroPags"), cachedRowSet.getString("precio"),
						cachedRowSet.getString("formato"), cachedRowSet.getString("estado"),
						cachedRowSet.getString("cantidad"));
			}
			cachedRowSet.close();
		} catch (SQLException | IOException | IllegalArgumentException | SecurityException e) {
			JOptionPane.showMessageDialog(null, "Internal Error");
			return null;
		}
		return null;
	}

	private String sqlGetBooks() {
		return "SELECT * FROM `libro` ";
	}

	public void sqlModifyBook(Libro libro) {
		this.executeUpdate("UPDATE `LIBRO` SET `autor`='" + libro.getAutor() + "',`titulo`='" + libro.getTitulo()
				+ "',`tema`='" + libro.getTema() + "',`cantidad`='" + libro.getCantidad() + "',`numeroPags`='"
				+ libro.getNumeroPag() + "',`formato`='" + libro.getFormato() + "',`estado`='" + libro.getEstado()
				+ "',`precio`='" + libro.getPrecio() + "' WHERE ISBN = '" + libro.getISBN() + "' ");
	}

	public void modifyFields(String isbn, String field, String value) {
		this.executeUpdate("UPDATE LIBRO SET " + field + " = " + value + " WHERE isbn = " + isbn);
	}

	private void executeUpdate(String consulta) {
		try {
			this.dao.executeUpdate(consulta);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}