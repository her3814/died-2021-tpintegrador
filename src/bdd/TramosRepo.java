package bdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Estacion;
import modelo.EstadoTramoEnum;
import modelo.Linea;
import modelo.Tramo;

public interface TramosRepo {

	public static List<Tramo> ObtenerRecorrido(Linea linea){
		List<Tramo> res = new ArrayList<Tramo>();
		var sql = "SELECT * FROM lineas_trayecto WHERE id_linea_transporte = ?";
		var con = BddSingleton.GetConnection();

		try {
			var stm = con.prepareStatement(sql);
			stm.setInt(1, linea.get_id());
			var result = stm.executeQuery();
			
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
		var sql = "SELECT * FROM lineas_trayecto WHERE id_estacion_origen = ?";
		var con = BddSingleton.GetConnection();

		try {
			var stm = con.prepareStatement(sql);
			stm.setInt(1, origen.getId());
			var result = stm.executeQuery();
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
			Integer id = result.getInt("id");
			Integer orden = result.getInt("trayecto_orden");
			Estacion origen = EstacionesRepo.ObtenerEstacion(result.getInt("id_estacion_origen"));
			Estacion destino = EstacionesRepo.ObtenerEstacion(result.getInt("id_estacion_destino"));
			Linea linea = null; // LineasRepo.ObtenerLinea(result.getInt("id_linea_transporte"));
			Integer cant_pasajeros = result.getInt("cant_pasajeros");
			Double duracion = result.getDouble("duracion_min");
			Double costo = result.getDouble("costo");
			Double distancia = result.getDouble("distancia");
			EstadoTramoEnum estado = result.getString("estado").equals("ACT") ? EstadoTramoEnum.ACTIVO
					: EstadoTramoEnum.INACTIVO;
			
			tramo = new Tramo(id, linea, origen, destino, orden, cant_pasajeros, duracion, distancia, costo, estado);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tramo;
	}

}
