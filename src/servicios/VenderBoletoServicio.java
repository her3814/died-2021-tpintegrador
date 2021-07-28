package servicios;

import java.util.ArrayList;
import java.util.List;

import bdd.EstacionesRepo;
import bdd.TramosRepo;
import modelo.Estacion;
import modelo.Tramo;
import modelo.TramosFunciones;

public class VenderBoletoServicio {

	public static void main(String[] args) {
		var eA=EstacionesRepo.ObtenerEstacion(47);
		var eB=EstacionesRepo.ObtenerEstacion(51);
		
		var boleto = VenderBoletoServicio.CalcularCaminoMasBarato(eA,eB);
		System.out.println(boleto);
	}
	
	public static List<Tramo> CalcularCaminoMenorDistancia(Estacion origen, Estacion destino) {
		if (origen.equals(destino))
			return null;

		List<Tramo> destinos = TramosRepo.ObtenerDestinosDesde(origen);

		if (destinos == null)
			return null;

		List<List<Tramo>> caminos = new ArrayList<List<Tramo>>();

		destinos.forEach(d -> {
			List<Tramo> camino = new ArrayList<Tramo>();
			if (d.getDestino().equals(destino)) {
				camino.add(d);
				caminos.add(camino);
			} else {
				var caminoSiguiente = CalcularCaminoMenorDistancia(d.getDestino(), destino);
				if (caminoSiguiente != null && caminoSiguiente.size() > 0) {
					camino.add(d);
					camino.addAll(caminoSiguiente);
					caminos.add(camino);
				}
			}
		});

		if (caminos.size() == 0)
			return null;
		if (caminos.size() == 1)
			return caminos.get(0);

		return TramosFunciones.obtenerRecorridoMenorDistancia.apply(caminos);
	}

	public static List<Tramo> CalcularCaminoMasBarato(Estacion origen, Estacion destino) {


		if (origen.equals(destino))
			return null;

		List<Tramo> destinos = TramosRepo.ObtenerDestinosDesde(origen);

		if (destinos == null)
			return null;
	

		List<List<Tramo>> caminos = new ArrayList<List<Tramo>>();

		destinos.forEach(d -> {
			System.out.println(d);
			List<Tramo> camino = new ArrayList<Tramo>();
			if (d.getDestino().equals(destino)) {
				camino.add(d);
				caminos.add(camino);
			} else {
				var caminoSiguiente = CalcularCaminoMasBarato(d.getDestino(), destino);
				if (caminoSiguiente != null && caminoSiguiente.size() > 0) {
					camino.add(d);
					camino.addAll(caminoSiguiente);
					caminos.add(camino);
				}
			}
		
		});

		
		if (caminos.size() == 0) {
			return null;
		}else if (caminos.size() == 1) {
			return caminos.get(0);

		}else {
			return TramosFunciones.obtenerRecorridoMasBarato.apply(caminos);
		}
			
		

	}

	public static List<Tramo> CalcularCaminoMasRapido(Estacion origen, Estacion destino) {

		if (origen.equals(destino))
			return null;

		List<Tramo> destinos = TramosRepo.ObtenerDestinosDesde(origen);

		if (destinos == null)
			return null;

		List<List<Tramo>> caminos = new ArrayList<List<Tramo>>();

		destinos.forEach(d -> {
			List<Tramo> camino = new ArrayList<Tramo>();
			if (d.getDestino().equals(destino)) {
				camino.add(d);
				caminos.add(camino);
			} else {
				var caminoSiguiente = CalcularCaminoMasRapido(d.getDestino(), destino);
				if (caminoSiguiente != null && caminoSiguiente.size() > 0) {
					camino.add(d);
					camino.addAll(caminoSiguiente);
					caminos.add(camino);
				}
			}
		});
		System.out.println(caminos);

		if (caminos.size() == 0)
			return null;
		if (caminos.size() == 1)
			return caminos.get(0);

		return TramosFunciones.obtenerRecorridoMasRapido.apply(caminos);
	}

	public static List<List<Tramo>> CalcularCaminos(Estacion origen) {
	
		List<Tramo> destinos = TramosRepo.ObtenerDestinosDesde(origen);

		if (destinos == null)
			return null;

		List<List<Tramo>> caminos = new ArrayList<List<Tramo>>();

		destinos.forEach(d -> {
			if (d.getDestino().equals(origen)) {
				List<Tramo> camino = new ArrayList<Tramo>();
				camino.add(d);
				caminos.add(camino);
			} else {
				var camino = CalcularCaminos(d.getDestino());
				
			}
		});

		return caminos;
	}
}
