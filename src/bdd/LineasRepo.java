package bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.EstadoLineaEnum;
import modelo.Linea;
import modelo.LineaTipoTransporteEnum;

public class LineasRepo {

	public static Linea ObtenerLinea(Integer id) {
		String sql = "SELECT * FROM lineas_transporte WHERE id = ?;";

		Connection con = BddSingleton.GetConnection();

		Linea linea = null;

		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet res = pstm.executeQuery();

			if (res.next())
				linea = ToEntity(res);

			res.close();
			pstm.close();

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				if (!con.isClosed())
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return linea;
	}

	public static List<Linea> ObtenerLineas() {
		String sql = "SELECT * FROM lineas_transporte;";

		Connection con = BddSingleton.GetConnection();

		List<Linea> lineas = new ArrayList<Linea>();

		try {
			PreparedStatement pstm = con.prepareStatement(sql);

			ResultSet res = pstm.executeQuery();

			while (res.next())
				lineas.add(ToEntity(res));

			res.close();
			pstm.close();

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				if (!con.isClosed())
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return lineas;
	}

	private static Linea ToEntity(ResultSet res) {
		Linea linea = null;
		try {
			linea = new Linea(res.getInt("id"), res.getString("nombre"), res.getString("color"),
					res.getString("estado").equals("ACT") ? EstadoLineaEnum.ACTIVA : EstadoLineaEnum.NO_ACTIVA,
					EstacionesRepo.ObtenerEstacion(res.getInt("id_estacion_origen")),
					EstacionesRepo.ObtenerEstacion(res.getInt("id_estacion_destino")),
					LineaTipoTransporteEnum.valueOf(res.getString("tipo_transporte")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return linea;
	}
}
