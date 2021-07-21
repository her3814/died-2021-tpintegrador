package bdd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import excepciones.FechaFinMenorFechaInicioException;
import modelo.Estacion;
import modelo.TareaMantenimiento;

public class TareaMantenimientoRepo {

	public static void EliminarTareaMantenimiento(TareaMantenimiento tarea) {
		String sql = "DELETE FROM estaciones_tareas_mantenimiento WHERE id = ?;";
		Connection con = BddSingleton.GetConnection();

		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, tarea.getId());

			con.beginRequest();

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
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void ModificarTareaMantenimiento(TareaMantenimiento tarea) {
		String sql = "UPDATE estaciones_tareas_mantenimiento SET id_estacion = ?, fecha_inicio = ? , fecha_fin = ?, observaciones = ? WHERE id = ?";
		Connection con = BddSingleton.GetConnection();

		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, tarea.getEstacion().getId());
			pstm.setDate(2, Date.valueOf(tarea.getFechaInicio()));

			if (tarea.getFechaFin() != null)
				pstm.setDate(3, Date.valueOf(tarea.getFechaFin()));
			else
				pstm.setNull(3, java.sql.Types.DATE);

			pstm.setString(4, tarea.getObservaciones());
			pstm.setInt(5, tarea.getId());

			con.beginRequest();

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
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static TareaMantenimiento AgregarTareaMantenimiento(TareaMantenimiento tarea) {
		String sql = "INSERT INTO estaciones_tareas_mantenimiento (id_estacion, fecha_inicio, fecha_fin, observaciones) VALUES(?, ?, ?, ?)";
		Connection con = BddSingleton.GetConnection();

		TareaMantenimiento nTarea = null;

		try {
			PreparedStatement pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstm.setInt(1, tarea.getEstacion().getId());
			pstm.setDate(2, Date.valueOf(tarea.getFechaInicio()));

			if (tarea.getFechaFin() != null)
				pstm.setDate(3, Date.valueOf(tarea.getFechaFin()));
			else
				pstm.setNull(3, java.sql.Types.DATE);

			pstm.setString(4, tarea.getObservaciones());

			con.beginRequest();

			pstm.executeUpdate();

			ResultSet rs = pstm.getGeneratedKeys();
			rs.next();

			nTarea = new TareaMantenimiento(rs.getInt(1), tarea.getEstacion(), tarea.getFechaInicio(),
					tarea.getFechaFin(), tarea.getObservaciones());

			con.commit();
			rs.close();
			pstm.close();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (FechaFinMenorFechaInicioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return nTarea;
	}

	public static List<TareaMantenimiento> Obtener(Estacion estacion) {
		String sql = "SELECT * FROM estaciones_tareas_mantenimiento WHERE id_estacion = ?;";

		Connection con = BddSingleton.GetConnection();

		List<TareaMantenimiento> tareas = new ArrayList<TareaMantenimiento>();

		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, estacion.getId());
			ResultSet res = pstm.executeQuery();

			while (res.next())
				tareas.add(ToEntity(res));

			res.close();
			pstm.close();

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if (!con.isClosed())
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return tareas;
	}

	public static List<TareaMantenimiento> Obtener() {
		String sql = "SELECT * FROM estaciones_tareas_mantenimiento;";

		Connection con = BddSingleton.GetConnection();

		List<TareaMantenimiento> tareas = new ArrayList<TareaMantenimiento>();

		try {
			PreparedStatement pstm = con.prepareStatement(sql);

			ResultSet res = pstm.executeQuery();

			while (res.next())
				tareas.add(ToEntity(res));

			res.close();
			pstm.close();

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if (!con.isClosed())
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return tareas;
	}

	/**
	 * Devuelve la tarea de mantenimiento activa de una estación
	 * @param estacion Estación de la cual se desea conocer la tarea de mantenimiento activa
	 * @return Tarea de mantenimiento activa. null si no existe una tarea de mantenimiento activa
	 */
	public static TareaMantenimiento ObtenerActiva(Estacion estacion) {
		String sql = "SELECT * FROM estaciones_tareas_mantenimiento\r\n" + " WHERE \r\n"
				+ " fecha_inicio IS NOT NULL \r\n" + " AND fecha_inicio <= current_date()\r\n"
				+ " && (fecha_fin IS NULL OR (fecha_fin > current_date()))" + " AND id_estacion = ?";

		var con = BddSingleton.GetConnection();
		TareaMantenimiento tarea = null;
		try {
			var pstm = con.prepareStatement(sql);
			pstm.setInt(1, estacion.getId());

			var res = pstm.executeQuery();
			if (res.next()) {
				tarea = ToEntity(res);
			}
			res.close();
			pstm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return tarea;
	}

	private static TareaMantenimiento ToEntity(ResultSet res) {
		TareaMantenimiento tarea = null;

		try {
			tarea = new TareaMantenimiento(res.getInt("id"), EstacionesRepo.ObtenerEstacion(res.getInt("id_estacion")),
					res.getDate("fecha_inicio").toLocalDate(),
					res.getDate("fecha_fin") != null ? res.getDate("fecha_fin").toLocalDate() : null,
					res.getString("observaciones"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FechaFinMenorFechaInicioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tarea;
	}
}
