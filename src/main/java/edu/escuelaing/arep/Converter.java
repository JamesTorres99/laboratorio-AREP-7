package edu.escuelaing.arep;

/**
 * Clase converter que convierte los valores en grados celsius
 * @author Alexander Torres
 *
 */
public class Converter {

	/**
	 * Metodo principal de la clase converter
	 */
	public Converter() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Metodo que convierte a grados celsius
	 * @param valor valor a convertir
	 * @return valor en grados celcius
	 */
	 public static Integer Convertir (Integer valor){
	        valor=(valor-32)* 5/9;
	        return valor;
	    }
}
