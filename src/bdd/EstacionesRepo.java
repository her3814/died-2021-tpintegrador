package bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import modelo.Estacion;
import modelo.EstadoEstacionEnum;

public interface EstacionesRepo {

	public static List<Estacion> getEstaciones() {
		List<Estacion> estaciones = new ArrayList<Estacion>();

		String sql = "SELECT * FROM estaciones";

		Connection con = BddSingleton.GetConnection();
		try {
			Statement stm;

			stm = con.createStatement();

			ResultSet result = stm.executeQuery(sql);

			// MIENTRAS QUEDEN COLUMNAS, SE PROCESAN Y AGREGAN A LA LISTA DE ESTACIONES
			while (result.next())
				estaciones.add(ToEntity(result));

			result.close();
			stm.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return estaciones;

	}

	public static Estacion getEstacion(int id) {

		Estacion estacion = null;
		String sql = "SELECT * FROM estaciones WHERE id = ?;";

		Connection con = BddSingleton.GetConnection();
		try {
			PreparedStatement pstm;

			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);

			ResultSet result = pstm.executeQuery();

			// SE ESPERA UN SOLO RESULTADO, POR LO QUE SOLO SE HACE UN NEXT, SI NO HAY UN
			// NEXT NO SE ASIGNA NADA, ES DECIR, NO EXISTE UNA ESTACION CON EL ID INDICADO
			if (result.next())
				estacion = ToEntity(result);

			result.close();
			pstm.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return estacion;
	}

	private static Estacion ToEntity(ResultSet res) {
		Estacion estacion = null;
		try {

			Integer id = res.getInt("id");
			String nombre = res.getString("nombre");
			LocalTime hora_ape = res.getTime("hora_apertura").toLocalTime();
			LocalTime hora_cie = res.getTime("hora_cierre").toLocalTime();
			EstadoEstacionEnum estado = res.getString("estado") == "OPE" ? EstadoEstacionEnum.OPERATIVA
					: EstadoEstacionEnum.MANTENIMIENTO;

			estacion = new Estacion(id, nombre, hora_ape, hora_cie, estado);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return estacion;
	}
}
