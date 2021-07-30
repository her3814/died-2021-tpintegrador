package servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import bdd.EstacionesRepo;
import bdd.TramosRepo;
import modelo.Estacion;
import modelo.Tramo;
import modelo.TramosFunciones;

public class VenderBoletoServicio {

	public static void main(String[] args) {
		var eA = EstacionesRepo.ObtenerEstacion(47);
		var eB = EstacionesRepo.ObtenerEstacion(51);

		var boleto = VenderBoletoServicio.CalcularCaminoMenorDistancia(eA, eB);
		System.out.println(boleto);
	}

	private static List<Tramo> CalcularCamino(Estacion origen, Estacion destino,
			List<Estacion> recorridas, Function<List<List<Tramo>>, List<Tramo>> funcion) {
		if (origen.equals(destino))
			return null;

		//Si ya se paso por esta estacion, se corta el algoritmo a fin de evitar bucles
		if (recorridas.contains(origen))
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
				var recAux =  recorridas.stream().collect(Collectors.toList());
				recAux.add(origen);
				var caminoSiguiente = CalcularCamino(d.getDestino(), destino, recAux, funcion);
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

		return funcion.apply(caminos);

	}

	public static List<Tramo> CalcularCaminoMenorDistancia(Estacion origen, Estacion destino) {		

		return CalcularCamino(origen, destino, new ArrayList<Estacion>(), TramosFunciones.obtenerRecorridoMenorDistancia);
	
	}

	public static List<Tramo> CalcularCaminoMasBarato(Estacion origen, Estacion destino) {

		return CalcularCamino(origen, destino, new ArrayList<Estacion>(), TramosFunciones.obtenerRecorridoMasBarato);

	}

	public static List<Tramo> CalcularCaminoMasRapido(Estacion origen, Estacion destino) {

		return CalcularCamino(origen, destino, new ArrayList<Estacion>(), TramosFunciones.obtenerRecorridoMasRapido);
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
