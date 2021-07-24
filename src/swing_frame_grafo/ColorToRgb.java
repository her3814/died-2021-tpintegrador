package swing_frame_grafo;

import java.awt.Color;

import modelo.ColoresLineasEnum;

public abstract class ColorToRgb {
	public static Color GetRgb(ColoresLineasEnum color) {

		switch (color) {
		case amarillo:
			return Color.yellow;
		case azul:
			return Color.blue;
		case lila:
			return new Color(182, 149, 192);
		case marron:
			return new Color(141, 73, 37);
		case naranja:
			return Color.orange;
		case rojo:
			return Color.red;
		case turquesa:
			return new Color(93, 193, 185);
		case verde:
			return Color.green;
		case verde_claro:
			return new Color(144, 238, 144);
		default:
			return Color.black;

		}
	}
}
