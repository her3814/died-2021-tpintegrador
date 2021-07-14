package servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import bdd.TramosRepo;
import modelo.Estacion;
import modelo.Tramo;

public class VenderBoletoServicio {

	public List<Tramo> CalcularCaminoMenorDistancia(Estacion origen, Estacion destino) {
		if (origen.equals(destino))
			return null;

		List<Tramo> destinos = TramosRepo.ObtenerDestinosDesde(origen);

		if (destinos == null)
			return null;

		List<List<Tramo>> caminos = new ArrayList<List<Tramo>>();

		destinos.forEach(d -> {
			if (d.getDestino().equals(destino)) {
				List<Tramo> camino = new ArrayList<Tramo>();
				camino.add(d);
				caminos.add(camino);
			} else
				caminos.add(CalcularCaminoMasBarato(d.getDestino(), origen));
		});

		Function<List<Tramo>, Double> CalcularDistanciaCamino = (r) -> {
			return r.stream().mapToDouble(T -> T.getDistancia()).sum();
		};

		return caminos.stream().min((a, b) -> CalcularDistanciaCamino.apply(a).compareTo(CalcularDistanciaCamino.apply(b)))
				.orElse(null);
	}

	public List<Tramo> CalcularCaminoMasBarato(Estacion origen, Estacion destino) {

		if (origen.equals(destino))
			return null;

		List<Tramo> destinos = TramosRepo.ObtenerDestinosDesde(origen);

		if (destinos == null)
			return null;

		List<List<Tramo>> caminos = new ArrayList<List<Tramo>>();

		destinos.forEach(d -> {
			if (d.getDestino().equals(destino)) {
				List<Tramo> camino = new ArrayList<Tramo>();
				camino.add(d);
				caminos.add(camino);
			} else
				caminos.add(CalcularCaminoMasBarato(d.getDestino(), origen));
		});

		Function<List<Tramo>, Double> CalcularCostoCamino = (r) -> {
			return r.stream().mapToDouble(T -> T.getCosto()).sum();
		};

		return caminos.stream().min((a, b) -> CalcularCostoCamino.apply(a).compareTo(CalcularCostoCamino.apply(b)))
				.orElse(null);

	}

	public List<Tramo> CalcularCaminoMasRapido(Estacion origen, Estacion destino) {
		if (origen.equals(destino))
			return null;

		List<Tramo> destinos = TramosRepo.ObtenerDestinosDesde(origen);

		if (destinos == null)
			return null;

		List<List<Tramo>> caminos = new ArrayList<List<Tramo>>();

		destinos.forEach(d -> {
			if (d.getDestino().equals(destino)) {
				List<Tramo> camino = new ArrayList<Tramo>();
				camino.add(d);
				caminos.add(camino);
			} else {
				var camino = CalcularCaminoMasRapido(d.getDestino(), origen);
				if (camino != null)
					caminos.add(CalcularCaminoMasRapido(d.getDestino(), origen));
			}
		});

		Function<List<Tramo>, Double> CalcularDuracionCamino = (r) -> {
			return r.stream().mapToDouble(T -> T.getDuracion()).sum();
		};

		return caminos.stream()
				.min((a, b) -> CalcularDuracionCamino.apply(a).compareTo(CalcularDuracionCamino.apply(b))).orElse(null);
	}

	public List<List<Tramo>> CalcularCaminos(Estacion origen, Estacion destino) {
		return null;

	}
}
