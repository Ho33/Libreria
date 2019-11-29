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
	
	public ArrayList<String> leer()
			throws IOException, SQLException, IllegalArgumentException, IllegalAccessException, SecurityException {
		ArrayList<String> temas = new ArrayList<>();
		CachedRowSet cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
		cachedRowSet.populate(dao.executeSelect(sqlObtenerTemas()));
		while (cachedRowSet.next()) {
			temas.add(cachedRowSet.getString(1));
		}
		cachedRowSet.close();
		return temas;
	}
	
	private String sqlObtenerTemas() {
		return "SELECT * FROM `tema` ";
	}
}
