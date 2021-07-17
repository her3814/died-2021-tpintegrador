package excepciones;

public class HoraCierreMenorHoraAperturaException extends Exception {

	public HoraCierreMenorHoraAperturaException() {
		super("La hora de cierre es anterior a la hora de apertura.");
	}
}
