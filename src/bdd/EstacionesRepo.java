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

public class EstacionesRepo {

	public static void EliminarEstacion(Estacion estacion) {
		String sql = "DELETE FROM estaciones WHERE id = ?;";
		Connection con = BddSingleton.GetConnection();
		try {
			con.beginRequest();
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, estacion.getId());
			stm.executeUpdate();
			con.commit();
			stm.close();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void ActualizarEstacion(Estacion estacion) {
		String sql = "UPDATE estaciones SET nombre = ?, hora_apertura = ?, hora_cierre = ?, estado = ? WHERE id = ?";
		Connection con = BddSingleton.GetConnection();
		try {
			con.beginRequest();
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, estacion.getNombre());
			pstm.setTime(2, Time.valueOf(estacion.getHorarioApertura()));
			pstm.setTime(3, Time.valueOf(estacion.getHorarioCierre()));
			pstm.setString(4, estacion.getEstado() == EstadoEstacionEnum.OPERATIVA ? "OPE" : "MAN");
			pstm.setInt(5, estacion.getId());

			pstm.executeUpdate();

			con.commit();
			pstm.close();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static Integer AgregarEstacion(Estacion estacion) {
		String sql = "INSERT INTO estaciones (nombre, hora_apertura, hora_cierre, estado) VALUES(?, ?, ?, ?)";
		Connection con = BddSingleton.GetConnection();
		Integer auto_id = null;
		try {
			con.beginRequest();
			PreparedStatement stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stm.setString(1, estacion.getNombre());
			stm.setTime(2, Time.valueOf(estacion.getHorarioApertura()));
			stm.setTime(3, Time.valueOf(estacion.getHorarioCierre()));
			stm.setString(4, estacion.getEstado() == EstadoEstacionEnum.OPERATIVA ? "OPE" : "MAN");
			stm.executeUpdate();

			con.commit();

			ResultSet rs = stm.getGeneratedKeys();
			rs.next();
			auto_id = rs.getInt(1);

			rs.close();
			stm.close();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return auto_id;
	}

	public static List<Estacion> ObtenerEstaciones() {
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

	public static Estacion ObtenerEstacion(int id) {

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

	public static List<Estacion> ObtenerEstaciones(EstacionesFiltro filtro) {
		List<Estacion> estaciones = new ArrayList<Estacion>();

		if (filtro.esVacio())
			return estaciones;

		String sql = "SELECT * FROM estaciones";

		List<String> sqlWhere = new ArrayList<String>();

		// Si el filtro posee alguno de los parametros lo sumo a un arreglo de Strings
		// el cual luego se unira con 'AND'
		if (filtro.id != null)
			sqlWhere.add(" id = ? ");
		if (filtro.nombre != null)
			sqlWhere.add(" nombre = ? ");
		if (filtro.horaAperturaDesde != null)
			sqlWhere.add(" hora_apertura >= ? ");
		if (filtro.horaAperturaHasta != null)
			sqlWhere.add(" hora_apertura <= ? ");
		if (filtro.horaCierreDesde != null)
			sqlWhere.add(" hora_cierre >= ? ");
		if (filtro.horaCierreHasta != null)
			sqlWhere.add(" hora_cierre <= ? ");
		if (filtro.estado != null)
			sqlWhere.add(" estado = ? ");

		// Actualizo el sql con el comando WHERE y los parametros de filtrado
		sql = sql + " WHERE " + String.join(" AND ", sqlWhere) + ";";

		Connection con = BddSingleton.GetConnection();
		try {
			PreparedStatement pstm;

			pstm = con.prepareStatement(sql);

			Integer i = 1;
			// Por cada parametro, asignandolos en el mismo orden que se agregaron al WHERE,
			// si no es nulo, lo seteo y sumo un valor a i, a fin de aumentar la posicion
			// del valor en el statement
			if (filtro.id != null)
				pstm.setInt(i++, filtro.id);
			if (filtro.nombre != null)
				pstm.setString(i++, filtro.nombre);
			if (filtro.horaAperturaDesde != null)
				pstm.setTime(i++, Time.valueOf(filtro.horaAperturaDesde));
			if (filtro.horaAperturaHasta != null)
				pstm.setTime(i++, Time.valueOf(filtro.horaAperturaHasta));
			if (filtro.horaCierreDesde != null)
				pstm.setTime(i++, Time.valueOf(filtro.horaCierreDesde));
			if (filtro.horaCierreHasta != null)
				pstm.setTime(i++, Time.valueOf(filtro.horaCierreHasta));
			if (filtro.estado != null)
				pstm.setString(i++, filtro.estado == EstadoEstacionEnum.OPERATIVA ? "OPE" : "MAN");

			ResultSet result = pstm.executeQuery();
			// Mientras la consulta devuelva resultados, se convierte a una entidad del
			// modelo y se agrega al listado de resultados
			while (result.next())
				estaciones.add(ToEntity(result));

			result.close();
			pstm.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return estaciones;
	}

	private static Estacion ToEntity(ResultSet res) {
		Estacion estacion = null;
		try {

			Integer id = res.getInt("id");
			String nombre = res.getString("nombre");
			LocalTime hora_ape = res.getTime("hora_apertura").toLocalTime();
			LocalTime hora_cie = res.getTime("hora_cierre").toLocalTime();
			EstadoEstacionEnum estado = res.getString("estado").toUpperCase().equals("OPE") ? EstadoEstacionEnum.OPERATIVA
					: EstadoEstacionEnum.MANTENIMIENTO;

			estacion = new Estacion(id, nombre, hora_ape, hora_cie, estado);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return estacion;
	}

}
