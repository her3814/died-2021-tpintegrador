package excepciones;

public class FechaFinMenorFechaInicioException extends Exception {

	public FechaFinMenorFechaInicioException() {
		super("La fecha de fin es menor a la fecha de inicio. Acción no permitida.");
	}
}
