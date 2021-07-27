package bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import modelo.Boleto;
import modelo.Estacion;
import modelo.EstadoLineaEnum;
import modelo.EstadoTramoEnum;
import modelo.Linea;
import modelo.Tramo;

public class TramosRepo {

	/**
	 * Guarda o actualiza el tramo de una linea, si ya existe un tramo con la
	 * posicion indicada, el mismo es reemplazado con la nueva información
	 * 
	 * @param tramo Tramo a agregar o actualizar
	 */
	public static void GuardarRecorrido(Linea linea, Tramo[] recorrido) {

		LimpiarRecorrido(linea);

		for (var t : recorrido) {
			GuardarTramo(t);
		}

	}
	
	public static Boolean estacionEstaEnUnTramo(Estacion est) {
		List<Tramo> tramos = TramosRepo.obtenerTramos();
		List<Estacion> origenes = new ArrayList<Estacion>();
		origenes = tramos.stream().map(t -> t.getOrigen()).filter(e -> e.equals(est)).collect(Collectors.toList());
		List<Estacion> destinos =  new ArrayList<Estacion>();
		destinos = tramos.stream().map(t -> t.getDestino()).filter(e -> e.equals(est)).collect(Collectors.toList());
		return (origenes.size()==0 ||destinos.size()==0);
	}
	
	public static void ModificarTramo(Tramo tramo) {
		String sql = "UPDATE lineas_trayecto SET cant_pasajeros = ?, duracion_min = ?, costo = ?, distancia = ?, estado = ? "
				+ "WHERE id_linea_transporte = ? AND trayecto_orden = ?";

		Connection con = BddSingleton.GetConnection();

		try {
			con.beginRequest();
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, tramo.get_cantPasajeros());
			pstm.setDouble(2, tramo.getDuracion());
			pstm.setDouble(3, tramo.getCosto());
			pstm.setDouble(4, tramo.getDuracion());
			pstm.setString(5, tramo.get_estadoTramo().equals(EstadoTramoEnum.ACTIVO) ? "ACT" : "INA");
			pstm.setInt(6, tramo.getLinea().get_id());
			pstm.setInt(7, tramo.getOrden());

			pstm.executeUpdate();

			con.commit();
			pstm.close();

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
				con.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static List<Tramo> ObtenerDeBoleto(Boleto boleto){
		String sql = "SELECT t.* FROM boleto_recorrido AS b INNER JOIN lineas_trayecto AS t " +
					 "ON (trayecto_linea_id = id_linea_transporte AND b.trayecto_orden = t.trayecto_orden) "
					 + " WHERE b.boleto_numero = ? ORDER BY b.boleto_recorrido_orden";
		
		List<Tramo> res = new ArrayList<Tramo>();
		
		Connection con = BddSingleton.GetConnection();
		
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, boleto.get_nroBoleto());
			
			var r = pstm.executeQuery();
			
			while(r.next())
			{
				res.add(ToEntity(r));
			}
			
			r.close();
			pstm.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return res;		
	}
	
	
	
	/**
	 * Elimina todo el recorrido que realiza una linea
	 * 
	 * @param estacion
	 */
	public static void LimpiarRecorrido(Linea linea) {
		String sql = "DELETE FROM lineas_trayecto WHERE id_linea_transporte = ?";
		Connection con = BddSingleton.GetConnection();
		try {
			con.beginRequest();
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, linea.get_id());
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
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void EliminarTramo(Tramo tramo) {
		String sql = "DELETE FROM lineas_trayecto WHERE id_linea_transporte = ? AND trayecto_orden = ?";
		Connection con = BddSingleton.GetConnection();
		try {
			con.beginRequest();
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, tramo.getLinea().get_id());
			pstm.setInt(2, tramo.getOrden());
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
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void GuardarTramo(Tramo tramo) {
		String sql = "INSERT INTO lineas_trayecto (id_linea_transporte, trayecto_orden, "
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

	/**
	 * Devuelve 
	 * 
	 * @param origen
	 * @return
	 */
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

	private static Tramo ToEntity(ResultSet result) {

		Tramo tramo = null;

		try {
			Linea linea = LineasRepo.ObtenerLinea(result.getInt("id_linea_transporte"));
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
	

	public static List<Tramo> obtenerTramos() {
		List<Tramo> tramos = new ArrayList<Tramo>();

		String sql = "select * FROM lineas_trayecto";

		Connection con = BddSingleton.GetConnection();

		try {
			Statement stm;
			stm = con.createStatement();
			ResultSet result = stm.executeQuery(sql);

			// MIENTRAS QUEDEN COLUMNAS, SE PROCESAN Y AGREGAN A LA LISTA DE ESTACIONES
			while (result.next())
				tramos.add(ToEntity(result));

			result.close();
			stm.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return tramos;

	}
	
	public static Tramo obtenerTramo(Integer orden, Integer linea) {

		Tramo tramo = null;
		String sql = "select * FROM lineas_trayecto est WHERE id_linea_transporte = ? AND trayecto_orden =? ;";

		Connection con = BddSingleton.GetConnection();
		try {
			PreparedStatement pstm;

			pstm = con.prepareStatement(sql);
			pstm.setInt(1, linea);
			pstm.setInt(2, orden);

			ResultSet result = pstm.executeQuery();

			// SE ESPERA UN SOLO RESULTADO, POR LO QUE SOLO SE HACE UN NEXT, SI NO HAY UN
			// NEXT NO SE ASIGNA NADA, ES DECIR, NO EXISTE UNA ESTACION CON EL ID INDICADO
			if (result.next())
				tramo = ToEntity(result);

			result.close();
			pstm.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tramo;
	}
	
	
}
