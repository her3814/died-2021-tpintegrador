package excepciones;

public class HoraCierreMenorHoraAperturaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HoraCierreMenorHoraAperturaException() {
		super("La hora de cierre es anterior a la hora de apertura.");
	}
}
