package accessDB;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

public class DTOTema {
	private String id = "root";
	private String password = "";
	private String nameDB;
	private DAO dao;

	public DTOTema(String nombreBaseDatos) {
		this.nameDB = "jdbc:mysql://localhost/" + nombreBaseDatos;
		this.dao = new DAO(id, password, nameDB);
	}

	public ArrayList<String> read()
			throws IOException, SQLException, IllegalArgumentException, IllegalAccessException, SecurityException {
		ArrayList<String> temas = new ArrayList<>();
		CachedRowSet cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
		cachedRowSet.populate(dao.executeSelect(sqlGetThemes()));
		while (cachedRowSet.next()) {
			temas.add(cachedRowSet.getString(1));
		}
		cachedRowSet.close();
		return temas;
	}

	private String sqlGetThemes() {
		return "SELECT * FROM `tema` ";
	}

	public boolean saveTheme(String tema) throws IOException {
		try {
			return dao.executeUpdate(sqlInsertTheme(tema));
		} catch (SQLException e) {
			return false;
		}
	}

	private String sqlInsertTheme(String tema) {
		return "INSERT INTO `tema` (`tema`) VALUES ('" + tema + "');";
	}

	public boolean deleteTheme(String tema) throws IOException {
		try {
			return dao.executeUpdate(sqlDeleteTheme(tema));
		} catch (SQLException e) {
			return false;
		}
	}

	private String sqlDeleteTheme(String tema) {
		return "DELETE FROM `tema` WHERE `tema` = '" + tema + "'";
	}
}
