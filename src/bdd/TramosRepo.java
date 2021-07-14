package bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Estacion;
import modelo.EstadoTramoEnum;
import modelo.Linea;
import modelo.Tramo;

public class TramosRepo {

	public static void GuardarTramo(Tramo tramo) {
		String sql = "INSERT INTO tabla (id_linea_transporte, trayecto_orden, "
				+ "id_estacion_origen, id_estacion_destino, cant_pasajeros, duracion_min, costo, "
				+ "distancia, estado) " + "VALUES (? , ?, ?, ?, ?, ?, ?, ?, ?) " + "ON DUPLICATE KEY UPDATE "
				+ "id_linea_transporte = ?, trayecto_orden = ?, "
				+ "id_estacion_origen = ?, id_estacion_destino = ?, cant_pasajeros = ? , duracion_min = ?, costo = ?, "
				+ "distancia = ?, estado = ?;";

		Connection con = BddSingleton.GetConnection();
		
		try {
			con.beginRequest();
			PreparedStatement stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stm.setInt(1, tramo.getLinea().get_id());
			stm.setInt(2, tramo.getOrden());
			stm.setInt(3, tramo.getOrigen().getId());
			stm.setInt(4, tramo.getDestino().getId());
			stm.setInt(5, tramo.get_cantPasajeros());
			stm.setDouble(6, tramo.getDuracion());
			stm.setDouble(7, tramo.getCosto());
			stm.setDouble(8, tramo.getDistancia());
			stm.setString(9, tramo.get_estadoTramo() == EstadoTramoEnum.ACTIVO ? "ACT" : "INA");
			stm.setInt(10, tramo.getLinea().get_id());
			stm.setInt(11, tramo.getOrden());
			stm.setInt(12, tramo.getOrigen().getId());
			stm.setInt(13, tramo.getDestino().getId());
			stm.setInt(14, tramo.get_cantPasajeros());
			stm.setDouble(15, tramo.getDuracion());
			stm.setDouble(16, tramo.getCosto());
			stm.setDouble(17, tramo.getDistancia());
			stm.setString(18, tramo.get_estadoTramo() == EstadoTramoEnum.ACTIVO ? "ACT" : "INA");

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

	public static List<Tramo> ObtenerRecorrido(Linea linea) {
		List<Tramo> res = new ArrayList<Tramo>();
		String sql = "SELECT * FROM lineas_trayecto WHERE id_linea_transporte = ?";
		Connection con = BddSingleton.GetConnection();

		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, linea.get_id());
			ResultSet result = stm.executeQuery();

			while (result.next()) {
				res.add(ToEntity(result));
			}

			result.close();
			stm.close();

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

		return res;
	}

	public static List<Tramo> ObtenerDestinosDesde(Estacion origen) {
		List<Tramo> res = new ArrayList<Tramo>();
		String sql = "SELECT * FROM lineas_trayecto WHERE id_estacion_origen = ?";
		Connection con = BddSingleton.GetConnection();

		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, origen.getId());
			ResultSet result = stm.executeQuery();
			while (result.next()) {
				res.add(ToEntity(result));
			}

			result.close();
			stm.close();
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

		return res;
	}

	public static Tramo ToEntity(ResultSet result) {

		Tramo tramo = null;

		try {
			Linea linea = null; // LineasRepo.ObtenerLinea(result.getInt("id_linea_transporte"));
			Integer orden = result.getInt("trayecto_orden");
			Estacion origen = EstacionesRepo.ObtenerEstacion(result.getInt("id_estacion_origen"));
			Estacion destino = EstacionesRepo.ObtenerEstacion(result.getInt("id_estacion_destino"));
			Integer cant_pasajeros = result.getInt("cant_pasajeros");
			Double duracion = result.getDouble("duracion_min");
			Double costo = result.getDouble("costo");
			Double distancia = result.getDouble("distancia");
			EstadoTramoEnum estado = result.getString("estado").equals("ACT") ? EstadoTramoEnum.ACTIVO
					: EstadoTramoEnum.INACTIVO;

			tramo = new Tramo(linea, orden, origen, destino, cant_pasajeros, duracion, distancia, costo, estado);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tramo;
	}

}
