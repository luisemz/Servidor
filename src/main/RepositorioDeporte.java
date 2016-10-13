package main;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RepositorioDeporte {

	private Connection conexion = null;

	/**
	 * Metodo creador
	 */
	public RepositorioDeporte() {
		ConexionBD.iniciarConexion();
		this.conexion = ConexionBD.getConexion();
	}

	public Deporte findDeporte(String nombre) {
		Deporte deporte = null;
		try {
			String sql = "SELECT * FROM Deporte WHERE Nombre='"+nombre+"'";
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			rs.first();
			deporte = new Deporte(rs.getString("Nombre"));
			stmt.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error en buscar Deporte");
		}
		return deporte;
	}
}