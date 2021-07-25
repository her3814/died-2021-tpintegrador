package modelo;

import java.util.ArrayList;
import java.util.List;

public enum ColoresLineasEnum {
	verde_claro	,
	verde,
	naranja,
	azul,
	rojo,
	amarillo,
	lila,
	marron,
	turquesa;
	
	public static List<String> valores (){
		List<String> retorno = new ArrayList<String>();
		retorno.add(verde_claro.toString());
		retorno.add(verde.toString());
		retorno.add(naranja.toString());
		retorno.add(azul.toString());
		retorno.add(rojo.toString());
		retorno.add(amarillo.toString());
		retorno.add(lila.toString());
		retorno.add(marron.toString());
		retorno.add(turquesa.toString());
		return retorno;
	}
}

