package modelo;

import java.util.List;
import java.util.function.Function;

public class TramosFunciones {
	public static Function<List<Tramo>, Double> calcularCostoRecorrido = x -> x.stream()
			.mapToDouble(t -> t.getCosto()).sum();

	public static Function<List<Tramo>, Double> calcularDuracionRecorrido = x -> x.stream()
			.mapToDouble(t -> t.getDuracion()).sum();

	public static Function<List<Tramo>, Double> calcularDistanciaRecorrido = x -> x.stream().mapToDouble(t -> t.getDistancia()).sum();
	
	public static Function<List<List<Tramo>>, List<Tramo>> obtenerRecorridoMasBarato = x -> x.stream()
			.min((a,b)-> calcularCostoRecorrido.apply(a).compareTo(calcularCostoRecorrido.apply(b))).orElse(null);

	public static Function<List<List<Tramo>>, List<Tramo>> obtenerRecorridoMenorDistancia = x -> x.stream()
			.min((a,b)-> calcularDistanciaRecorrido.apply(a).compareTo(calcularDistanciaRecorrido.apply(b))).orElse(null);

	public static Function<List<List<Tramo>>, List<Tramo>> obtenerRecorridoMasRapido = x -> x.stream()
			.min((a,b)-> calcularDuracionRecorrido.apply(a).compareTo(calcularDuracionRecorrido.apply(b))).orElse(null);
}
