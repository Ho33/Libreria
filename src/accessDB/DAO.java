package accessDB;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DAO {

	private String id;
	private String password;
	private String nameDB;
	private String driver = "com.mysql.jdbc.Driver";
	private static Connection conexion = null;

	public DAO(String id, String password, String nameDB) {
		this.id = id;
		this.password = password;
		this.nameDB = nameDB;
	}

	private Connection openConection() throws IOException {
		if (conexion == null) {
			try {
				Runtime.getRuntime().addShutdownHook(new closeConection());
				Class.forName(driver);
				conexion = (Connection) DriverManager.getConnection(this.nameDB, this.id, this.password);
				conexion.setAutoCommit(false);
				System.out.println("Abriendo conexion...");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		return conexion;
	}

	class closeConection extends Thread {
		@Override
		public void run() {
			try {
				openConection().close();
				System.out.println("... cerrando conexion");
			} catch (SQLException | IOException e) {
				JOptionPane.showMessageDialog(null, "Internal Error or Sql error");
			}
		}
	}

	private boolean commit(int resultado) throws SQLException {
		if (resultado == 1) {
			conexion.commit();
			return true;
		} else {
			conexion.rollback();
			return false;
		}
	}

	public boolean executeUpdate(String sql) throws IOException, SQLException {
		openConection();
		Statement myStatement = (Statement) conexion.createStatement();
		int resultado = myStatement.executeUpdate(sql);
		boolean retorno = commit(resultado);
		closeConection.currentThread();
		return retorno;
	}

	public ResultSet executeSelect(String sql) throws IOException, SQLException {
		openConection();
		Statement myStatement = (Statement) conexion.createStatement();
		ResultSet myResultSet = myStatement.executeQuery(sql);
		closeConection.currentThread();
		return myResultSet;
	}
}