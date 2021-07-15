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
	
	public static TareaMantenimiento AgregarTareaMantenimiento(TareaMantenimiento tarea) {
		String sql = "INSERT INTO estaciones_tareas_mantenimiento (id_estacion, fecha_inicio, fecha_fin, observaciones) VALUES(?, ?, ?, ?)";
		Connection con = BddSingleton.GetConnection();

		TareaMantenimiento nTarea = null;

		try {
			PreparedStatement pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstm.setInt(1, tarea.getEstacion().getId());
			pstm.setDate(2, Date.valueOf(tarea.getFechaInicio()));
			
			if(tarea.getFechaFin() != null)
				pstm.setDate(3, Date.valueOf(tarea.getFechaFin()));
			else pstm.setNull(3, java.sql.Types.DATE);
			
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

	private static TareaMantenimiento ToEntity(ResultSet res) {
		TareaMantenimiento tarea = null;

		try {
			tarea = new TareaMantenimiento(res.getInt("id"), EstacionesRepo.ObtenerEstacion(res.getInt("id_estacion")),
					res.getDate("fecha_inicio").toLocalDate(), res.getDate("fecha_fin") != null ? res.getDate("fecha_fin").toLocalDate() : null,
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
