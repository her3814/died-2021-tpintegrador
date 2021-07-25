package bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import modelo.Estacion;
import modelo.EstadoLineaEnum;
import modelo.Linea;
import modelo.LineaTipoTransporteEnum;
import modelo.Tramo;

public class LineasRepo {
	private static String sql ;
	private static Connection con;

	public static void EliminarLinea(Linea linea) {
		String sql = "DELETE FROM lineas_transporte WHERE id = ?";

		Connection con = BddSingleton.GetConnection();

		try {
			con.beginRequest();
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, linea.get_id());

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

	public static void ModificarLinea(Linea linea) {
		String sql = "UPDATE lineas_transporte SET nombre = ?, color = ?, estado = ?, tipo_transporte = ? WHERE id = ?";

		Connection con = BddSingleton.GetConnection();

		try {
			con.beginRequest();
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, linea.get_nombre());
			pstm.setString(2, linea.get_color());
			pstm.setString(3, linea.get_estado().equals(EstadoLineaEnum.ACTIVA) ? "ACT" : "INA");
			pstm.setString(4, linea.get_tipoTransporte().name());

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

	public static Linea AgregarLinea(Linea linea) {
		String sql = "INSERT INTO lineas_transporte (nombre, color, estado, tipo_transporte) VALUES (?, ?, ?, ?);";

		Connection con = BddSingleton.GetConnection();
		Linea nLinea = null;

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
			nLinea = new Linea(rs.getInt(1), linea.get_nombre(), linea.get_color(), linea.get_estado(),
					linea.get_tipoTransporte());

			rs.close();
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

		return nLinea;
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
		List<Linea> lineas = new ArrayList<Linea>();
		/*Runnable obtenerLineas =()->{
			sql = "SELECT * FROM lineas_transporte;";
			con = BddSingleton.GetConnection();
		};
		Thread t1= new Thread(obtenerLineas, "Obtener lineas");
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
*/
		sql = "SELECT * FROM lineas_transporte;";
		con = BddSingleton.GetConnection();
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
	
	public static Integer siguienteOrden(Linea l) {
		 return TramosRepo.ObtenerRecorrido(l).size()+1;
	}
	
	public static Estacion ultimaEstacion(Linea l) {
		List<Estacion> finales= TramosRepo.ObtenerRecorrido(l).stream()
							.map(t -> t.getDestino())
							.collect(Collectors.toList());
		return finales.get(finales.size()-1);
	}
	
	public static Boolean pertenece(Estacion est, Linea l) {
		List<Tramo> tramos= TramosRepo.ObtenerRecorrido(l);
		if(tramos==null || tramos.size()==0) return false;
		if(est.equals(LineasRepo.ultimaEstacion(l))) {
			return false;
		}else {
			return 	tramos.stream()
					.map(t -> t.getOrigen())
					.filter(e -> e.equals(est))
					.collect(Collectors.toList()).size()>0
					||
					tramos.stream()
					.map(t -> t.getDestino())
					.filter(e -> e.equals(est))
					.collect(Collectors.toList()).size()>0;
		}
		
		
	}
}
