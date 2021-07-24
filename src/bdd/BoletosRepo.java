package bdd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modelo.Boleto;
import modelo.Estacion;
import modelo.Tramo;

public class BoletosRepo {
	public static void GuardarBoleto(Boleto boleto) {
		String sql = "INSERT INTO boletos (nombre_cliente, correo_cliente, fecha_venta, costo, nombre_estacion_origen, nombre_estacion_fin) VALUES (?, ?, ?, ?, ?, ?);";
		String sqlInsertRecorridoBoleto = "INSERT INTO boleto_recorrido (boleto_numero, boleto_recorrido_orden, trayecto_linea_id, trayecto_orden) VALUES (?, ?, ?, ?);";

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
				stm.setInt(1, t.getLinea().get_id());
				stm.setInt(2, t.getOrden());
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

	private static Boleto ToEntity(ResultSet r) {
		Boleto boleto = null;
		try {
			boleto = new Boleto(r.getInt("numero"), r.getString("nombre_cliente"), r.getString("correo_cliente"),
					r.getDate("fecha_venta").toLocalDate(), r.getDouble("costo"), r.getString("nombre_estacion_origen"),
					r.getString("nombre_estacion_fin"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return boleto;
	}

}
