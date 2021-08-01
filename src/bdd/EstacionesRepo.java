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

import excepciones.HoraCierreMenorHoraAperturaException;
import filtros.EstacionesFiltro;
import modelo.Estacion;
import modelo.EstadoEstacionEnum;
import modelo.Linea;

public class EstacionesRepo {

	/**
	 * Elimina la estacion indicada de la base de datos
	 * 
	 * @param estacion Estacion a eliminar
	 */
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
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				con.close();
				BddInMemoryCache.getCacheInstance().remove("ESTACION-" + estacion.getId());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Modifica la estacion indicada. Para alterar su estado se deberá de realizar a
	 * traves del ABM de Tareas de Mantenimiento
	 * 
	 * @param estacion Estacion a modificar
	 */

	public static void ModificarEstacion(Estacion estacion) {
		String sql = "UPDATE estaciones SET nombre = ?, hora_apertura = ?, hora_cierre = ?  WHERE id = ?";
		Connection con = BddSingleton.GetConnection();

		try {
			con.beginRequest();
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, estacion.getNombre());
			pstm.setTime(2, Time.valueOf(estacion.getHorarioApertura()));
			pstm.setTime(3, Time.valueOf(estacion.getHorarioCierre()));
			pstm.setInt(4, estacion.getId());

			pstm.executeUpdate();

			con.commit();
			pstm.close();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				con.close();
				BddInMemoryCache.getCacheInstance().put("ESTACION-" + estacion.getId(), estacion);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * Agrega una nueva estacion (debe ir sin ID), en caso de indicarse este será
	 * ignorado.
	 * 
	 * @param estacion
	 * @return
	 */
	public static Estacion AgregarEstacion(Estacion estacion) {
		String sql = "INSERT INTO estaciones (nombre, hora_apertura, hora_cierre) VALUES(?, ?, ?)";
		Connection con = BddSingleton.GetConnection();
		Estacion nEst = null;

		try {
			con.beginRequest();

			PreparedStatement stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stm.setString(1, estacion.getNombre());
			stm.setTime(2, Time.valueOf(estacion.getHorarioApertura()));
			stm.setTime(3, Time.valueOf(estacion.getHorarioCierre()));

			stm.executeUpdate();
			con.commit();

			ResultSet rs = stm.getGeneratedKeys();
			rs.next();

			nEst = new Estacion(rs.getInt(1), estacion.getNombre(), estacion.getHorarioApertura(),
					estacion.getHorarioCierre(), estacion.getEstado());
			rs.close();
			stm.close();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (HoraCierreMenorHoraAperturaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
				BddInMemoryCache.getCacheInstance().put("ESTACION-" + nEst.getId(), nEst);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		BddInMemoryCache.getCacheInstance().put("ESTACION-" + nEst.getId(), nEst);
		return nEst;
	}

	public static List<Estacion> ObtenerEstaciones() {
		List<Estacion> estaciones = new ArrayList<Estacion>();

		String sql = "select *, NOT EXISTS (SELECT * " + "FROM estaciones_tareas_mantenimiento etm "
				+ "WHERE etm.id_estacion = est.id " + "AND "
				+ "((fecha_fin is not null and  CURRENT_DATE() >= fecha_inicio and fecha_fin > CURRENT_DATE()) OR "
				+ "(fecha_fin is null and CURRENT_DATE() >= fecha_inicio))) AS estado " + "FROM estaciones est;";

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

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				for (Estacion e : estaciones) {
					BddInMemoryCache.getCacheInstance().put("ESTACION-" + e.getId(), e);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return estaciones;

	}

	public static Estacion ObtenerEstacion(int id) {

		if (BddInMemoryCache.getCacheInstance().contains("ESTACION-" + id)) {
			return (Estacion) BddInMemoryCache.getCacheInstance().get("ESTACION-" + id);
		}

		Estacion estacion = null;
		String sql = "select *, NOT EXISTS (SELECT * " + "FROM estaciones_tareas_mantenimiento etm "
				+ "WHERE etm.id_estacion = est.id " + "AND "
				+ "((fecha_fin is not null and  CURRENT_DATE() >= fecha_inicio and fecha_fin > CURRENT_DATE()) OR "
				+ "(fecha_fin is null and CURRENT_DATE() >= fecha_inicio))) AS estado "
				+ "FROM estaciones est WHERE id = ?;";

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
			e.printStackTrace();
		}

		BddInMemoryCache.getCacheInstance().put("ESTACION-" + id, estacion);

		return estacion;
	}

	public static List<Estacion> ObtenerEstaciones(EstacionesFiltro filtro) {
		List<Estacion> estaciones = new ArrayList<Estacion>();

		if (filtro.esVacio())
			return ObtenerEstaciones();

		String sql = "SELECT *, NOT EXISTS (SELECT * " + "FROM estaciones_tareas_mantenimiento etm "
				+ "WHERE etm.id_estacion = est.id " + "AND "
				+ "((fecha_fin is not null and  CURRENT_DATE() >= fecha_inicio and fecha_fin > CURRENT_DATE()) OR "
				+ "(fecha_fin is null and CURRENT_DATE() >= fecha_inicio))) AS estado " + "FROM estaciones est ";

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
		if (filtro.estado != null) {
			String sqlEstado = " EXISTS (SELECT * " + "FROM estaciones_tareas_mantenimiento etm "
					+ "WHERE etm.id_estacion = est.id " + "AND "
					+ "((fecha_fin is not null and  CURRENT_DATE() >= fecha_inicio and fecha_fin > CURRENT_DATE()) OR "
					+ "(fecha_fin is null and CURRENT_DATE() >= fecha_inicio))) ";
			if (filtro.estado == EstadoEstacionEnum.OPERATIVA)
				sqlEstado = "NOT" + sqlEstado;
			sqlWhere.add(sqlEstado);
		}
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

			ResultSet result = pstm.executeQuery();
			// Mientras la consulta devuelva resultados, se convierte a una entidad del
			// modelo y se agrega al listado de resultados
			while (result.next())
				estaciones.add(ToEntity(result));

			result.close();
			pstm.close();
			con.close();
		} catch (SQLException e) {
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
			EstadoEstacionEnum estado = res.getBoolean("estado") ? EstadoEstacionEnum.OPERATIVA
					: EstadoEstacionEnum.MANTENIMIENTO;
			// TODO Cargar el estado de la estacion en base a las tareas de mantenimiento.
			estacion = new Estacion(id, nombre, hora_ape, hora_cie, estado);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (HoraCierreMenorHoraAperturaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return estacion;
	}

	public static Estacion ObtenerUltimoDestino(Linea linea) {
		var sql = "SELECT *, NOT EXISTS (SELECT * FROM estaciones_tareas_mantenimiento etm \r\n"
				+ "				WHERE etm.id_estacion = est.id AND \r\n"
				+ "				((fecha_fin is not null and  CURRENT_DATE() >= fecha_inicio and fecha_fin > CURRENT_DATE()) OR \r\n"
				+ "				(fecha_fin is null and CURRENT_DATE() >= fecha_inicio))) AS estado \r\n"
				+ "FROM estaciones AS est,\r\n" + "				lineas_trayecto trl\r\n"
				+ "				WHERE est.id = trl.id_estacion_destino\r\n"
				+ "				AND trl.trayecto_orden = (SELECT MAX(trayecto_orden)\r\n"
				+ "				FROM lineas_trayecto as ltr\r\n"
				+ "				WHERE ltr.id_linea_transporte = trl.id_linea_transporte \r\n"
				+ "				GROUP BY id_linea_transporte)\r\n" + "				AND id_linea_transporte = ?;";

		Estacion estacion = null;
		Connection con = BddSingleton.GetConnection();
		try {
			PreparedStatement pstm;

			pstm = con.prepareStatement(sql);
			pstm.setInt(1, linea.get_id());

			ResultSet result = pstm.executeQuery();

			if (result.next())
				estacion = ToEntity(result);

			result.close();
			pstm.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return estacion;
	}
}
