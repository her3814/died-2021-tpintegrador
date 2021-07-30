package bdd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import modelo.Boleto;
import modelo.Estacion;
import modelo.Tramo;
import modelo.TramoBoleto;

public class BoletosRepo {

	public static void GuardarBoleto(Boleto boleto) {
		String sql = "INSERT INTO boletos (nombre_cliente, correo_cliente, fecha_venta, costo, nombre_estacion_origen, nombre_estacion_fin) VALUES (?, ?, ?, ?, ?, ?);";
		String sqlInsertRecorridoBoleto = "INSERT INTO boleto_trayecto (boleto_numero, trayecto_orden, linea_nombre, linea_color, linea_tipo_transporte, estacion_origen_nombre, estacion_destino_nombre, trayecto_duracion_min, trayecto_costo, trayecto_distancia) VALUES (?,	?,	?,	?,	?,	?,	?,	?,	?,	?);";

		Connection con = BddSingleton.GetConnection();
		try {
			con.beginRequest();
			PreparedStatement stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			stm.setString(1, boleto.get_nombreCliente());
			stm.setString(2, boleto.get_correoCliente());
			stm.setDate(3, Date.valueOf(boleto.get_fechaVenta()));
			stm.setDouble(4, boleto.get_costo());
			stm.setString(5, boleto.get_origen());
			stm.setString(6, boleto.get_destino());

			stm.executeUpdate();
			ResultSet rs = stm.getGeneratedKeys();
			rs.next();

			int idBoleto = rs.getInt(1);

			stm.close();

			for (int i = 0; i < boleto.get_tramos().size(); i++) {
				var t = boleto.get_tramos().get(i);
				stm = con.prepareStatement(sqlInsertRecorridoBoleto);
				stm.setInt(1, idBoleto);
				stm.setInt(2, 1 + i);
				stm.setString(3, t.get_linea_nombre());
				stm.setString(4, t.get_linea_color());
				stm.setString(5, t.get_linea_tipo_transporte());
				stm.setString(6, t.get_estacion_origen_nombre());
				stm.setString(7, t.get_estacion_destino_nombre());
				stm.setDouble(8, t.get_trayecto_duracion_min());
				stm.setDouble(9, t.get_trayecto_costo());
				stm.setDouble(10, t.get_trayecto_distancia());
				stm.executeUpdate();
				stm.close();
			}

			con.commit();

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

	public static List<Boleto> ObtenerBoletos() {
		String sql = "SELECT * FROM boletos";
		Connection con = BddSingleton.GetConnection();
		List<Boleto> res = new ArrayList<Boleto>();
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			var r = pstm.executeQuery();

			while (r.next()) {
				res.add(ToEntity(r));
			}
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

	public static void EliminarBoleto(Boleto boleto) {
		String sql = "DELETE FROM boletos WHERE numero = ?";
		Connection con = BddSingleton.GetConnection();
		try {
			con.beginRequest();
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, boleto.get_nroBoleto());
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

	private static Boleto ToEntity(ResultSet r) {
		Boleto boleto = null;
		try {
			boleto = new Boleto(r.getInt("numero"), r.getString("correo_cliente"), r.getString("nombre_cliente"),
					r.getDate("fecha_venta").toLocalDate(), r.getDouble("costo"), r.getString("nombre_estacion_origen"),
					r.getString("nombre_estacion_fin"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return boleto;
	}

	public static List<TramoBoleto> ObtenerTramos(Boleto boleto) {
		String sql = "SELECT * FROM boleto_trayecto WHERE boleto_numero = ?";
		Connection con = BddSingleton.GetConnection();

		var res = new ArrayList<TramoBoleto>();

		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, boleto.get_nroBoleto());
			var reader = pstm.executeQuery();

			while (reader.next()) {
				res.add(ToTramoEntity(reader));
			}
			reader.close();
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

		return res;
	}

	private static TramoBoleto ToTramoEntity(ResultSet r) {
		// TODO Auto-generated method stub
		TramoBoleto entity = null;

		try {
			entity = new TramoBoleto(r.getInt("boleto_numero"), r.getInt("trayecto_orden"), r.getString("linea_nombre"),
					r.getString("linea_color"), r.getString("linea_tipo_transporte"),
					r.getString("estacion_origen_nombre"), r.getString("estacion_destino_nombre"),
					r.getDouble("trayecto_duracion_min"), r.getDouble("trayecto_costo"),
					r.getDouble("trayecto_distancia"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return entity;
	}

	public static Boleto Obtener(Integer nroBoleto) {
		String sql = "SELECT * FROM boletos WHERE numero = ?";
		Connection con = BddSingleton.GetConnection();
		Boleto res = null;
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, nroBoleto);
			var r = pstm.executeQuery();

			if (r.next()) {
				res = ToEntity(r);
			}
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

}
