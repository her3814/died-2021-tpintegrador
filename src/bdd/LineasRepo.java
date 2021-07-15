package bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.EstadoLineaEnum;
import modelo.Linea;
import modelo.LineaTipoTransporteEnum;

public class LineasRepo {

	public static void ModificarLinea(Linea linea) {
		//TODO Modificar Linea
	}
	
	public static void AgregarLinea(Linea linea) {
		String sql = "INSERT INTO lineas_transporte (nombre, color, estado, tipo_trasnporte) VALUES (?, ?, ?, ?);";
		
		
		Connection con = BddSingleton.GetConnection();
		
		try {
			con.beginRequest();
			PreparedStatement pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstm.setString(1, linea.get_nombre());
			pstm.setString(2, linea.get_color());
			pstm.setString(3, linea.get_estado().equals(EstadoLineaEnum.ACTIVA) ? "ACT" : "INA");
			pstm.setString(4, linea.get_tipoTransporte().name());
			
			pstm.executeUpdate();

			con.commit();

			ResultSet rs = pstm.getGeneratedKeys();
			rs.next();
			linea = new Linea(rs.getInt(1), linea.get_nombre(), linea.get_color(), linea.get_estado(), linea.get_tipoTransporte());

			rs.close();
			pstm.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
				con.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}				
	}
	
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

		return lineas;
	}

	private static Linea ToEntity(ResultSet res) {
		Linea linea = null;
		try {
			linea = new Linea(res.getInt("id"), res.getString("nombre"), res.getString("color"),
					res.getString("estado").equals("ACT") ? EstadoLineaEnum.ACTIVA : EstadoLineaEnum.NO_ACTIVA,
					LineaTipoTransporteEnum.valueOf(res.getString("tipo_transporte")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return linea;
	}
}
