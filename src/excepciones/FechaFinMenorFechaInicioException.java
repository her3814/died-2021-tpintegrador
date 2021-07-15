package excepciones;

public class FechaFinMenorFechaInicioException extends Exception {

	private static final long serialVersionUID = -3858560615784298930L;

	public FechaFinMenorFechaInicioException() {
		super("La fecha de fin es menor a la fecha de inicio. Acci�n no permitida.");
	}
}
